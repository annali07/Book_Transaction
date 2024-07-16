package data_access.database_transaction_entry;

import entity.purchase_entry.TransactionEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;
import data.FilePathConstants;

public class DataTransactionEntryDataAccessObject implements DatabaseTransactionEntryDataAccessInterface{
    private static int transactionID = 0;

    @Override
     //input the transaction id and return TransactionEntry
    public TransactionEntry getTransactionEntry(int id) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(FilePathConstants.PURCHASE_TRANSACTION_FILE));
            JSONObject jsonObject = (JSONObject) obj;
            // convert the int to string
            String key = Integer.toString(id);

            // check if the id inside the json file
            if (jsonObject.containsKey(key)) {
                JSONObject transaction = (JSONObject) jsonObject.get(key);
                // Parse individual fields
                int transactionId = ((Long) transaction.get("transactionId")).intValue();
                int bookId = ((Long) transaction.get("bookId")).intValue();
                String bookName = (String) transaction.get("bookName");
                double soldPrice = (Double) transaction.get("soldPrice");

                // Parsing date assuming the date is stored as a string in "yyyy-MM-dd" format
                String dateString = (String) transaction.get("date");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(dateString);

                return new TransactionEntry(transactionId, bookId, bookName, soldPrice, date);
            }
            else{
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean createTransactionEntry(TransactionEntry transactionEntry) {
        JSONObject jsonObject;
        // get the outer object of whole json file
        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(new FileReader(FilePathConstants.PURCHASE_TRANSACTION_FILE));
            jsonObject = (JSONObject) obj;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

        // create a 'small' JSONObject
        JSONObject transactionJSONObject = new JSONObject();
        transactionJSONObject.put("bookid", transactionEntry.getBookId());
        transactionJSONObject.put("price", transactionEntry.getSoldPrice());
        transactionJSONObject.put("date", transactionEntry.getDate());

        // Write the small json object to file
        int num = transactionEntry.getTransactionId();
        String stringNum = Integer.toString(num);
        jsonObject.put(stringNum, transactionJSONObject);
        try (FileWriter file = new FileWriter(FilePathConstants.PURCHASE_TRANSACTION_FILE)){
            file.write(jsonObject.toJSONString());
            file.flush();
            return true;
        }
        // fail to write the object into the json file
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    // create TransactionID
    public int createTransactionID(){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(FilePathConstants.PURCHASE_TRANSACTION_FILE));
            JSONObject jsonObject = (JSONObject) obj;
            // check if the target obj in the database
            while(jsonObject.containsKey(Integer.toString(transactionID))){
                transactionID++;
            }
            return transactionID;
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }


    }

    @Override
    public ArrayList<TransactionEntry> getTransactionEntriesBetweenDate(Date startDate, Date endDate) {
        ArrayList<TransactionEntry> transactions = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(FilePathConstants.PURCHASE_TRANSACTION_FILE));
            JSONObject jsonObject = (JSONObject) obj;

            Set<String> keys = jsonObject.keySet();
            for (String key: keys) {
                JSONObject transaction = (JSONObject) jsonObject.get(key);
                Date date = (Date) transaction.get("date");
                if (date.after(startDate) && date.before(endDate)) {
                    transactions.add(new TransactionEntry(Integer.parseInt(key), (int) transaction.get("bookid"), "noName", (double) transaction.get("price"), date));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
