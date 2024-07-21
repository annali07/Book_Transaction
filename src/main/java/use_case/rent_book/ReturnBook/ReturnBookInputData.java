package use_case.rent_book.ReturnBook;

import java.util.Date;

/**
 * The ReturnBookInputData class represents the input data required for returning a book.
 *
 */
public class ReturnBookInputData {
    private int bookID;
    private Date returnDate;
    private Date endDate;
    private Date startDate;

    /**
     * Constructs a ReturnBookInputData object with the specified book ID, return date, and end date.
     *
     * @param bookID the ID of the book to be returned
     * @param returnDate the date when the book is returned
     * @param endDate the end date of the borrowing period
     */
    public ReturnBookInputData(int bookID, Date returnDate, Date endDate, Date startDate){
        this.bookID = bookID;
        this.returnDate = returnDate;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    /**
     * Gets the ID of the book to be returned.
     *
     * @return the book ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets the ID of the book to be returned.
     *
     * @param bookID the book ID
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
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
     * Gets the date when the book is returned.
     *
     * @return the return date
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the date when the book is ended.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Sets the date when the book is returned.
     *
     * @param returnDate the return date
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Return the start date of the returned book
     * @return start date of the book
     */
    public Date getStartDate() {return startDate;}

    /**
     * Set the start date of the returned book
     * @param newStartDate new start date to be set
     */
    public void setStartDate(Date newStartDate) {
        this.startDate = newStartDate;
    }
}

