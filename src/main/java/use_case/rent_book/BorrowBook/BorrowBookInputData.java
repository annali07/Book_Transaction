package use_case.rent_book.BorrowBook;

import java.util.Date;

/**
 * Represents the input data required to borrow a book, specifically the bookID, startDate,
 * endDate, borrowerName, borrowerNumber.
 */

public class BorrowBookInputData {

    /**
     * The ISBN of the book to be added.
     */
    private final int bookID;
    private final Date startDate;
    private final Date endDate;
    private final String borrowerName;
    private final String borrowerNumber;

    /**
     * Constructs an BorrowBookInputData instance with the specified borrower information.
     *
     * @param bookID The bookID of the book.
     * @param startDate the start date of the book to be borrowed
     * @param endDate the end date of the book to be borrowed
     * @param borrowerName the name of borrower
     * @param borrowerNumber the phone number of borrower
     */
    public BorrowBookInputData(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber){
        this.bookID = bookID;
        this.endDate = endDate;
        this.startDate = startDate;
        this.borrowerName = borrowerName;
        this.borrowerNumber = borrowerNumber;
    }

    /**
     * Returns the bookID of the book.
     *
     * @return The bookID.
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Returns the borrower name of the book.
     *
     * @return The borrower name.
     */
    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * Returns the borrow end date  of the book.
     *
     * @return The borrow end date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns the borrow start date of the book.
     *
     * @return The borrow start datN.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Returns the borrower name of the book.
     *
     * @return The borrower name.
     */
    public String getBorrowerNumber() {
        return borrowerNumber;
    }
}

