package use_case.rent_book.ReturnBook;

import use_case.rent_book.BorrowBook.BorrowBookOutputData;

/**
 * Interface representing the output boundary for the return book use case.
 */
public interface ReturnBookOutputBoundary {

    /**
     * Prepares the success view with the provided return book data.
     *
     * @param returnBookOutputData The output data containing the return book information after a successful return book.
     */
    void prepareSuccessView(ReturnBookOutputData returnBookOutputData);
    void prepareCancelView();
}
