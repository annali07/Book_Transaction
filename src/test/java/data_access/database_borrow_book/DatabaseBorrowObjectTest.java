package data_access.database_borrow_book;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseBorrowObjectTest {

    private static final String TEST_FILE_PATH = "test_books.json";
    private DatabaseBorrowObject databaseBorrowObject;

    @BeforeEach
    void setUp() throws Exception {
        databaseBorrowObject = new DatabaseBorrowObject();
        createTestFile();
    }

    @Test
    void testWriteBorrowFile() {
        int bookID = 1;
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 86400000L);  // +1 day
        String borrowerName = "";
        String borrowerNumber = "";

        databaseBorrowObject.writeBorrowFile(bookID, startDate, endDate, borrowerName, borrowerNumber);

        JSONObject bookData = databaseBorrowObject.readBookData(TEST_FILE_PATH);
        assertNotNull(bookData);

        JSONObject book = (JSONObject) bookData.get("1");
        assertNotNull(book);
        assertEquals("false", book.get("isRented"));
        assertEquals(borrowerName, book.get("BorrowerName"));
        assertEquals(borrowerNumber, book.get("BorrowerNumber"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(dateFormat.format(startDate), book.get("Start Date"));
        assertEquals(dateFormat.format(endDate), book.get("End Date"));
    }

    @Test
    void testReadBookData() {
        JSONObject bookData = databaseBorrowObject.readBookData(TEST_FILE_PATH);
        assertNotNull(bookData);
        assertTrue(bookData.containsKey("1"));

        JSONObject book = (JSONObject) bookData.get("1");
        assertNotNull(book);
        assertEquals(1L, book.get("bookID"));
        assertEquals("Test Book", book.get("bookName"));
    }

    private void createTestFile() throws Exception {
        JSONObject bookData = new JSONObject();

        JSONObject book = new JSONObject();
        book.put("bookID", 1L);
        book.put("bookName", "Test Book");
        book.put("bookPrice", 19.99);
        book.put("isRented", "false");
        book.put("BorrowerName", "");
        book.put("BorrowerNumber", "");
        book.put("Start Date", "");
        book.put("End Date", "");

        bookData.put("1", book);

        try (FileWriter file = new FileWriter(TEST_FILE_PATH)) {
            file.write(bookData.toJSONString());
            file.flush();
        }
    }
}
