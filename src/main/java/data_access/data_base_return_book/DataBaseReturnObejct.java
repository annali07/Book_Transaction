package data_access.data_base_return_book;
import com.google.gson.*;
import entity.rent_entry.RentalEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import data.misc_info.FilePathConstants;

public class DataBaseReturnObejct implements DatabaseReturnInterface{
    private static final String FILE_PATH_BOOK = FilePathConstants.TOTAL_BOOKS_FILE;
    private static final String RENTAL_FILE_PATH = FilePathConstants.RENTAL_TRANSACTION_FILE;
    @Override
    public void editBookFile(int bookID) {

        JSONObject bookData = readBookData(FILE_PATH_BOOK);
        if (bookData == null) return;

        Set keys = bookData.keySet();  // Get all keys from the JSONObject
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
            System.out.println("Book with ID " + bookID + " not found.");
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

    @Override
    public void writeReturnFile(RentalEntry rentalEntry) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Read the existing file and parse it as a JsonArray
        JsonArray jsonArray;

        try {
            String content = new String(Files.readAllBytes(Paths.get(RENTAL_FILE_PATH)));
            JsonElement jsonElement = JsonParser.parseString(content);

            // Check if the existing content is an array or an object
            if (jsonElement.isJsonArray()) {
                jsonArray = jsonElement.getAsJsonArray();
            } else if (jsonElement.isJsonObject()) {
                // If it's an object, create a new array and add the object to it
                jsonArray = new JsonArray();
                jsonArray.add(jsonElement.getAsJsonObject());
            } else{
                jsonArray = new JsonArray();
            }
        } catch (IOException e) {
            jsonArray = new JsonArray();
        }

        // Convert the transactionEntry to a JsonElement
        JsonElement transactionElement = gson.toJsonTree(rentalEntry);

        // Add the transaction to the JsonArray
        jsonArray.add(transactionElement);

        // Write the updated JsonArray back to the file
        try (FileWriter writer = new FileWriter(RENTAL_FILE_PATH)) {
            gson.toJson(jsonArray, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        JSONObject rentalData = readBookData(RENTAL_FILE_PATH);
//        if (rentalData == null) {
//            rentalData = new JSONObject();
//        }
//
//        // Determine the next key for the new entry
//        int nextKey = rentalData.size() + 1;
//
//        // Create the new entry
//        JSONObject newEntry = new JSONObject();
//        newEntry.put("bookID", bookID);
//        newEntry.put("charge", charge);
//
//        // Add the new entry to the rental data
//        rentalData.put(String.valueOf(nextKey), newEntry);
//
//        // Write the updated rental data back to the file
//        try (FileWriter writer = new FileWriter(RENTAL_FILE_PATH)) {
//            writer.write(rentalData.toJSONString());
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private JSONObject readBookData(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
