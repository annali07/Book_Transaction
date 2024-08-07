package data_access.database_transaction_entry;

import entity.purchase_entry.CommonTransactionEntry;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DataTransactionEntryDataAccessObjectTest {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private DataTransactionEntryDataAccessObject dao;

    @BeforeEach
    void setUp() {
        Dotenv dotenv = Dotenv.load();
        String MONGO_URI = dotenv.get("MONGO_URI");
        String DATABASE_NAME = "Elysia";
        String COLLECTION_NAME = "purchasehistory";

        mongoClient = MongoClients.create(MONGO_URI);
        database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
        dao = new DataTransactionEntryDataAccessObject();

        // Clear the collection before each test
        collection.drop();

        // Insert a test document
        Document testTransaction = new Document("transactionId", 1)
                .append("bookId", 101)
                .append("bookName", "Test Book")
                .append("soldPrice", 9.99)
                .append("date", new Date());
        collection.insertOne(testTransaction);
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        collection.drop();
        mongoClient.close();
    }

    @Test
    void testGetTransactionEntry() {
        CommonTransactionEntry entry = dao.getTransactionEntry(1);
        assertNotNull(entry);
        assertEquals(1, entry.getTransactionId());
        assertEquals(101, entry.getBookId());
        assertEquals("Test Book", entry.getBookName());
        assertEquals(9.99, entry.getSoldPrice(), 0.01);
    }

    @Test
    void testCreateTransactionEntry() {
        CommonTransactionEntry newEntry = new CommonTransactionEntry(2, 102, "Another Test Book", 19.99, new Date());
        boolean result = dao.createTransactionEntry(newEntry);
        assertTrue(result);

        CommonTransactionEntry retrievedEntry = dao.getTransactionEntry(2);
        assertNotNull(retrievedEntry);
        assertEquals(2, retrievedEntry.getTransactionId());
        assertEquals(102, retrievedEntry.getBookId());
        assertEquals("Another Test Book", retrievedEntry.getBookName());
        assertEquals(19.99, retrievedEntry.getSoldPrice(), 0.01);
    }

//    @Test
//    void testGetPurchaseRevenueBetweenDate() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = sdf.parse("2023-01-01");
//        Date endDate = sdf.parse("2023-12-31");
//
//        // Insert another test document
//        Document anotherTransaction = new Document("transactionId", 2)
//                .append("bookId", 103)
//                .append("bookName", "Third Test Book")
//                .append("soldPrice", 29.99)
//                .append("date", new Date());
//        collection.insertOne(anotherTransaction);
//
//        double revenue = dao.getPurchaseRevenueBetweenDate(startDate, endDate);
//        assertEquals(39.98, revenue, 0.01);
//    }
}
