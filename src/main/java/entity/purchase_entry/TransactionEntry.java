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

public class TransactionEntry {
    private static final String FILE_PATH = FilePathConstants.BOOK_COUNT_FILE;
    private static final Gson gson = new Gson();

    @JsonProperty("transactionId")  // Make sure this annotation is correct
    private int transactionId;
    private int bookId;
    private String bookName;
    private double soldPrice;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date date;

    public TransactionEntry(int bookId, String bookName, double soldPrice, Date date) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.soldPrice = soldPrice;
        this.date = date;
        setTransactionId();
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

    public static int readTransactionCount() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            return jsonObject.get("transactionCount").getAsInt();
        } catch (IOException e) {
            return 0;
        }
    }

    private static void writeTransactionCount(int transactionCount) {
        JsonObject jsonObject;

        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            jsonObject = JsonParser.parseString(content).getAsJsonObject();
        } catch (IOException e) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("bookCount", 0); // Initialize with default value if file does not exist
        }

        // Update the transactionCount field
        jsonObject.addProperty("transactionCount", transactionCount);

        // Write the updated JsonObject back to the file
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}