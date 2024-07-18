package interface_adapter.purchase_book;

import interface_adapter.add_book.AddBookState;

/**
 * PurchaseState class represents the state of a book purchase.
 *
 * @version 1.0
 */
public class PurchaseState {
    private int bookId = 0;

    /**
     * Constructs a new PurchaseState object using an existing PurchaseState object.
     *
     * @param copy an existing PurchaseState object
     */
    public PurchaseState(PurchaseState copy) {
        this.bookId = copy.bookId;
    }

    /**
     * Constructs a PurchaseState object.
     */
    public PurchaseState() {

    }

    /**
     * Sets the book ID.
     *
     * @param bookId the book ID
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets the book ID.
     *
     * @return the book ID
     */
    public int getBookId() {
        return bookId;
    }
}
