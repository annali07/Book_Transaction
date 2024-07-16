package interface_adapter.RentInformation.returnbook;

import java.util.Date;

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
    public ReturnBookState(){}

    public int getBookID() {
        return this.bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBookIDError() {
        return this.bookIDError;
    }

    public void setBookIDError(int bookIDError) {
        this.bookIDError = bookIDError;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookNameError() {
        return this.bookNameError;
    }

    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    public Date getStartDate() {
        return this.rentStartDate;
    }

    public void setStartDate(Date rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public Date getStartDateError() {
        return this.rentStartDateError;
    }

    public void setStartDateError(Date rentStartDateError) {
        this.rentStartDateError = rentStartDateError;
    }

    public Date getEndDate() {
        return this.rentEndDate;
    }

    public void setEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public Date getRentEndDateError() {
        return this.rentEndDateError;
    }

    public void setEndDateError(Date rentEndDateError) {
        this.rentEndDateError = rentEndDateError;
    }

    public Date getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnDateError() {
        return this.returnDateError;
    }

    public void setReturnDateError(Date returnDateError) {
        this.returnDateError = returnDateError;
    }

}
