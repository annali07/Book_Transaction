package entity.book;

import java.io.File;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import data.FilePathConstants;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Book {
    private static final String FILE_PATH = FilePathConstants.BOOK_COUNT_FILE;
    private static final Gson gson = new Gson();

    private final int rentalPrice = 1;
    private String bookName;
    private int bookID;
    private String rentalOrPurchase;
    private double bookPrice;
    private String author;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private String BorrowerName;
    private String BorrowerNumber;

    // Constructor with parameters and default values
    public Book(String bookName, String author, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.rentalStartDate = null; // default value
        this.rentalEndDate = null; //
        this.BorrowerName = "";
        this.BorrowerNumber = "";
        setBookID();
    }

    // Getter and Setter for bookName
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // Getter and Setter for bookID
    public int getBookID() {
        return bookID;
    }

    public void setBookID() {
        this.bookID = readBookCount();
        writeBookCount(bookID+1);
    }

    // Getter and Setter for bookPrice
    public double getBookPrice() {
        return bookPrice;
    }

    // Getter and Setter for rentalStartDate
    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    // Getter and Setter for rentalEndDate
    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    private static int readBookCount() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            return jsonObject.get("bookCount").getAsInt();
        } catch (IOException e) {
            return 0;
        }
    }

    private static void writeBookCount(int bookCount) {
        JsonObject jsonObject;

        // Read the existing file and parse it as a JsonObject
        try {
            String content = new String(Files.readAllBytes(Paths.get(FilePathConstants.BOOK_COUNT_FILE)));
            jsonObject = JsonParser.parseString(content).getAsJsonObject();
        } catch (IOException e) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("transactionCount", 0); // Initialize with default value if file does not exist
        }

        // Update the bookCount field
        jsonObject.addProperty("bookCount", bookCount);

        // Write the updated JsonObject back to the file
        try (FileWriter writer = new FileWriter(FilePathConstants.BOOK_COUNT_FILE)) {
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






