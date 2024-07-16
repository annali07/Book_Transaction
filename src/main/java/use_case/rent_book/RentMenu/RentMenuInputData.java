package use_case.rent_book.RentMenu;

public class RentMenuInputData {
    final private int bookID;

    public RentMenuInputData(int bookID) {
        this.bookID = bookID;
    }

    public int getBookID() {
        return bookID;
    }

}
