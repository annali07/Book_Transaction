package entity.rent_entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommonRentalEntryFactoryTest {

    private CommonRentalEntryFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new CommonRentalEntryFactory();
    }

    @Test
    public void testCreateRentalHistoryWithFourParameters() {
        int bookId = 1;
        Date rentalStartDate = new Date();
        Date rentalEndDate = new Date(System.currentTimeMillis() + 100000);
        Date returnDate = new Date(System.currentTimeMillis() + 200000);

        CommonRentalEntry entry = factory.createRentalHistory(bookId, rentalStartDate, rentalEndDate, returnDate);

        assertNotNull(entry);
        assertEquals(bookId, entry.getBookId());
        assertEquals(rentalStartDate, entry.getRentalStartDate());
        assertEquals(rentalEndDate, entry.getRentalEndDate());
        assertEquals(returnDate, entry.getReturnDate());
    }

    @Test
    public void testCreateRentalHistoryWithSevenParameters() {
        int rentalId = 1;
        int bookId = 2;
        int charge = 100;
        Date rentalStartDate = new Date();
        Date rentalEndDate = new Date(System.currentTimeMillis() + 100000);
        Date returnDate = new Date(System.currentTimeMillis() + 200000);
        int maxCharge = 500;

        CommonRentalEntry entry = factory.createRentalHistory(rentalId, bookId, charge, rentalStartDate, rentalEndDate, returnDate, maxCharge);

        assertNotNull(entry);
        assertEquals(rentalId, entry.getRentalId());
        assertEquals(bookId, entry.getBookId());
        assertEquals(charge, entry.getCharge());
        assertEquals(rentalStartDate, entry.getRentalStartDate());
        assertEquals(rentalEndDate, entry.getRentalEndDate());
        assertEquals(returnDate, entry.getReturnDate());
        assertEquals(maxCharge, entry.getMaxCharge());
    }
}
