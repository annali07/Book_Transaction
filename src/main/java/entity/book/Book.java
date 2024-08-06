package entity.book;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.misc_info.FilePathConstants;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public interface Book {
    // Getter and Setter for bookName
    public String getBookName();

    public void setBookName(String bookName);

    // Getter and Setter for bookID
    public int getBookID();

    public void setBookID();

    public String getIsRented();

    // Getter and Setter for bookPrice
    public double getBookPrice();

    // Getter and Setter for rentalStartDate
    public Date getRentalStartDate();

    public void setRentalStartDate(Date rentalStartDate);

    // Getter and Setter for rentalEndDate
    public Date getRentalEndDate();

    public void setRentalEndDate(Date rentalEndDate);

    public String getBorrowerName();

    public String getBorrowerNumber();

    public int getRentalPrice();
}
