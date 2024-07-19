package use_case.rent_book.BorrowBook;

/**
 * Interface representing the input boundary for the use case of borrowing a book.
 */
public interface BorrowBookInputBoundary {

    /**
     * Borrows a book using the provided input data.
     *
     * @param returnBookInputData The input data containing relevant borrow information for book to be borrowed.
     */
    public void execute(BorrowBookInputData returnBookInputData);

    /**
     *  Cancel the current operation
     */
    public void cancel();

}
