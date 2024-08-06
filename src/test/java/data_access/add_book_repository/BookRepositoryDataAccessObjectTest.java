//package data_access.add_book_repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import static com.mongodb.client.model.Filters.eq;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.plugins.MockResolver;
////import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Date;
//
//import com.google.gson.JsonObject;
//import data.misc_info.FilePathConstants;
//import entity.book.CommonBook;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//
//import static org.junit.jupiter.api.Assertions.*;
//
////@ExtendWith(MockitoExtension.class)
//class BookRepositoryDataAccessObjectTest {
//
//    @Mock
//    private MongoClient mongoClient;
//
//    @Mock
//    private MongoDatabase database;
//
//    @Mock
//    private MongoCollection<Document> collection;
//
//    @InjectMocks
//    private BookRepositoryDataAccessObject dao;
//
//    @BeforeEach
//    void setUp() {
//        // Initialize mocks manually
//        MockitoAnnotations.openMocks(this);
//
//        // Set up the DAO with the mocked dependencies
//        dao = new BookRepositoryDataAccessObject();
//        dao.mongoClient = mongoClient;
//        dao.database = database;
//        dao.bookCollection = collection;
//
//        when(mongoClient.getDatabase("Elysia")).thenReturn(database);
//        when(database.getCollection("books")).thenReturn(collection);
//    }
//
//
//    @Test
//    void testSaveBook() {
//        CommonBook book = new CommonBook(1, "Test CommonBook", 9.99, new Date(), new Date(), "false", "", "");
//
//        boolean result = dao.saveBook(book);
//
//        assertTrue(result);
//        verify(collection, times(1)).insertOne(any(Document.class));
//    }
//
//    @Test
//    void testUpdateBook() {
//        int bookID = 1;
//        Date startDate = new Date();
//        Date endDate = new Date();
//        String borrowerName = "John Doe";
//        String borrowerNumber = "1234567890";
//
//        Document existingDoc = new Document("bookID", bookID);
//        when(collection.find(eq("bookID", bookID)).first()).thenReturn(existingDoc);
//
//        boolean result = dao.updateBook(bookID, startDate, endDate, borrowerName, borrowerNumber);
//
//        assertTrue(result);
//        verify(collection, times(1)).replaceOne(eq("bookID", bookID), any(Document.class));
//    }
//
//    @Test
//    void testFindBook() {
//        int bookID = 1;
//
//        when(collection.find(eq("bookID", bookID)).first()).thenReturn(new Document("bookID", bookID));
//
//        boolean result = dao.findBook(bookID);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void testDeleteBook() {
//        int bookID = 1;
//
//        when(collection.findOneAndDelete(eq("bookID", bookID))).thenReturn(new Document("bookID", bookID));
//
//        boolean result = dao.deleteBook(bookID);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void testGetBook() {
//        int bookID = 1;
//        Document doc = new Document("bookID", bookID)
//                .append("bookName", "Test CommonBook")
//                .append("bookPrice", 9.99)
//                .append("rentalStartDate", new Date())
//                .append("rentalEndDate", new Date())
//                .append("isRented", false)
//                .append("borrowerName", "")
//                .append("borrowerNumber", "");
//
//        when(collection.find(eq("bookID", bookID)).first()).thenReturn(doc);
//
//        CommonBook book = dao.getBook(bookID);
//
//        assertNotNull(book);
//        assertEquals(bookID, book.getBookID());
//    }
//}
