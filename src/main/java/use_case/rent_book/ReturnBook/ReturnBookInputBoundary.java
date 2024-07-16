package use_case.rent_book.ReturnBook;

public interface ReturnBookInputBoundary {
    public void execute(ReturnBookInputData returnBookInputData);
    public void cancel();
}
