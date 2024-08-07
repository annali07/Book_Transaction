package use_case.purchase_book;

import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import entity.purchase_entry.CommonTransactionEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DataCommonTransactionEntryDataAccessObjectTest {

    private DataTransactionEntryDataAccessObject dao;
    private final String testFilePath = "test_transactions.json";

    @BeforeEach
    void setUp() throws Exception {
        dao = new DataTransactionEntryDataAccessObject();

        // Use reflection to set the private FILE_PATH field
        Field filePathField = DataTransactionEntryDataAccessObject.class.getDeclaredField("FILE_PATH");
        filePathField.setAccessible(true);
        filePathField.set(dao, testFilePath);

        // Create a test file with some initial data
        String initialData = "[{\"transactionId\":1,\"bookId\":101,\"bookName\":\"Test CommonBook 1\",\"soldPrice\":29.99,\"date\":\"2023-07-15\"}]";
        Files.write(Paths.get(testFilePath), initialData.getBytes(), StandardOpenOption.CREATE);

    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(testFilePath));

    }

    @Test
    void testgetTransactionEntry() {
        CommonTransactionEntry entry = dao.getTransactionEntry(1);
        assertNotNull(entry);
        assertEquals(1, entry.getTransactionId());
        assertEquals(1, entry.getBookId());
        assertEquals("A Game of Thrones", entry.getBookName());
        assertEquals(99, entry.getSoldPrice());

    }

    @Test
    void testcreateTransactionEntry() {
        Date date = new Date(23, 6, 14);
        CommonTransactionEntry newEntry = new CommonTransactionEntry(2, "114514", 1111, date);
        boolean result = dao.createTransactionEntry(newEntry);

        assertTrue(result);

        CommonTransactionEntry retrievedEntry = dao.getTransactionEntry(2);
        assertNotNull(retrievedEntry);
        assertEquals(2, retrievedEntry.getTransactionId());
        assertEquals(1, retrievedEntry.getBookId());
        assertEquals("A Game of Thrones", retrievedEntry.getBookName());
        assertEquals(99, retrievedEntry.getSoldPrice());
    }

}
