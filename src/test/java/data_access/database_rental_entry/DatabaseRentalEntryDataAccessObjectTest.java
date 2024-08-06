//package data_access.database_rental_entry;
//
//import entity.rent_entry.CommonRentalEntry;
//import io.github.cdimascio.dotenv.Dotenv;
//import org.bson.Document;
//import org.json.simple.JSONObject;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//import java.io.FileWriter;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class DatabaseRentalEntryDataAccessObjectTest {
//
//    private DatabaseRentalEntryDataAccessObject dao;
//    private static final String TEST_FILE_PATH = "test_books.json";
//    Dotenv dotenv = Dotenv.load();
//    String MONGO_URI = dotenv.get("MONGO_URI"); // Replace with actual Mongo URI
//    private MongoClient mongoClient;
//    private MongoDatabase database;
//    private MongoCollection<Document> collection;
//
//    @BeforeEach
//    void setUp() throws Exception {a
//        dao = new DatabaseRentalEntryDataAccessObject();
//        dao.MONGO_URI = MONGO_URI; // Set the MONGO_URI field for testing
//        createTestFile();
//        setupMongoDb();
//    }
//
//    @Test
//    void testValidateBook() {
//        assertTrue(dao.validatebook(1));
//        assertFalse(dao.validatebook(999));
//    }
//
//    @Test
//    void testGetRentalEntry() {
//        CommonRentalEntry entry = dao.getRentalEntry(1);
//        assertNotNull(entry);
//        assertEquals(1, entry.getRentalId());
//
//        CommonRentalEntry nonExistentEntry = dao.getRentalEntry(999);
//        assertNull(nonExistentEntry);
//    }
//
//    @Test
//    void testGetRentRevenueBetweenDate() {
//        Date startDate = new Date();
//        Date endDate = new Date(startDate.getTime() + 86400000L * 2);  // +2 days
//
//        double revenue = dao.getRentRevenueBetweenDate(startDate, endDate);
//        assertEquals(10.0, revenue, 0.01);
//    }
//
//    private void createTestFile() throws Exception {
//        JSONObject bookData = new JSONObject();
//
//        JSONObject book = new JSONObject();
//        book.put("bookID", 1L);
//        book.put("bookName", "Test Book");
//        book.put("bookPrice", 19.99);
//        book.put("isRented", "false");
//        book.put("BorrowerName", "");
//        book.put("BorrowerNumber", "");
//        book.put("Start Date", "");
//        book.put("End Date", "");
//
//        bookData.put("1", book);
//
//        try (FileWriter file = new FileWriter(TEST_FILE_PATH)) {
//            file.write(bookData.toJSONString());
//            file.flush();
//        }
//    }
//
//    private void setupMongoDb() {
//        mongoClient = MongoClients.create(MONGO_URI);
//        database = mongoClient.getDatabase("Elysia");
//        collection = database.getCollection("rentalhistory");
//        collection.drop();  // Clear the collection before each test
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Document doc1 = new Document("transactionId", 1)
//                .append("bookId", 1)
//                .append("charge", 10)
//                .append("rentalStartDate", dateFormat.format(new Date()))
//                .append("rentalEndDate", dateFormat.format(new Date()))
//                .append("returnDate", dateFormat.format(new Date()))
//                .append("maxCharge", 50);
//        collection.insertOne(doc1);
//
//        Document doc2 = new Document("transactionId", 2)
//                .append("bookId", 2)
//                .append("charge", 20)
//                .append("rentalStartDate", dateFormat.format(new Date()))
//                .append("rentalEndDate", dateFormat.format(new Date()))
//                .append("returnDate", dateFormat.format(new Date()))
//                .append("maxCharge", 100);
//        collection.insertOne(doc2);
//    }
//}
