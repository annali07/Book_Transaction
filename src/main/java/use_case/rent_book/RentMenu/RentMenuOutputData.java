package use_case.rent_book.RentMenu;

/**
 * Represents the output data for a search book attempt, including the bookID of the relevant book.
 */
public class RentMenuOutputData {

    /**
     * Indicates whether the book has been found.
     */
    private boolean notFindBook;

    /**
     * The bookID of the book searched.
     */
    private final int bookID;

    /**
     * Constructs a RentMenuOutputData instance with the specified bookID and notFindBook.
     *
     * @param bookID    The bookID of the searched book
     * @param notFindBook Indicates whether the book has been searched
     */
    public RentMenuOutputData(int bookID, boolean notFindBook) {
        this.notFindBook = notFindBook;
        this.bookID = bookID;
    }

    /**
     * Returns the bookID of the book searched.
     *
     * @return the bookID.
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets the success status of the search book attempt.
     *
     * @param success The success status to set.
     */
    public void setSuccess(boolean success) {
        this.notFindBook = success;
    }

    /**
     * Returns the default active button status.
     *
     * @return The default active button status.
     */
    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }
}
