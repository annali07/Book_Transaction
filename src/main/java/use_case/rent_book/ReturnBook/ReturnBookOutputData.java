package use_case.rent_book.ReturnBook;

/**
 * The ReturnBookOutputData class represents the output data for the return book operation.
 *
 */
public class ReturnBookOutputData {
    private final int bookID;
    private final int charge;

    /**
     * Constructs a ReturnBookOutputData object with the specified book ID and charge.
     *
     * @param bookID the ID of the returned book
     * @param charge the charge for overdue return
     */
    public ReturnBookOutputData(int bookID, int charge){
        this.bookID = bookID;
        this.charge = charge;
    }

    /**
     * Gets the ID of the returned book.
     *
     * @return the book ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Gets the charge for the overdue return.
     *
     * @return the charge
     */
    public int getCharge(){
        return charge;
    }

    /**
     * Gets the default button status, which is "none".
     *
     * @return the default button status
     */
    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }
}
