package interface_adapter.RentInformation.returnbook;

import java.util.Date;

/**
 * The ReturnBookState class represents the state of the return book operation.
 * It includes various properties related to the book and return details, and their respective error messages.
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
     * Constructs a new ReturnBookState object by copying another ReturnBookState object.
     *
     * @param copy the ReturnBookState object to copy
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
     * Constructs a new ReturnBookState object with default values.
     */
    public ReturnBookState(){}

    /**
     * Gets the book ID.
     *
     * @return the book ID
     */
    public int getBookID() {
        return this.bookID;
    }

    /**
     * Sets the book ID.
     *
     * @param bookID the book ID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * Gets the book ID error.
     *
     * @return the book ID error
     */
    public int getBookIDError() {
        return this.bookIDError;
    }

    /**
     * Sets the book ID error.
     *
     * @param bookIDError the book ID error to set
     */
    public void setBookIDError(int bookIDError) {
        this.bookIDError = bookIDError;
    }

    /**
     * Gets the book name.
     *
     * @return the book name
     */
    public String getBookName() {
        return this.bookName;
    }


    /**
     * Sets the book name.
     *
     * @param bookName the book name to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Gets the book name error.
     *
     * @return the book name error
     */
    public String getBookNameError() {
        return this.bookNameError;
    }

    /**
     * Sets the book name error.
     *
     * @param bookNameError the book name error to set
     */
    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    /**
     * Gets the rent start date.
     *
     * @return the rent start date
     */
    public Date getStartDate() {
        return this.rentStartDate;
    }

    /**
     * Sets the rent start date.
     *
     * @param rentStartDate the rent start date to set
     */
    public void setStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    /**
     * Gets the rent start date error.
     *
     * @return the rent start date error
     */
    public Date getStartDateError() {
        return this.rentStartDateError;
    }

    /**
     * Sets the rent start date error.
     *
     * @param rentStartDateError the rent start date error to set
     */
    public void setStartDateError(Date rentStartDateError) {
        this.rentStartDateError = rentStartDateError;
    }

    /**
     * Gets the rent end date.
     *
     * @return the rent end date
     */
    public Date getEndDate() {
        return this.rentEndDate;
    }

    /**
     * Sets the rent end date.
     *
     * @param rentEndDate the rent end date to set
     */
    public void setEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    /**
     * Gets the rent end date error.
     *
     * @return the rent end date error
     */
    public Date getRentEndDateError() {
        return this.rentEndDateError;
    }

    /**
     * Sets the rent end date error.
     *
     * @param rentEndDateError the rent end date error to set
     */
    public void setEndDateError(Date rentEndDateError) {
        this.rentEndDateError = rentEndDateError;
    }

    /**
     * Gets the return date.
     *
     * @return the return date
     */
    public Date getReturnDate() {
        return this.returnDate;
    }

    /**
     * Sets the return date.
     *
     * @param returnDate the return date to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Gets the return date error.
     *
     * @return the return date error
     */
    public Date getReturnDateError() {
        return this.returnDateError;
    }

    /**
     * Sets the return date error.
     *
     * @param returnDateError the return date error to set
     */
    public void setReturnDateError(Date returnDateError) {
        this.returnDateError = returnDateError;
    }

}
