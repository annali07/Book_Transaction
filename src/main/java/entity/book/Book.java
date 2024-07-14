package entity.book;

import java.util.Date;

public class Book {
    // #TODO Is this public static variable valid
    public static int bookCount = 0;

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
//    private boolean damageStatus;
//    private boolean availability;

    // Constructor with parameters and default values
    public Book(String bookName, String author, int bookID, double bookPrice) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.bookPrice = bookPrice;
//        this.damageStatus = false; // default value
//        this.availability = true;  // default value
//        this.rentalOrPurchase = "Purchase"; // default value
        this.rentalStartDate = null; // default value
        this.rentalEndDate = null; //
        this.BorrowerName = "";
        this.BorrowerNumber = "";
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

//    // Getter and Setter for damageStatus
//    public boolean isDamageStatus() {
//        return damageStatus;
//    }
//
//    public void setDamageStatus(boolean damageStatus) {
//        this.damageStatus = damageStatus;
//    }
//
//    // Getter and Setter for availability
//    public boolean isAvailability() {
//        return availability;
//    }
//
//    public void setAvailability(boolean availability) {
//        this.availability = availability;
//    }

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






