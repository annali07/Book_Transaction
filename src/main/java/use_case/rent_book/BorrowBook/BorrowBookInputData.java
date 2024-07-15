package use_case.rent_book.BorrowBook;

import java.util.Date;

public class BorrowBookInputData {
    private final int bookID;
    private final Date startDate;
    private final Date endDate;
    private final String borrowerName;
    private final String borrowerNumber;

    public BorrowBookInputData(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber){
        this.bookID = bookID;
        this.endDate = endDate;
        this.startDate = startDate;
        this.borrowerName = borrowerName;
        this.borrowerNumber = borrowerNumber;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getBorrowerNumber() {
        return borrowerNumber;
    }
}

