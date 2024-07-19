package data_access.database_transaction_entry;

import com.google.gson.*;
import data.misc_info.FilePathConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import entity.purchase_entry.CustomDateSerializer;
import entity.purchase_entry.TransactionEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.text.SimpleDateFormat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DataTransactionEntryDataAccessObject implements DatabaseTransactionEntryDataAccessInterface{
    private final String FILE_PATH = FilePathConstants.PURCHASE_TRANSACTION_FILE;

    public TransactionEntry getTransactionEntry(int transactionId) {
        Gson gson = new GsonBuilder().create();
        // Read the existing file and parse it as a JsonArray
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            JsonArray jsonArray = JsonParser.parseString(content).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                TransactionEntry entry = gson.fromJson(element, TransactionEntry.class);
                if (entry.getTransactionId() == (transactionId)) {
                    return entry;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Return null if the transaction ID is not found or any exception occurs
    }

    @Override
    public boolean createTransactionEntry(TransactionEntry transactionEntry) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        // Read the existing file and parse it as a JsonArray
        JsonArray jsonArray;

        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
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
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jsonArray, writer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public double getPurchaseRevenueBetweenDate(Date startDate, Date endDate) {
        double revenue = 0;

        List<TransactionEntry> transactions = new ArrayList<>();
        for (int i = 1; i < TransactionEntry.readTransactionCount(); i++){
            transactions.add(getTransactionEntry(i));
        }

        for (TransactionEntry transactionEntry : transactions) {
            if (!startDate.after(transactionEntry.getDate()) && !endDate.before(transactionEntry.getDate())) {
                revenue += transactionEntry.getSoldPrice();
            }
        }

        return revenue;
    }
}
