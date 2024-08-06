package entity.book;

import java.util.Date;

public class CommonBookFactory implements BookFactory {
    @Override
    public CommonBook createBook(int bookID, String bookName, double bookPrice, Date rentalStartDate, Date rentalEndDate, String isRented, String borrowerName, String borrowerNumber) {
        return new CommonBook(bookID, bookName, bookPrice, rentalStartDate, rentalEndDate, isRented, borrowerName, borrowerNumber);
    }

    @Override
    public CommonBook createBook(String bookName, double bookPrice){
        return new CommonBook(bookName, bookPrice);
    }
}
