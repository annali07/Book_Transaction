package data_access.database_transaction_entry;

import entity.purchase_entry.TransactionEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonArray;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

public class DataTransactionEntryDataAccessObject implements DatabaseTransactionEntryDataAccessInterface{

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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Read the existing file and parse it as a JsonArray
        JsonArray jsonArray;

        try {
            String content = new String(Files.readAllBytes(Paths.get(FilePathConstants.PURCHASE_TRANSACTION_FILE)));
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
        JsonElement transactionElement = gson.toJsonTree(transactionEntry);

        // Add the transaction to the JsonArray
        jsonArray.add(transactionElement);

        // Write the updated JsonArray back to the file
        try (FileWriter writer = new FileWriter(FilePathConstants.PURCHASE_TRANSACTION_FILE)) {
            gson.toJson(jsonArray, writer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
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
