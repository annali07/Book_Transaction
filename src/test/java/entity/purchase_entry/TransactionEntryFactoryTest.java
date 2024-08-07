package entity.purchase_entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionEntryFactoryTest {

    private TransactionEntryFactory factory;

    @BeforeEach
    void setUp() {
        factory = new CommonTransactionEntryFactory();
    }

    @Test
    void testCreateCommonTransactionEntryWithoutTransactionId() {
        int bookId = 1;
        String bookName = "Test Book";
        double soldPrice = 19.99;
        Date date = new Date();

        CommonTransactionEntry entry = factory.createCommonTransactionEntry(bookId, bookName, soldPrice, date);

        assertNotNull(entry);
        assertEquals(bookId, entry.getBookId());
        assertEquals(bookName, entry.getBookName());
        assertEquals(soldPrice, entry.getSoldPrice(), 0.01);
        assertEquals(date, entry.getDate());
    }

    @Test
    void testCreateCommonTransactionEntryWithTransactionId() {
        int transactionId = 100;
        int bookId = 1;
        String bookName = "Test Book";
        double soldPrice = 19.99;
        Date date = new Date();

        CommonTransactionEntry entry = factory.createCommonTransactionEntry(transactionId, bookId, bookName, soldPrice, date);

        assertNotNull(entry);
        assertEquals(transactionId, entry.getTransactionId());
        assertEquals(bookId, entry.getBookId());
        assertEquals(bookName, entry.getBookName());
        assertEquals(soldPrice, entry.getSoldPrice(), 0.01);
        assertEquals(date, entry.getDate());
    }
}
