package interface_adapter.RentInformation.borrowbook;

import java.util.Date;

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
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    // Getters and Setters for bookIDError
    public int getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(int bookIDError) {
        this.bookIDError = bookIDError;
    }

    // Getters and Setters for rentStartDate
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

    public void setRentStartDateError(Date rentStartDateError) {
        this.rentStartDateError = rentStartDateError;
    }

    // Getters and Setters for rentEndDate
    public Date getRentEndDate() {
        return rentEndDate;
    }

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
    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // Getters and Setters for borrowerNumber
    public String getBorrowerNumber() {
        return borrowerNumber;
    }

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

    public String getBookName(){
        return bookName;
    }

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

