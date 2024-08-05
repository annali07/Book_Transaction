package data.misc_info;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The TemproraryInfo class provides temporary storage and management of book information.
 * It includes methods to set and update book data based on a given book ID.
 *
 */
public class TemproraryInfo {
    // Temporary class for all of book information
    /**
     * The book ID for the current book.
     */
    public static int bookID;

    /**
     * A dictionary to store book information.
     */
    public static Map<String, String> dictionary = new HashMap<>();



    /**
     * Sets the class variable bookID and clears the dictionary.
     *
     * @param bookID the book ID to be set
     */
    public static void setClassVariable(int bookID) {
        TemproraryInfo.bookID = bookID;
        TemproraryInfo.dictionary.clear();
    }

    /**
     * Updates the dictionary with information for the current book ID from the book data.
     *
     * @return a map containing the book information
     */
    public static Map<String, String> update() {
//        JSONObject bookData = TemproraryInfo.readBookData();
//        if (bookData == null) return TemproraryInfo.dictionary; // an empty dictionary
//
//        Set keys = bookData.keySet();  // Get all keys from the JSONObject
//        Iterator<String> it = keys.iterator();
//
//        while (it.hasNext()) {
//            String key = it.next();
//            JSONObject book = (JSONObject) bookData.get(key);
//            Long bookIDLong = (long) book.get("bookID");
//            int bookID1 = bookIDLong.intValue();
//            if (TemproraryInfo.bookID == bookID1) {
//                dictionary.put("bookID", String.valueOf(bookID));
//                dictionary.put("bookName", (String) book.get("bookName"));
//                dictionary.put("Start Date", (String) book.get("Start Date"));
//                dictionary.put("End Date", (String) book.get("End Date"));
//                dictionary.put("isRented", (String) book.get("isRented"));
//                dictionary.put("borrowerName", (String) book.get("borrowerName"));
//                dictionary.put("borrowerNumber", (String) book.get("borrowerNumber"));
//            }
//        }
//        return TemproraryInfo.dictionary;

        Dotenv dotenv = Dotenv.load();
        String MONGO_URI = dotenv.get("MONGO_URI");
        String DATABASE_NAME = "Elysia";
        String COLLECTION_NAME = "books";
        MongoClient mongoClient = null;
        Map<String, String> dictionary = new HashMap<>();

        try {
            mongoClient = MongoClients.create(MONGO_URI);
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document bookDoc = collection.find(eq("bookID", TemproraryInfo.bookID)).first();

            if (bookDoc != null) {
                dictionary.put("bookID", String.valueOf(bookDoc.getInteger("bookID")));
                dictionary.put("bookName", bookDoc.getString("bookName"));
                dictionary.put("Start Date", bookDoc.getString("rentalStartDate"));
                dictionary.put("End Date", bookDoc.getString("rentalEndDate"));
                dictionary.put("isRented", bookDoc.getString("isRented"));
                dictionary.put("borrowerName", bookDoc.getString("borrowerName"));
                dictionary.put("borrowerNumber", bookDoc.getString("borrowerNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }

        return dictionary;
    }

    /**
     * Reads the book data from the file specified in FilePathConstants.
     *
     * @return a JSONObject containing the book data, or null if an error occurs
     */
    public static JSONObject readBookData() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(FilePathConstants.TOTAL_BOOKS_FILE));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}