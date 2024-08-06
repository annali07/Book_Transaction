package data.misc_info;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TemproraryInfoTest {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    private static final String TEST_DATABASE_NAME = "TestElysia";
    private static final String TEST_COLLECTION_NAME = "test_books";
    private static final int TEST_BOOK_ID = 123;

    @BeforeAll
    static void setUpAll() {
        Dotenv dotenv = Dotenv.load();
        String MONGO_URI = dotenv.get("MONGO_URI");
        mongoClient = MongoClients.create(MONGO_URI);
        database = mongoClient.getDatabase(TEST_DATABASE_NAME);
        collection = database.getCollection(TEST_COLLECTION_NAME);

        // Insert a test document
        Document testBook = new Document("bookID", TEST_BOOK_ID)
                .append("bookName", "Test Book")
                .append("rentalStartDate", "2023-01-01")
                .append("rentalEndDate", "2023-12-31")
                .append("isRented", "Yes")
                .append("borrowerName", "John Doe")
                .append("borrowerNumber", "1234567890");
        collection.insertOne(testBook);
    }

    @AfterAll
    static void tearDownAll() {
        collection.drop();
        mongoClient.close();
    }

    @BeforeEach
    void setUp() {
        TemproraryInfo.setClassVariable(TEST_BOOK_ID);
    }

    @Test
    void testSetClassVariable() {
        int newBookID = 456;
        TemproraryInfo.setClassVariable(newBookID);
        assertEquals(newBookID, TemproraryInfo.bookID);
        assertTrue(TemproraryInfo.dictionary.isEmpty());
    }

    @Test
    void testUpdate() {
        Map<String, String> bookInfo = TemproraryInfo.update();
        assertNotNull(bookInfo);
        assertEquals(String.valueOf(TEST_BOOK_ID), bookInfo.get("bookID"));
        assertEquals("Test Book", bookInfo.get("bookName"));
        assertEquals("2023-01-01", bookInfo.get("Start Date"));
        assertEquals("2023-12-31", bookInfo.get("End Date"));
        assertEquals("Yes", bookInfo.get("isRented"));
        assertEquals("John Doe", bookInfo.get("borrowerName"));
        assertEquals("1234567890", bookInfo.get("borrowerNumber"));
    }
}
