package data_access.data_base_return_book;
import entity.rent_entry.CommonRentalEntry;
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
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import data.misc_info.FilePathConstants;

/**
 * Implementation of DatabaseReturnInterface for handling book return operations.
 */
public class DataBaseReturnObejct implements DatabaseReturnInterface{
    private static final String FILE_PATH_BOOK = FilePathConstants.TOTAL_BOOKS_FILE;
    private static final String RENTAL_FILE_PATH = FilePathConstants.RENTAL_TRANSACTION_FILE;

    Dotenv dotenv = Dotenv.load();
    String mongoUri = dotenv.get("MONGO_URI");

    /**
     * Updates the book file to mark the book as not rented.
     *
     * @param bookID the ID of the book to update
     */
    @Override
    public void editBookFile(int bookID) {

        JSONObject bookData = readBookData();
        if (bookData == null) return;

        Set keys = bookData.keySet();
        Iterator<String> it = keys.iterator();
        boolean bookFound = false;

        while (it.hasNext()) {
            String key = it.next();
            JSONObject book = (JSONObject) bookData.get(key);
            Long bookIDLong = (long) book.get("bookID");
            int bookID1 = bookIDLong.intValue();
            if (bookID == bookID1) {
                book.put("End Date", null);
                book.put("Start Date", null);
                book.put("isRented", "false");
                book.put("BorrowerName", "");
                book.put("BorrowerNumber", "");
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("CommonBook with ID " + bookID + " not found.");
            return;
        }
        // Write the modified JSON back to the file
        try (FileWriter writer = new FileWriter(FILE_PATH_BOOK)) {
            writer.write(bookData.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the return transaction to the rental transaction file.
     *
     * @param commonRentalEntry the rental entry to write
     */
    @Override
    public void writeReturnFile(CommonRentalEntry commonRentalEntry) {
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("rentalhistory");

            // Convert the commonRentalEntry to a Document
            Document rentalDoc = new Document("transactionId", commonRentalEntry.getRentalId())
                    .append("bookId", commonRentalEntry.getBookId())
                    .append("charge", commonRentalEntry.getCharge())
                    .append("rentalStartDate", commonRentalEntry.getRentalStartDate())
                    .append("rentalEndDate", commonRentalEntry.getRentalEndDate())
                    .append("returnDate", commonRentalEntry.getReturnDate())
                    .append("maxCharge", commonRentalEntry.getMaxCharge());

            // Insert the Document into the collection
            collection.insertOne(rentalDoc);

            System.out.println("Rental entry saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonArray jsonArray;
//
//        try {
//            String content = new String(Files.readAllBytes(Paths.get(RENTAL_FILE_PATH)));
//            JsonElement jsonElement = JsonParser.parseString(content);
//
//            if (jsonElement.isJsonArray()) {
//                jsonArray = jsonElement.getAsJsonArray();
//            } else if (jsonElement.isJsonObject()) {
//                jsonArray = new JsonArray();
//                jsonArray.add(jsonElement.getAsJsonObject());
//            } else{
//                jsonArray = new JsonArray();
//            }
//        } catch (IOException e) {
//            jsonArray = new JsonArray();
//        }
//
//        // Convert the transactionEntry to a JsonElement
//        JsonElement transactionElement = gson.toJsonTree(commonRentalEntry);
//
//        // Add the transaction to the JsonArray
//        jsonArray.add(transactionElement);
//
//        // Write the updated JsonArray back to the file
//        try (FileWriter writer = new FileWriter(RENTAL_FILE_PATH)) {
//            gson.toJson(jsonArray, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Reads the book data from the file.
     *
     * @return a JSONObject representing the book data, or null if an error occurs
     */
    public JSONObject readBookData() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(FILE_PATH_BOOK));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
