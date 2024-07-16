package use_case.rent_book.ReturnBook;

import java.util.Date;

public class ReturnBookInputData {
    private int bookID;
    private Date returnDate;
    private Date endDate;

    public ReturnBookInputData(int bookID, Date returnDate, Date endDate){
        this.bookID = bookID;
        this.returnDate = returnDate;
        this.endDate = endDate;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

