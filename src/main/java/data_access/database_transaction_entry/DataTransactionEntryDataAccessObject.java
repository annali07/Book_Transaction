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


/**
 * DataTransactionEntryDataAccessObject is a class that implements DatabaseTransactionEntryDataAccessInterface
 * for performing CRUD operations on transaction entries stored in a JSON file.
 */
public class DataTransactionEntryDataAccessObject implements DatabaseTransactionEntryDataAccessInterface{
    private final String FILE_PATH = FilePathConstants.PURCHASE_TRANSACTION_FILE;

    /**
     * Retrieves a transaction entry by its ID.
     *
     * @param transactionId The ID of the transaction to retrieve.
     * @return The TransactionEntry object if found, or null if not found.
     */
    public TransactionEntry getTransactionEntry(int transactionId) {
        Gson gson = new GsonBuilder().create();

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

        return null;
    }

    /**
     * Creates a new transaction entry.
     *
     * @param transactionEntry The transaction entry to be created.
     * @return true if the transaction entry is successfully created, false otherwise.
     */
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

    /**
     * Calculates the total purchase revenue between two dates.
     *
     * @param startDate The start date of the period.
     * @param endDate   The end date of the period.
     * @return The total purchase revenue between the given dates.
     */
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
