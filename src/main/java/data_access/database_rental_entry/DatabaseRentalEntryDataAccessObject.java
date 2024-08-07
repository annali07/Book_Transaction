package data_access.database_rental_entry;

import entity.rent_entry.CommonRentalEntry;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import data.misc_info.FilePathConstants;


/**
 * Implementation of DatabaseRentalEntryDataAccessInterface for performing operations on rental entries,
 * such as validating book IDs, retrieving rental entries, and calculating rental revenue.
 */
public class DatabaseRentalEntryDataAccessObject implements DatabaseRentalEntryDataAccessInterface {

    Dotenv dotenv = Dotenv.load();
    String MONGO_URI = dotenv.get("MONGO_URI");
    private static final String DATABASE_NAME = "Elysia";
    private static final String COLLECTION_NAME = "rentalhistory";

    /**
     * Validates the bookID by checking the provided bookID against stored book data.
     *
     * @param bookID the bookID to validate
     * @return true if the bookID matches a stored book, false otherwise
     */
    @Override
    public boolean validatebook(int bookID) {
        JSONObject bookData = readBookData();
        if (bookData == null) return false;

        Set keys = bookData.keySet();  // Get all keys from the JSONObject
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            String key = it.next();
            JSONObject book = (JSONObject) bookData.get(key);
            Long bookIDLong = (long) book.get("bookID");
            int bookID1 = bookIDLong.intValue();

            if (bookID == bookID1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reads the book data from a JSON file.
     *
     * @return A JSONObject containing the book data, or null if an error occurs.
     */
    public JSONObject readBookData() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(FilePathConstants.TOTAL_BOOKS_FILE));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves a rental entry by its ID.
     *
     * @param rentalID The ID of the rental entry to retrieve.
     * @return The CommonRentalEntry object if found, or null if not found.
     */
    @Override
    public CommonRentalEntry getRentalEntry(int rentalID) {
        MongoClient mongoClient = null;
        CommonRentalEntry foundEntry = null;

        try {
            mongoClient = MongoClients.create(MONGO_URI);
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            // Find documents with the specified rentalID
            Document doc = collection.find(eq("transactionId", rentalID)).first();

            if (doc != null) {
                // Parse the Document into a CommonTransactionEntry object
                CommonRentalEntry entry = new CommonRentalEntry(
                        doc.getInteger("transactionId"),
                        doc.getInteger("bookId"),
                        doc.getInteger("charge"),
                        doc.getDate("rentalStartDate"),
                        doc.getDate("rentalEndDate"),
                        doc.getDate("returnDate"),
                        doc.getInteger("maxCharge")
                );
                return entry;
        } else {
                System.out.println("No transaction entry found with transactionId: " + rentalID);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Calculates the total rental revenue between two dates.
     *
     * @param startDate The start date of the period.
     * @param endDate   The end date of the period.
     * @return The total rental revenue between the given dates.
     */
    @Override
    public double getRentRevenueBetweenDate(Date startDate, Date endDate) {
        double revenue = 0;

        List<CommonRentalEntry> transactions = new ArrayList<>();
        for (int i = 1; i < CommonRentalEntry.readRentalCount(); i++){
            transactions.add(getRentalEntry(i));
        }

        for (CommonRentalEntry commonRentalEntry : transactions) {
            if (!startDate.after(commonRentalEntry.getReturnDate()) && !endDate.before(commonRentalEntry.getReturnDate())) {
                revenue += commonRentalEntry.getCharge();
            }
        }

        return revenue;
    }
}