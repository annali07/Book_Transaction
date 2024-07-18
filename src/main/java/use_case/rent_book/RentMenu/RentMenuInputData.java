package use_case.rent_book.RentMenu;

/**
 * The RentMenuInputData class represents the input data required for the rent menu.
 *
 */
public class RentMenuInputData {
    final private int bookID;

    /**
     * Constructs a RentMenuInputData object with the specified book ID.
     *
     * @param bookID the ID of the book to be rented
     */
    public RentMenuInputData(int bookID) {
        this.bookID = bookID;
    }

    /**
     * Gets the ID of the book to be rented.
     *
     * @return the book ID
     */
    public int getBookID() {
        return bookID;
    }

}
