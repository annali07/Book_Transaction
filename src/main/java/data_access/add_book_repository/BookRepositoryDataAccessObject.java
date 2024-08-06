package data_access.add_book_repository;

import static com.mongodb.client.model.Filters.eq;

import entity.book.CommonBook;
import entity.book.CommonBookFactory;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import data.misc_info.FilePathConstants;
import io.github.cdimascio.dotenv.Dotenv;

import static com.mongodb.client.model.Filters.eq;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;

/**
 * A data access object (DAO) implementation for saving books to a JSON file.
 */
public class BookRepositoryDataAccessObject implements BookRepositoryDataAccessInterface {

    private static final String FILE_PATH = FilePathConstants.TOTAL_BOOKS_FILE;
    public MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection<Document> bookCollection;
    private static final CommonBookFactory factory = new CommonBookFactory();

//    public BookRepositoryDataAccessObject() {
//        Dotenv dotenv = Dotenv.load();
//        String mongoUri = dotenv.get("MONGO_URI");
//        this.mongoClient = MongoClients.create(mongoUri);
//        this.database = mongoClient.getDatabase("Elysia");
//        this.bookCollection = database.getCollection("books");
//    }

    Dotenv dotenv = Dotenv.load();
    String mongoUri = dotenv.get("MONGO_URI");

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create();

    /**
     * Saves the given book to the JSON file.
     *
     * @param book the book to be saved
     */
    @Override
    public boolean saveBook(CommonBook book) {
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("books");

            // Create a Document from the CommonBook object
            Document doc = new Document("bookID", book.getBookID())
                    .append("bookName", book.getBookName())
                    .append("bookPrice", book.getBookPrice())
                    .append("rentalStartDate", book.getRentalStartDate())
                    .append("rentalEndDate", book.getRentalEndDate())
                    .append("borrowerName", "")
                    .append("borrowerNumber", "")
                    .append("isRented", book.getIsRented());

            // Insert the Document into the collection
            collection.insertOne(doc);
            System.out.println("CommonBook saved successfully to MongoDB.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates the book record with borrowing information in the MongoDB collection.
     *
     * @param bookID         The ID of the book to update.
     * @param startDate      The start date of the borrowing period.
     * @param endDate        The end date of the borrowing period.
     * @param borrowerName   The name of the borrower.
     * @param borrowerNumber The number of the borrower.
     * @return true if the book is updated successfully, false otherwise.
     */
    @Override
    public boolean updateBook(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedStartDate = dateFormat.format(startDate);
        String formattedEndDate = dateFormat.format(endDate);

        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("books");

            // Find the document with the specified bookID
            Document bookDoc = collection.find(eq("bookID", bookID)).first();

            if (bookDoc != null) {
                // Update the document with borrowing information
                bookDoc.put("rentalStartDate", formattedStartDate);
                bookDoc.put("rentalEndDate", formattedEndDate);
                bookDoc.put("isRented", "true");
                bookDoc.put("borrowerName", borrowerName);
                bookDoc.put("borrowerNumber", borrowerNumber);

                // Update the document in the collection
                collection.replaceOne(eq("bookID", bookID), bookDoc);

                System.out.println("CommonBook with ID " + bookID + " updated successfully.");
                return true;
            } else {
                System.out.println("CommonBook with ID " + bookID + " not found.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks if a book with the given bookId exists in the MongoDB collection.
     *
     * @param bookId The book ID to search for.
     * @return true if the book exists, false otherwise.
     */
    @Override
    public boolean findBook(int bookId){
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("books");

            // Find the document with the specified bookId
            Document doc = collection.find(eq("bookID", bookId)).first();

            // Return true if the document exists, false otherwise
            return doc != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a book from the repository.
     *
     * @param bookId the ID of the book to delete
     * @return true if the book was successfully deleted, false otherwise
     */
    @Override
    public boolean deleteBook(int bookId) {
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("books");

            // Delete the document with the specified bookID
            Document deletedBook = collection.findOneAndDelete(eq("bookID", bookId));

            if (deletedBook != null) {
                System.out.println("CommonBook deleted successfully.");
                return true;
            } else {
                System.out.println("No book found with bookID: " + bookId);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a book from the repository.
     *
     * @param bookId the ID of the book to retrieve
     * @return a JsonObject representing the book, or null if the book is not found
     */
    @Override
    public CommonBook getBook(int bookId) {
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("books");

            // Find the document with the specified bookID
            Document doc = collection.find(eq("bookID", bookId)).first();

            if (doc != null) {
                CommonBook book = factory.createBook
                (
                        doc.getInteger("bookID"),
                        doc.getString("bookName"),
                        doc.getDouble("bookPrice"),
                        null,
                        null,
                        doc.getString("isRented"),
                        doc.getString("borrowerName"),
                        doc.getString("borrowerNumber")
                );
                return book;
            } else {
                System.out.println("No book found with bookID: " + bookId);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the books from the JSON file.
     *
     * @return a map of books with their IDs as keys and their JSON representations as values
     */
    private Map<String, JsonObject> readBooksFromFile() {
        Gson gson = new Gson(); // Ensure Gson instance is created if not already available
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<HashMap<String, JsonObject>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An IO exception occurred: " + e.getMessage());
        }
        return new HashMap<>();
    }


    /**
     * Writes the given books map to the JSON file.
     *
     * @param books the map of books to be written to the file
     */
    private boolean writeBooksToFile(Map<String, JsonObject> books) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(books, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
