package entity;

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

    public Book (String bookname ,int bookid,String ISBN
                 ,double bookprice, double rentalprice){
        this.bookName = bookname;
        this.bookID = bookid;
        this.isbn = ISBN;
        this.bookPrice = bookprice;
        this.rentalPrice = rentalprice;
    }
}




