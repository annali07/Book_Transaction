package data.misc_info;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemproraryInfoTest {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    @BeforeEach
    void setUp() {
        Dotenv dotenv = Dotenv.load();
        String MONGO_URI = dotenv.get("MONGO_URI");
        String DATABASE_NAME = "Elysia";
        String COLLECTION_NAME = "books";

        mongoClient = MongoClients.create(MONGO_URI);
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);

        // Clear the collection before each test
        collection.drop();

        // Insert a test document
        Document testBook = new Document("bookID", 1)
                .append("bookName", "Test Book")
                .append("rentalStartDate", "2023-01-01")
                .append("rentalEndDate", "2023-01-10")
                .append("isRented", "false")
                .append("borrowerName", "John Doe")
                .append("borrowerNumber", "1234567890");
        collection.insertOne(testBook);
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        collection.drop();
        mongoClient.close();
    }

    @Test
    void testSetClassVariable() {
        TemproraryInfo.setClassVariable(1);
        assertEquals(1, TemproraryInfo.bookID);
        assertTrue(TemproraryInfo.dictionary.isEmpty());
    }

    @Test
    void testUpdate() {
        TemproraryInfo.setClassVariable(1);
        Map<String, String> bookInfo = TemproraryInfo.update();

        assertEquals("1", bookInfo.get("bookID"));
        assertEquals("Test Book", bookInfo.get("bookName"));
        assertEquals("2023-01-01", bookInfo.get("Start Date"));
        assertEquals("2023-01-10", bookInfo.get("End Date"));
        assertEquals("false", bookInfo.get("isRented"));
        assertEquals("John Doe", bookInfo.get("borrowerName"));
        assertEquals("1234567890", bookInfo.get("borrowerNumber"));
    }
}
