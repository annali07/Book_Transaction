package data_access.database_rental_entry;

import entity.rent_entry.RentalEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import java.util.ArrayList;
import java.util.Date;
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
    public ArrayList<RentalEntry> getRentalEntryBetweenDate(Date startDate, Date endDate) {
        ArrayList<RentalEntry> rentalTransactions = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(FilePathConstants.RENTAL_TRANSACTION_FILE));
            JSONObject jsonObject = (JSONObject) obj;

            Set<String> keys = jsonObject.keySet();
            for (String key: keys) {
                JSONObject transaction = (JSONObject) jsonObject.get(key);
                Date date = (Date) transaction.get("date");
                if (date.after(startDate) && date.before(endDate)) {
                    // Parse individual fields
                    int rentalId = ((Long) transaction.get("rentalId")).intValue();
                    int bookId = ((Long) transaction.get("bookId")).intValue();
                    String bookName = (String) transaction.get("bookName");
                    String borrowerName = (String) transaction.get("borrowerName");
                    String borrowerPhoneNumber = (String) transaction.get("borrowerPhoneNumber");

                    // Parsing dates assuming the dates are stored as strings in "yyyy-MM-dd" format
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String rentalStartDateString = (String) transaction.get("rentalStartDate");
                    String rentalEndDateString = (String) transaction.get("rentalEndDate");
                    Date rentalStartDate = formatter.parse(rentalStartDateString);
                    Date rentalEndDate = formatter.parse(rentalEndDateString);

                    double charge = (Double) transaction.get("charge");

                    rentalTransactions.add(new RentalEntry(rentalId, bookId, charge, bookName, borrowerName, borrowerPhoneNumber, rentalStartDate, rentalEndDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rentalTransactions;
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
