package interface_adapter.RentInformation.borrowbook;

import java.util.Date;

/**
 * Represents the state of the borrow book operation, including the bookID, rentStartDate, rentEndDate,
 * borrowerName, borrowerNumber, and bookName.
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
     * Constructs a new BorrowBookState by copying another BorrowBookState.
     *
     * @param copy the BorrowBookState to copy
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

    /**
     * Constructs a new BorrowBookState with default values.
     */
    public BorrowBookState(){}

    // Getters and Setters for bookID
    
    /**
     * Returns the bookID of this state.
     *
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets the bookID for this state.
     *
     * @param bookID the bookID to set
     */

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    
    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }


    // Getters and Setters for bookIDError
    public int getBookIDError() {
        return bookIDError;
    }

     public void setBookIDError(int bookIDError) {
        this.bookIDError = bookIDError;
    }

    // Getters and Setters for rentStartDate
    /**
     * Returns the rentStartDate of this state.
     *
     * @return the rentStartDate
     */
    public Date getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    // Getters and Setters for rentStartDateError
    public Date getRentStartDateError() {
        return rentStartDateError;
    }

    /**
     * Sets the rentStartDate for this state.
     *
     * @param rentStartDate the rentStartDate to set
     */
    public void setRentStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    /**
     * Sets the rentStartDateError for this state.
     *
     * @param rentStartDateError the rentStartDateError to set
     */
    public void setRentStartDateError(Date rentStartDateError) {
        this.rentStartDateError = rentStartDateError;
    }

    // Getters and Setters for rentEndDate
    /**
     * Returns the rentEndDate of this state.
     *
     * @return the rentEndDate
     */
    public Date getRentEndDate() {
        return rentEndDate;
    }

    /**
     * Sets the renEndDate for this state.
     *
     * @param rentEndDate the rentEndDate to set
     */
    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    // Getters and Setters for rentEndDateError
    public Date getRentEndDateError() {
        return rentEndDateError;
    }
    
    public void setRentEndDateError(Date rentEndDateError) {
        this.rentEndDateError = rentEndDateError;
    }

    // Getters and Setters for borrowerName
    /**
     * Returns the borrowerName of this state.
     *
     * @return the borrowerName
     */
    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * Sets the borrowerName for this state.
     *
     * @param borrowerName the borrowerName to set
     */
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // Getters and Setters for borrowerNumber
    /**
     * Returns the borrowerNumber of this state.
     *
     * @return the borrowerNumber
     */
    public String getBorrowerNumber() {
        return borrowerNumber;
    }

    /**
     * Sets the borrowerNumber for this state.
     *
     * @param borrowerNumber the borrowerNumber to set
     */
    public void setBorrowerNumber(String borrowerNumber) {
        this.borrowerNumber = borrowerNumber;
    }

    // Getters and Setters for borrowerNameError
    public String getBorrowerNameError() {
        return borrowerNameError;
    }

    public void setBorrowerNameError(String borrowerNameError) {
        this.borrowerNameError = borrowerNameError;
    }

    // Getters and Setters for borrowerNumberError
    public String getBorrowerNumberError() {
        return borrowerNumberError;
    }
    
    public void setBorrowerNumberError(String borrowerNumberError) {
        this.borrowerNumberError = borrowerNumberError;
    }

    /**
     * Returns the bookName of this state.
     *
     * @return the bookName
     */
    public String getBookName(){
        return bookName;
    }

    /**
     * Sets the bookName for this state.
     *
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookNameError(){
        return bookNameError;
    }
    
    
    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }
}

   
