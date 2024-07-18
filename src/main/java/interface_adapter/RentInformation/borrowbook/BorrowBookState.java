package interface_adapter.RentInformation.borrowbook;

import java.util.Date;

/**
 * The BorrowBookState class represents the state of the borrow book operation.
 * It includes various properties related to the book and borrower, and their respective error messages.
 *
 */
public class BorrowBookState{
    private int bookID = 0;
    private int bookIDError = 0;
    private Date rentStartDate = null;
    private Date rentStartDateError = null;
    private Date rentEndDate = null;
    private Date rentEndDateError = null;
    private String borrowerName = "";
    private String borrowerNumber = "";
    private String borrowerNameError = null;
    private String borrowerNumberError = null;

    private String bookName = "";
    private String bookNameError = null;

    /**
     * Constructs a new BorrowBookState object with default values.
     */
    public BorrowBookState(BorrowBookState copy){
        this.bookID = copy.bookID;
        this.bookIDError = copy.bookIDError;
        this.rentStartDate = copy.rentStartDate;
        this.rentStartDateError = copy.rentStartDateError;
        this.rentEndDate = copy.rentEndDate;
        this.rentEndDateError = copy.rentEndDateError;
        this.borrowerName = copy.borrowerName;
        this.borrowerNameError = copy.borrowerNameError;
        this.borrowerNumber = copy.borrowerNumber;
        this.borrowerNumberError = copy.borrowerNumberError;
        this.bookName = copy.bookName;
        this.bookNameError = copy.bookNameError;
    }

    public BorrowBookState(){}

    // Getters and Setters for bookID
    /**
     * Gets the book ID.
     *
     * @return the book ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets the book ID.
     *
     * @param bookID the book ID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    // Getters and Setters for bookIDError
    /**
     * Gets the book ID error.
     *
     * @return the book ID error
     */
    public int getBookIDError() {
        return bookIDError;
    }

    /**
     * Sets the book ID error.
     *
     * @param bookIDError the book ID error to set
     */
    public void setBookIDError(int bookIDError) {
        this.bookIDError = bookIDError;
    }

    // Getters and Setters for rentStartDate
    /**
     * Gets the rent start date.
     *
     * @return the rent start date
     */
    public Date getRentStartDate() {
        return rentStartDate;
    }

    /**
     * Sets the rent start date.
     *
     * @param rentStartDate the rent start date to set
     */
    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    // Getters and Setters for rentStartDateError
    /**
     * Gets the rent start date error.
     *
     * @return the rent start date error
     */
    public Date getRentStartDateError() {
        return rentStartDateError;
    }

    /**
     * Sets the rent start date error.
     *
     * @param rentStartDateError the rent start date error to set
     */
    public void setRentStartDateError(Date rentStartDateError) {
        this.rentStartDateError = rentStartDateError;
    }

    // Getters and Setters for rentEndDate
    /**
     * Gets the rent end date.
     *
     * @return the rent end date
     */
    public Date getRentEndDate() {
        return rentEndDate;
    }

    /**
     * Sets the rent end date.
     *
     * @param rentEndDate the rent end date to set
     */
    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    // Getters and Setters for rentEndDateError
    /**
     * Gets the rent end date error.
     *
     * @return the rent end date error
     */
    public Date getRentEndDateError() {
        return rentEndDateError;
    }

    /**
     * Sets the rent end date error.
     *
     * @param rentEndDateError the rent end date error to set
     */
    public void setRentEndDateError(Date rentEndDateError) {
        this.rentEndDateError = rentEndDateError;
    }

    // Getters and Setters for borrowerName
    /**
     * Gets the borrower name.
     *
     * @return the borrower name
     */
    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * Sets the borrower name.
     *
     * @param borrowerName the borrower name to set
     */
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // Getters and Setters for borrowerNumber
    /**
     * Gets the borrower number.
     *
     * @return the borrower number
     */
    public String getBorrowerNumber() {
        return borrowerNumber;
    }

    /**
     * Sets the borrower number.
     *
     * @param borrowerNumber the borrower number to set
     */
    public void setBorrowerNumber(String borrowerNumber) {
        this.borrowerNumber = borrowerNumber;
    }

    // Getters and Setters for borrowerNameError
    /**
     * Gets the borrower name error.
     *
     * @return the borrower name error
     */
    public String getBorrowerNameError() {
        return borrowerNameError;
    }

    /**
     * Sets the borrower name error.
     *
     * @param borrowerNameError the borrower name error to set
     */
    public void setBorrowerNameError(String borrowerNameError) {
        this.borrowerNameError = borrowerNameError;
    }

    // Getters and Setters for borrowerNumberError
    /**
     * Gets the borrower number error.
     *
     * @return the borrower number error
     */
    public String getBorrowerNumberError() {
        return borrowerNumberError;
    }

    /**
     * Sets the borrower number error.
     *
     * @param borrowerNumberError the borrower number error to set
     */
    public void setBorrowerNumberError(String borrowerNumberError) {
        this.borrowerNumberError = borrowerNumberError;
    }

    /**
     * Gets the book name.
     *
     * @return the book name
     */
    public String getBookName(){
        return bookName;
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
    public String getBookNameError(){
        return bookNameError;
    }

    /**
     * Sets the book name error.
     *
     * @param bookNameError the book name error to set
     */
    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }
}

