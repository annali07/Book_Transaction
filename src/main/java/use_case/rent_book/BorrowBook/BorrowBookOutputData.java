package use_case.rent_book.BorrowBook;

import java.util.Date;

/**
 * The BorrowBookOutputData class represents the output data for borrowing a book.
 *
 * @version 1.0
 */
public class BorrowBookOutputData {
    private final int bookID;
    private final Date startDate;
    private final Date endDate;
    private final String borrowerName;
    private final String borrowerNumber;

    /**
     * Constructs a BorrowBookOutputData object with the specified book ID, start date, end date, borrower's name, and borrower's contact number.
     *
     * @param bookID the ID of the borrowed book
     * @param startDate the start date of the borrowing period
     * @param endDate the end date of the borrowing period
     * @param borrowerName the name of the person borrowing the book
     * @param borrowerNumber the contact number of the person borrowing the book
     */
    public BorrowBookOutputData(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber){
        this.bookID = bookID;
        this.endDate = endDate;
        this.startDate = startDate;
        this.borrowerName = borrowerName;
        this.borrowerNumber = borrowerNumber;
    }

    /**
     * Gets the ID of the borrowed book.
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

    /**
     * Gets the default button status, which is "none".
     *
     * @return the default button status
     */
    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }

}
