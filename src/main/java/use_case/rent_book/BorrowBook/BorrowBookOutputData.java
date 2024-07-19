package use_case.rent_book.BorrowBook;

import java.util.Date;

/**
 * Represents the output data for a book borrow, including the bookID, startDate, endDate, borrowerName, borrowerNumber.
 */
public class BorrowBookOutputData {

    /**
     * all relevant borrow information
     */
    private final int bookID;
    private final Date startDate;
    private final Date endDate;
    private final String borrowerName;
    private final String borrowerNumber;

    /**
     * Constructs a BorrowBookOutputDate instance with the specified borrow information.
     *
     * @param bookID   The bookID of the borrow book.
     * @param startDate The start date of the borrow book.
     * @param  endDate the end date of the borrow book.
     * @param  borrowerNumber the phone number of the borrow book
     * @param borrowerName the name of the borrower
     */
    public BorrowBookOutputData(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber){
        this.bookID = bookID;
        this.endDate = endDate;
        this.startDate = startDate;
        this.borrowerName = borrowerName;
        this.borrowerNumber = borrowerNumber;
    }
    /**
     * Returns the bookID of the borrowed book.
     *
     * @return The bookID.
     */

    public int getBookID() {
        return bookID;
    }
    /**
     * Returns the borrower name.
     *
     * @return The borrower name.
     */

    public String getBorrowerName() {
        return borrowerName;
    }
    /**
     * Returns the borrow end date.
     *
     * @return The borrow end date.
     */

    public Date getEndDate() {
        return endDate;
    }
    /**
     * Returns the start date of the borrowed book.
     *
     * @return The borrow start date.
     */

    public Date getStartDate() {
        return startDate;
    }
    /**
     * Returns the borrower name.
     *
     * @return The borrower name.
     */

    public String getBorrowerNumber() {
        return borrowerNumber;
    }
    /**
     * Returns the default active button status.
     *
     * @return The default active button status.
     */

    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }

}
