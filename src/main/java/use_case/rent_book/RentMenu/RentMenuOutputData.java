package use_case.rent_book.RentMenu;

public class RentMenuOutputData {
    private boolean notFindBook;
    private final int bookID;

    public RentMenuOutputData(int bookID, boolean notFindBook) {
        this.notFindBook = notFindBook;
        this.bookID = bookID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setSuccess(boolean success) {
        this.notFindBook = success;
    }

    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }
}
