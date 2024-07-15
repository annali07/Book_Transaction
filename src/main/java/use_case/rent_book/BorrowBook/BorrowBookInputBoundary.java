package use_case.rent_book.BorrowBook;

public interface BorrowBookInputBoundary {
    public void execute(BorrowBookInputData returnBookInputData);

    public void cancel();

}
