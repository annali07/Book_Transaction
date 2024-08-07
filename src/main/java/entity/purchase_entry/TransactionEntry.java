package entity.purchase_entry;

import java.util.Date;

public interface TransactionEntry {
    public int getTransactionId();

    public int getBookId();

    public void setBookId(int bookId);

    public String getBookName();

    public void setBookName(String bookName);

    public double getSoldPrice();

    public void setSoldPrice(int soldPrice);

    public Date getDate();

    public void setDate(Date date);

    public void setTransactionId();
}
