package interface_adapter.returnorborrow;

public class ReturnOrBorrowState {
    private int bookId = 0;

    public ReturnOrBorrowState(ReturnOrBorrowState copy) {
        bookId = copy.bookId;
    }
    public ReturnOrBorrowState() {}

    public  void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
