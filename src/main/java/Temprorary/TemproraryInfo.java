package Temprorary;

import com.fasterxml.jackson.core.util.InternCache;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import data.FilePathConstants;

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
        JSONObject bookData = TemproraryInfo.readBookData();
        if (bookData == null) return TemproraryInfo.dictionary; // an empty dictionary

        Set keys = bookData.keySet();  // Get all keys from the JSONObject
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            String key = it.next();
            JSONObject book = (JSONObject) bookData.get(key);
            Long bookIDLong = (long) book.get("bookID");
            int bookID1 = bookIDLong.intValue();
            if (TemproraryInfo.bookID == bookID1) {
                dictionary.put("bookID", String.valueOf(bookID));
                dictionary.put("bookName", (String) book.get("bookName"));
                dictionary.put("Start Date", (String) book.get("Start Date"));
                dictionary.put("End Date", (String) book.get("End Date"));
                dictionary.put("isRented", (String) book.get("isRented"));
                dictionary.put("borrowerName", (String) book.get("borrowerName"));
                dictionary.put("borrowerNumber", (String) book.get("borrowerNumber"));
            }
        }
        return TemproraryInfo.dictionary;
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