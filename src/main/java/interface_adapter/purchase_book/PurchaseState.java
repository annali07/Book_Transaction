package interface_adapter.purchase_book;

public class PurchaseState {
    private int bookId = 0;

    public PurchaseState() {

    }

    public void setPurchaseState(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }
}
