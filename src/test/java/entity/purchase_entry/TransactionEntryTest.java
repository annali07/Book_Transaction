package entity.purchase_entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionEntryTest {

    private CommonTransactionEntry entry;

    @BeforeEach
    void setUp() {
        entry = new CommonTransactionEntry(1, "Test Book", 19.99, new Date());
    }

    @Test
    void testConstructorWithoutTransactionId() {
        CommonTransactionEntry entryWithoutId = new CommonTransactionEntry(2, "Another Book", 29.99, new Date());

        assertEquals(2, entryWithoutId.getBookId());
        assertEquals("Another Book", entryWithoutId.getBookName());
        assertEquals(29.99, entryWithoutId.getSoldPrice(), 0.01);
        assertNotNull(entryWithoutId.getDate());
    }

    @Test
    void testConstructorWithTransactionId() {
        CommonTransactionEntry entryWithId = new CommonTransactionEntry(100, 3, "Third Book", 39.99, new Date());

        assertEquals(100, entryWithId.getTransactionId());
        assertEquals(3, entryWithId.getBookId());
        assertEquals("Third Book", entryWithId.getBookName());
        assertEquals(39.99, entryWithId.getSoldPrice(), 0.01);
        assertNotNull(entryWithId.getDate());
    }

    @Test
    void testSetTransactionId() {
        entry.setTransactionId();
        assertTrue(entry.getTransactionId() > 0);
    }

    @Test
    void testGetAndSetBookId() {
        entry.setBookId(10);
        assertEquals(10, entry.getBookId());
    }

    @Test
    void testGetAndSetBookName() {
        entry.setBookName("Updated Book Name");
        assertEquals("Updated Book Name", entry.getBookName());
    }

    @Test
    void testGetAndSetSoldPrice() {
        entry.setSoldPrice(50);
        assertEquals(50, entry.getSoldPrice(), 0);
    }

    @Test
    void testGetAndSetDate() {
        Date newDate = new Date();
        entry.setDate(newDate);
        assertEquals(newDate, entry.getDate());
    }
}
