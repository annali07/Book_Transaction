package data.misc_info;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TemproraryInfo {
    // Temporary class for all of book information
    public static int bookID;
    public static Map<String, String> dictionary = new HashMap<>();


    public static void setClassVariable(int bookID) {
        TemproraryInfo.bookID = bookID;
        TemproraryInfo.dictionary.clear();
    }

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