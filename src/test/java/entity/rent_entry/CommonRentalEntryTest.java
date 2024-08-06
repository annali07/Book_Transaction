package entity.rent_entry;

import com.google.gson.JsonObject;
import data.misc_info.FilePathConstants;
import entity.book.CommonBook;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommonRentalEntryTest {

    private CommonRentalEntry rentalEntry;

    @BeforeEach
    public void setUp() {
        Date rentalStartDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(10));
        Date rentalEndDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(5));
        Date returnDate = new Date(System.currentTimeMillis());
        rentalEntry = new CommonRentalEntry(1, rentalStartDate, rentalEndDate, returnDate);
    }

    @Test
    public void testConstructorAndCalculateCharge() {
        rentalEntry.calculateCharge();
        long diffInDays = TimeUnit.DAYS.convert(Math.abs(rentalEntry.getRentalEndDate().getTime() - rentalEntry.getRentalStartDate().getTime()), TimeUnit.MILLISECONDS);
        int rentalCharge = (int) diffInDays * CommonBook.RENTAL_PRICE;

        long diffInDaysOverdue = TimeUnit.DAYS.convert(Math.abs(rentalEntry.getReturnDate().getTime() - rentalEntry.getRentalEndDate().getTime()), TimeUnit.MILLISECONDS);
        int overdueCharge = (int) diffInDaysOverdue * 5;

        int expectedCharge = Math.min(rentalCharge * 5, overdueCharge + rentalCharge);
        assertEquals(expectedCharge, rentalEntry.getCharge());
    }

    @Test
    public void testGettersAndSetters() {
        rentalEntry.setRentalId(100);
        assertEquals(100, rentalEntry.getRentalId());

        rentalEntry.setBookId(200);
        assertEquals(200, rentalEntry.getBookId());

        rentalEntry.setCharge(300);
        assertEquals(300, rentalEntry.getCharge());

        Date newStartDate = new Date();
        rentalEntry.setRentalStartDate(newStartDate);
        assertEquals(newStartDate, rentalEntry.getRentalStartDate());

        Date newEndDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5));
        rentalEntry.setRentalEndDate(newEndDate);
        assertEquals(newEndDate, rentalEntry.getRentalEndDate());
    }

}
