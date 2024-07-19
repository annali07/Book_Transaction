package data_access.database_rental_entry;

import com.google.gson.*;
import entity.purchase_entry.TransactionEntry;
import entity.rent_entry.RentalEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.text.SimpleDateFormat;

import data.misc_info.FilePathConstants;


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
            Object obj = parser.parse(new FileReader(FilePathConstants.TOTAL_BOOKS_FILE));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RentalEntry getRentalEntry(int rentalID) {
        Gson gson = new GsonBuilder().create();

        try {
            String content = new String(Files.readAllBytes(Paths.get(FilePathConstants.RENTAL_TRANSACTION_FILE)));
            JsonArray jsonArray = JsonParser.parseString(content).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                RentalEntry entry = gson.fromJson(element, RentalEntry.class);
                if (entry.getRentalId() == (rentalID)) {
                    return entry;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public double getRentRevenueBetweenDate(Date startDate, Date endDate) {
        double revenue = 0;

        List<RentalEntry> transactions = new ArrayList<>();
        for (int i = 1; i < RentalEntry.readRentalCount(); i++){
            transactions.add(getRentalEntry(i));
        }

        for (RentalEntry rentalEntry : transactions) {
            if (!startDate.after(rentalEntry.getReturnDate()) && !endDate.before(rentalEntry.getReturnDate())) {
                revenue += rentalEntry.getCharge();
            }
        }

        return revenue;
    }
}




//import entity.rent_entry.RentalEntry;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//public class DatabaseRentalEntryDataAccessObject implements DatabaseRentalEntryDataAccessInterface {
//    @Override
//    public ArrayList<RentalEntry> getRentalEntriesBetweenDate(Date startDate, Date endDate){
//        return null;
//    }
//}
