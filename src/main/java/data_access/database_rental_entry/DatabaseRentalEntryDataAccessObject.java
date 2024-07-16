package data_access.database_rental_entry;

import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of DatabaseRentalEntryDataAccessInterface for validating bookID.
 */
public class DatabaseRentalEntryDataAccessObject implements DatabaseRentalEntryDataAccessInterface {
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

    private JSONObject readBookData() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/zhenyizhangkenny/IdeaProjects/Book_Transaction/src/main/java/data/TotalBooks.json"));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
