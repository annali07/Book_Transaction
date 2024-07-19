package interface_adapter.RentInformation.returnbook;

import java.util.Date;

/**
 * Represents the state of the return book operation, including the bookID, bookName, rentStartDate, rentEndDate,
 * and returnDate.
 *
 */
public class ReturnBookState {
    private int bookID = 0;
    private int bookIDError = 0;
    private String bookName = "";
    private String bookNameError = "";
    private Date rentStartDate = null;
    private Date rentStartDateError = null;
    private Date rentEndDate = null;
    private Date rentEndDateError = null;
    private Date returnDate = null;
    private Date returnDateError = null;

    /**
     * Constructs a new ReturnBookState by copying another ReturnBookState.
     *
     * @param copy the ReturnBookState to copy
     */
    public ReturnBookState(ReturnBookState copy){
        this.bookID = copy.bookID;
        this.bookIDError = copy.bookIDError;
        this.bookName = copy.bookName;
        this.bookNameError = copy.bookNameError;
        this.rentStartDate = copy.rentStartDate;
        this.rentEndDate = copy.rentEndDate;
        this.rentStartDateError = copy.rentStartDateError;
        this.rentEndDateError = copy.rentEndDateError;
        this.returnDate = copy.returnDate;
        this.returnDateError = copy.returnDateError;
    }

    /**
     * Constructs a new ReturnBookState with default values.
     */
    public ReturnBookState(){}

    /**
     * Returns the bookID of this state.
     *
     * @return the bookID
     */

    public int getBookID() {
        return this.bookID;
    }

    /**
     * Sets the bookID for this state.
     *
     * @param bookID the bookID to set
     */

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * Returns the book name of this state.
     *
     * @return the bookName
     */

    public String getBookName() {
        return this.bookName;
    }

    /**
     * Sets the book name for this state.
     *
     * @param bookName the bookName to set
     */

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Returns the rentStartDate of this state.
     *
     * @return the rentStartDate
     */

    public Date getStartDate() {
        return this.rentStartDate;
    }

    /**
     * Sets the rentStartDate for this state.
     *
     * @param rentStartDate the rentStartDate to set
     */

    public void setStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    /**
     * Returns the end date of this state.
     *
     * @return the rentEndDate
     */

    public Date getEndDate() {
        return this.rentEndDate;
    }

    /**
     * Sets the rentEndDate for this state.
     *
     * @param rentEndDate the rentEndDate to set
     */

    public void setEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    /**
     * Returns the return date of this state.
     *
     * @return the return date
     */

    public Date getReturnDate() {
        return this.returnDate;
    }

    /**
     * Sets the ReturnDate for this state.
     *
     * @param returnDate the return date to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
