package use_case.rent_book.BorrowBook;

import java.util.Date;

/**
 * The BorrowBookInputData class represents the input data required for borrowing a book.
 *
 */
public class BorrowBookInputData {
    private final int bookID;
    private final Date startDate;
    private final Date endDate;
    private final String borrowerName;
    private final String borrowerNumber;


    /**
     * Constructs a BorrowBookInputData object with the specified book ID, start date, end date, borrower's name, and borrower's contact number.
     *
     * @param bookID the ID of the book to be borrowed
     * @param startDate the start date of the borrowing period
     * @param endDate the end date of the borrowing period
     * @param borrowerName the name of the person borrowing the book
     * @param borrowerNumber the contact number of the person borrowing the book
     */
    public BorrowBookInputData(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber){
        this.bookID = bookID;
        this.endDate = endDate;
        this.startDate = startDate;
        this.borrowerName = borrowerName;
        this.borrowerNumber = borrowerNumber;
    }


    /**
     * Gets the ID of the book to be borrowed.
     *
     * @return the book ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Gets the name of the person borrowing the book.
     *
     * @return the borrower's name
     */
    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * Gets the end date of the borrowing period.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Gets the start date of the borrowing period.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Gets the contact number of the person borrowing the book.
     *
     * @return the borrower's contact number
     */
    public String getBorrowerNumber() {
        return borrowerNumber;
    }
}

