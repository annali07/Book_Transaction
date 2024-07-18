package use_case.rent_book.RentMenu;

/**
 * The RentMenuOutputData class represents the output data for the rent menu operation.
 *
 */
public class RentMenuOutputData {
    private boolean notFindBook;
    private final int bookID;

    /**
     * Constructs a RentMenuOutputData object with the specified book ID and notFindBook status.
     *
     * @param bookID the ID of the book
     * @param notFindBook the status indicating whether the book was found
     */
    public RentMenuOutputData(int bookID, boolean notFindBook) {
        this.notFindBook = notFindBook;
        this.bookID = bookID;
    }

    /**
     * Gets the ID of the book.
     *
     * @return the book ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets the success status of finding the book.
     *
     * @param success the success status
     */
    public void setSuccess(boolean success) {
        this.notFindBook = success;
    }

    /**
     * Gets the default button status, which is "none".
     *
     * @return the default button status
     */
    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }
}
