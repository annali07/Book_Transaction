package use_case;

public class PurchaseInputData {
        final private int bookId;
        public PurchaseInputData(int bookId) {
            this.bookId = bookId;
        }

        public int getBookId() {
            return bookId;
        }
}
