package use_case.purchase_book;

/**
 * The PurchaseInputData class represents the input data required for purchasing a book.
 *
 */
public class PurchaseInputData {
        final private int bookId ;

        /**
         * Constructs a PurchaseInputData object with the specified book ID.
         */
        public PurchaseInputData() {
            this.bookId = getBookId();
        }

        /**
         * Gets the ID of the book to be purchased.
         *
         * @return the book ID
         */
        public int getBookId() {
            return bookId;
        }
}
