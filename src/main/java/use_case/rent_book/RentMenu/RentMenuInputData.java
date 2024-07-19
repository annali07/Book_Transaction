package use_case.rent_book.RentMenu;

/**
 * Represents the input data required to search book, specifically the bookID.
 */

public class RentMenuInputData {
    /**
     * The bookID of the book to be searched.
     */
    final private int bookID;

    /**
     * Constructs an RentMenuInputData instance with the specified bookID.
     *
     * @param bookID the bookID of the book
     */
    public RentMenuInputData(int bookID) {
        this.bookID = bookID;
    }

    /**
     * Returns the bookID of the book.
     *
     * @return The bookID.
     */
    public int getBookID() {
        return bookID;
    }

}
