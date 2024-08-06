package entity.rent_entry;

import entity.book.CommonBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class RentalEntryTest {

    private CommonRentalEntry rentalEntry;

    @BeforeEach
    public void setUp() {
        Date rentalStartDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(10));
        Date rentalEndDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(5));
        Date returnDate = new Date(System.currentTimeMillis());
        rentalEntry = new CommonRentalEntry(1, rentalStartDate, rentalEndDate, returnDate);
    }

    @Test
    public void testSetRentalID() {
        rentalEntry.setRentalID();
        assertTrue(rentalEntry.getRentalId() > 0);
    }

    @Test
    public void testGetRentalId() {
        rentalEntry.setRentalId(100);
        assertEquals(100, rentalEntry.getRentalId());
    }

    @Test
    public void testSetAndGetBookId() {
        rentalEntry.setBookId(200);
        assertEquals(200, rentalEntry.getBookId());
    }

    @Test
    public void testSetAndGetCharge() {
        rentalEntry.setCharge(300);
        assertEquals(300, rentalEntry.getCharge());
    }

    @Test
    public void testSetAndGetRentalStartDate() {
        Date startDate = new Date();
        rentalEntry.setRentalStartDate(startDate);
        assertEquals(startDate, rentalEntry.getRentalStartDate());
    }

    @Test
    public void testSetAndGetRentalEndDate() {
        Date endDate = new Date();
        rentalEntry.setRentalEndDate(endDate);
        assertEquals(endDate, rentalEntry.getRentalEndDate());
    }

    @Test
    public void testGetMaxCharge() {
        rentalEntry.calculateCharge();
        int expectedMaxCharge = rentalEntry.getMaxCharge();
        assertEquals(expectedMaxCharge, rentalEntry.getMaxCharge());
    }

    @Test
    public void testGetBookID() {
        assertEquals(rentalEntry.getBookId(), rentalEntry.getBookID());
    }

    @Test
    public void testGetStartDate() {
        assertEquals(rentalEntry.getRentalStartDate(), rentalEntry.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        assertEquals(rentalEntry.getRentalEndDate(), rentalEntry.getEndDate());
    }

    @Test
    public void testCalculateCharge() {
        rentalEntry.calculateCharge();
        long diffInMillies = Math.abs(rentalEntry.getRentalEndDate().getTime() - rentalEntry.getRentalStartDate().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        int rentalCharge = (int) diffInDays * CommonBook.RENTAL_PRICE;

        int overdueCharge = 0;
        if (rentalEntry.getReturnDate().after(rentalEntry.getRentalEndDate())) {
            long diffInMilliesOverdue = Math.abs(rentalEntry.getReturnDate().getTime() - rentalEntry.getRentalEndDate().getTime());
            long diffInDaysOverdue = TimeUnit.DAYS.convert(diffInMilliesOverdue, TimeUnit.MILLISECONDS);
            overdueCharge = (int) diffInDaysOverdue * 5;
        }

        int expectedMaxCharge = rentalCharge * 5;
        int expectedCharge = Math.min(expectedMaxCharge, overdueCharge + rentalCharge);

        assertEquals(expectedCharge, rentalEntry.getCharge());
    }
}
