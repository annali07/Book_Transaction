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

import static com.mongodb.client.model.Filters.eq;

import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
    Dotenv dotenv = Dotenv.load();
    String mongoUri = dotenv.get("MONGO_URI");

    /**
     * Retrieves a transaction entry by its ID.
     *
     * @param transactionId The ID of the transaction to retrieve.
     * @return The TransactionEntry object if found, or null if not found.
     */
    public TransactionEntry getTransactionEntry(int transactionId) {
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("purchasehistory");

            // Find the document with the specified transactionId
            Document doc = collection.find(eq("transactionId", transactionId)).first();

            if (doc != null) {
                // Parse the Document into a TransactionEntry object
                TransactionEntry entry = new TransactionEntry(
                        doc.getInteger("transactionId"),
                        doc.getInteger("bookId"),
                        doc.getString("bookName"),
                        doc.getDouble("soldPrice"),
                        doc.getDate("date")
                );
                return entry;

            } else {
                System.out.println("No transaction entry found with transactionId: " + transactionId);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates a new transaction entry.
     *
     * @param transactionEntry The transaction entry to be created.
     * @return true if the transaction entry is successfully created, false otherwise.
     */
    @Override
    public boolean createTransactionEntry(TransactionEntry transactionEntry) {
        try (MongoClient mongoClient = MongoClients.create(mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase("Elysia");
            MongoCollection<Document> collection = database.getCollection("purchasehistory");

            // Convert the transactionEntry to a Document
            Document transactionDoc = new Document("transactionId", transactionEntry.getTransactionId())
                    .append("bookId", transactionEntry.getBookId())
                    .append("bookName", transactionEntry.getBookName())
                    .append("soldPrice", transactionEntry.getSoldPrice())
                    .append("date", transactionEntry.getDate());

            // Insert the Document into the collection
            collection.insertOne(transactionDoc);

            System.out.println("Transaction entry saved successfully to MongoDB.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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

        for (TransactionEntry transactionEntry : transactions)
            if (!startDate.after(transactionEntry.getDate()) && !endDate.before(transactionEntry.getDate())) {
                revenue += transactionEntry.getSoldPrice();
            }

        return revenue;
    }
}
