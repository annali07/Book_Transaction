package entity.book;

import java.util.Date;

public class Book {
    private String bookName;
    private int bookID;
    private String isbn;
    private boolean damageStatus;
    private boolean availability;
    private String rentalOrPurchase;
    private double bookPrice;
    private double rentalPrice;
    private Date rentalStartDate;
    private Date rentalEndDate;

    // Constructor with parameters and default values
    public Book(String bookName, int bookID, String isbn, double bookPrice, double rentalPrice) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.isbn = isbn;
        this.bookPrice = bookPrice;
        this.rentalPrice = rentalPrice;
        this.damageStatus = false; // default value
        this.availability = true;  // default value
        this.rentalOrPurchase = "Purchase"; // default value
        this.rentalStartDate = null; // default value
        this.rentalEndDate = null; // default value
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

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    // Getter and Setter for isbn
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter and Setter for damageStatus
    public boolean isDamageStatus() {
        return damageStatus;
    }

    public void setDamageStatus(boolean damageStatus) {
        this.damageStatus = damageStatus;
    }

    // Getter and Setter for availability
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // Getter and Setter for rentalOrPurchase
    public String getRentalOrPurchase() {
        return rentalOrPurchase;
    }

    public void setRentalOrPurchase(String rentalOrPurchase) {
        this.rentalOrPurchase = rentalOrPurchase;
    }

    // Getter and Setter for bookPrice
    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    // Getter and Setter for rentalPrice
    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
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
}






