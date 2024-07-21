package use_case.rent_book.ReturnBook;

import com.google.gson.*;
import data_access.data_base_return_book.DataBaseReturnObejct;
import entity.rent_entry.RentalEntry;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static data.misc_info.FilePathConstants.RENTAL_TRANSACTION_FILE;
import static data.misc_info.FilePathConstants.TOTAL_BOOKS_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataBaseReturnObjectTest {

    private static final String TEMP_BOOK_FILE = TOTAL_BOOKS_FILE;
    private static final String TEMP_RENTAL_FILE = RENTAL_TRANSACTION_FILE;
    private DataBaseReturnObejct dataBaseReturnObejct;

    @BeforeEach
    void setUp() {
        dataBaseReturnObejct = new DataBaseReturnObejct();
        // Create a temporary book file with sample data
        try (FileWriter writer = new FileWriter(TEMP_BOOK_FILE)) {
            JSONObject sampleBookData = new JSONObject();
            JSONObject book = new JSONObject();
            book.put("bookID", 1L);
            book.put("End Date", "2023-01-01");
            book.put("Start Date", "2023-01-01");
            book.put("isRented", "true");
            book.put("BorrowerName", "John Doe");
            book.put("BorrowerNumber", "1234567890");
            sampleBookData.put("1", book);

            writer.write(sampleBookData.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an empty temporary rental file
        try (FileWriter writer = new FileWriter(TEMP_RENTAL_FILE)) {
            writer.write("[]");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testEditBookFile() {
        int bookID = 1;

        dataBaseReturnObejct.editBookFile(bookID);

        // Verify that the book data is updated correctly
        JSONObject bookData = dataBaseReturnObejct.readBookData();
        assertNotNull(bookData);

        JSONObject book = (JSONObject) bookData.get(String.valueOf(bookID));
        assertEquals("false", book.get("isRented"));
        assertEquals("", book.get("BorrowerName"));
        assertEquals("", book.get("BorrowerNumber"));
        assertEquals(null, book.get("End Date"));
        assertEquals(null, book.get("Start Date"));
    }

    @Test
    void testWriteReturnFile() {
        int bookID = 1;
        Date startDate = new Date(2023, 1, 1);
        Date endDate = new Date(2023, 1, 15);
        Date returnDate = new Date(2023, 1, 20);
        RentalEntry rentalEntry = new RentalEntry(bookID, startDate, endDate, returnDate);

        dataBaseReturnObejct.writeReturnFile(rentalEntry);

        // Verify that the return transaction is written correctly
        try {
            String content = new String(Files.readAllBytes(Paths.get(TEMP_RENTAL_FILE)));
            JsonElement jsonElement = JsonParser.parseString(content);
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            assertEquals(1, jsonArray.size());
            JsonElement transactionElement = jsonArray.get(0);
            RentalEntry writtenEntry = new Gson().fromJson(transactionElement, RentalEntry.class);

            assertEquals(bookID, writtenEntry.getBookID());
            assertEquals(startDate, writtenEntry.getStartDate());
            assertEquals(endDate, writtenEntry.getEndDate());
            assertEquals(returnDate, writtenEntry.getReturnDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
