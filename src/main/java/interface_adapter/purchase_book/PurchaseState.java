package interface_adapter.purchase_book;

import interface_adapter.add_book.AddBookState;

public class PurchaseState {
    private int bookId = 0;

    public PurchaseState(PurchaseState copy) {
        this.bookId = copy.bookId;
    }

    public PurchaseState() {

    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }
}
