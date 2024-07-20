package interface_adapter.returnorborrow;

/**
 * Represents the state of the return or borrow book operation, including bookID.
 *
 */
public class ReturnOrBorrowState {
    private int bookId = 0;

    /**
     * Constructs a new ReturnOrBorrowState by copying another ReturnOrBorrowState.
     *
     * @param copy the ReturnOrBorrowState to copy
     */

    public ReturnOrBorrowState(ReturnOrBorrowState copy) {
        bookId = copy.bookId;
    }
    public ReturnOrBorrowState() {}

    /**
     * Sets the bookID for this state.
     *
     * @param bookId the ISBN to set
     */
    public  void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
