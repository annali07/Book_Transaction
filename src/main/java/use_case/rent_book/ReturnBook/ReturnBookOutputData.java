package use_case.rent_book.ReturnBook;

public class ReturnBookOutputData {
    private final int bookID;
    private final int charge;

    public ReturnBookOutputData(int bookID, int charge){
        this.bookID = bookID;
        this.charge = charge;
    }

    public int getBookID() {
        return bookID;
    }

    public int getCharge(){
        return charge;
    }

    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }
}
