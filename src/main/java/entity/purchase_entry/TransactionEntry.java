package entity.purchase_entry;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data.misc_info.FilePathConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import  java.util.Date;

import com.google.gson.JsonParser;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents a transaction entry for a book purchase.
 */
public class TransactionEntry {
    private static final String FILE_PATH = FilePathConstants.BOOK_COUNT_FILE;
    private static final Gson gson = new Gson();

    @JsonProperty("transactionId")
    private int transactionId;
    private int bookId;
    private String bookName;
    private double soldPrice;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date date;

    /**
     * Constructs a new TransactionEntry with the specified details.
     *
     * @param bookId the ID of the book
     * @param bookName the name of the book
     * @param soldPrice the sold price of the book
     * @param date the date of the transaction
     */
    public TransactionEntry(int bookId, String bookName, double soldPrice, Date date) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.soldPrice = soldPrice;
        this.date = date;
        setTransactionId();
    }

    public TransactionEntry(int transactionId, int bookId, String bookName, double soldPrice, Date date) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.soldPrice = soldPrice;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTransactionId(){
        this.transactionId = readTransactionCount();
        writeTransactionCount(transactionId+1);
    }

    /**
     * Reads the current transaction count from the file.
     *
     * @return the current transaction count
     */
    public static int readTransactionCount() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            return jsonObject.get("transactionCount").getAsInt();
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * Writes the updated transaction count to the file.
     *
     * @param transactionCount the updated transaction count
     */
    private static void writeTransactionCount(int transactionCount) {
        JsonObject jsonObject;

        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            jsonObject = JsonParser.parseString(content).getAsJsonObject();
        } catch (IOException e) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("bookCount", 0); // Initialize with default value if file does not exist
        }

        jsonObject.addProperty("transactionCount", transactionCount);
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}