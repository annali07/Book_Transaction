package use_case.rent_book.BorrowBook;

/**
 * Interface representing the output boundary for the borrow book use case.
 */
public interface BorrowBookOutputBoundary {

    /**
     * Prepares the success view with the provided user data.
     *
     * @param returnBookOutputData The output data containing the borrow book information after a successful borrow.
     */
    void prepareSuccessView(BorrowBookOutputData returnBookOutputData);

    /**
     * Prepares the Cancel view.
     *
     */
    void prepareCancelView();

}
