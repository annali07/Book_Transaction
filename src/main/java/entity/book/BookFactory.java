package entity.book;

import java.util.Date;

public interface BookFactory {
//    // Method to create a CommonBook with default values
//    public static CommonBook createDefaultBook() {
//        return new CommonBook(
//                "DefaultBook ",   // Default book name
//                0,                     // Default book ID
//                "000-0-00-000000-0",   // Default ISBN
//                0.0,                  // Default book price
//                0.0                    // Default rental price
//        );
//    }
//    // Method to create a CommonBook with specified values
//    public static CommonBook createBook(String bookName, int bookID, String isbn, double bookPrice, double rentalPrice) {
//        return new CommonBook(bookName, bookID, isbn, bookPrice, rentalPrice);
//    }

    CommonBook createBook(int bookID, String bookName, double bookPrice, Date rentalStartDate, Date rentalEndDate, String isRented, String borrowerName, String borrowerNumber);

    CommonBook createBook(String bookName, double bookPrice);

}

