package entity.book;

public class BookFactory {

    // Method to create a Book with default values
    public static Book createDefaultBook() {
        return new Book(
                "DefaultBook ",   // Default book name
                0,                     // Default book ID
                "000-0-00-000000-0",   // Default ISBN
                0.0,                  // Default book price
                0.0                    // Default rental price
        );
    }

    // Method to create a Book with specified values
    public static Book createBook(String bookName, int bookID, String isbn, double bookPrice, double rentalPrice) {
        return new Book(bookName, bookID, isbn, bookPrice, rentalPrice);
    }
}

