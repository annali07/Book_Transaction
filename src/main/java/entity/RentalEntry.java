package entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RentalEntry {
    private int rentalId;
    private int bookId;
    private String bookName;
    private String borrowerName;
    private String borrowerPhoneNumber;
    private double charge;
    private Date rentalStartDate;
    private Date rentalEndDate;
    private boolean returned;
    private double maxCharge;

    public RentalEntry(int rentalId, int bookId, double charge, String bookName, String borrowerName, String borrowerPhoneNumber, Date rentalStartDate, Date rentalEndDate) {
        this.rentalId = rentalId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.borrowerName = borrowerName;
        this.borrowerPhoneNumber = borrowerPhoneNumber;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.returned = false; // Default Value
        this.charge = charge; // Daily Charge
        this.maxCharge = 15 * charge; // Maximum Charge

    }

    public double getMaxCharge(){return this.maxCharge; }

    public void setMaxCharge(int maxCharge){this.maxCharge = maxCharge; }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerPhoneNumber() {
        return borrowerPhoneNumber;
    }

    public void setBorrowerPhoneNumber(String borrowerPhoneNumber) {
        this.borrowerPhoneNumber = borrowerPhoneNumber;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Date getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(Date rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public Date getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Date rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public double calculateCharge(){
        Date currentDate = new Date();
        if (currentDate.after(rentalEndDate)){
            long diffInMillies = Math.abs(currentDate.getTime() - rentalEndDate.getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            return Math.min(diffInDays * this.charge, this.maxCharge);
        }
        else{
            return 0.0;
        }
    }

}
