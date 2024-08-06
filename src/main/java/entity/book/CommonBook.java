package entity.book;

import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import data.misc_info.FilePathConstants;
import com.google.gson.JsonParser;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonBook implements Book{
    private static final String FILE_PATH = FilePathConstants.BOOK_COUNT_FILE;
    private static final Gson gson = new Gson();
    public static final int RENTAL_PRICE = 1;

    private int rentalPrice = RENTAL_PRICE;
    private String BorrowerNumber;
    private String isRented = "false";
    private double bookPrice;
    private String bookName;
    private String BorrowerName;
    private int bookID;
    private Date rentalStartDate;
    private Date rentalEndDate;

    // Constructor with parameters and default values
    public CommonBook(String bookName, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.rentalStartDate = null; // default value
        this.rentalEndDate = null; //
        this.BorrowerName = "";
        this.BorrowerNumber = "";
        setBookID();
    }

    // Used in GetBook
    public CommonBook(int bookID, String bookName, double bookPrice, Date rentalStartDate, Date rentalEndDate, String isRented, String borrowerName, String borrowerNumber) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.isRented = isRented;
        this.BorrowerName = borrowerName;
        this.BorrowerNumber = borrowerNumber;
    }

    public CommonBook(int bookID, String bookName, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.rentalStartDate = null; // default value
        this.rentalEndDate = null; //
        this.BorrowerName = "";
        this.BorrowerNumber = "";
        this.bookID = bookID;
    }

    // Getter and Setter for bookName
    @Override
    public String getBookName() {
        return bookName;
    }

    @Override
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    // Getter and Setter for bookID
    public int getBookID() {
        return bookID;
    }

    @Override
    public void setBookID() {
        this.bookID = readBookCount();
        writeBookCount(bookID+1);
    }

    @Override
    public String getIsRented() {return isRented; }

    @Override
    // Getter and Setter for bookPrice
    public double getBookPrice() {
        return bookPrice;
    }

    @Override
    // Getter and Setter for rentalStartDate
    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    @Override
    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    @Override
    // Getter and Setter for rentalEndDate
    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    @Override
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






