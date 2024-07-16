package data_access.data_base_return_book;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


public class DataBaseReturnObejct implements DatabaseReturnInterface{
    private static final String FILE_PATH_BOOK = "/Users/zhenyizhangkenny/IdeaProjects/Book_Transaction/src/main/java/data/TotalBooks.json";
    private static final String RENTAL_FILE_PATH = "/Users/zhenyizhangkenny/IdeaProjects/Book_Transaction/src/main/java/data/Rental.json";
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
    public void writeReturnFile(int bookID, int charge) {
        JSONObject rentalData = readBookData(RENTAL_FILE_PATH);
        if (rentalData == null) {
            rentalData = new JSONObject();
        }

        // Determine the next key for the new entry
        int nextKey = rentalData.size() + 1;

        // Create the new entry
        JSONObject newEntry = new JSONObject();
        newEntry.put("bookID", bookID);
        newEntry.put("charge", charge);

        // Add the new entry to the rental data
        rentalData.put(String.valueOf(nextKey), newEntry);

        // Write the updated rental data back to the file
        try (FileWriter writer = new FileWriter(RENTAL_FILE_PATH)) {
            writer.write(rentalData.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
