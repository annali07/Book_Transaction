package entity.purchase_entry;
import  java.util.Date;

public class TransactionEntry {
    private int transactionId;
    private int bookId;
    private String bookName;
    private double soldPrice;
    private Date date;

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

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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


}