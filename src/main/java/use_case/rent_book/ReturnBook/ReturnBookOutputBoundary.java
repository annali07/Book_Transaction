package use_case.rent_book.ReturnBook;

import use_case.rent_book.BorrowBook.BorrowBookOutputData;

public interface ReturnBookOutputBoundary {
    void prepareSuccessView(ReturnBookOutputData returnBookOutputData);
    void prepareCancelView();
}
