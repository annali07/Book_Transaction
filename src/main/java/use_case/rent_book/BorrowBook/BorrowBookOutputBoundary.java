package use_case.rent_book.BorrowBook;

public interface BorrowBookOutputBoundary {
    void prepareSuccessView(BorrowBookOutputData returnBookOutputData);
    void prepareCancelView();

}
