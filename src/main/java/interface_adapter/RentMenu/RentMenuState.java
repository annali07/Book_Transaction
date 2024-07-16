
package interface_adapter.RentMenu;

public class RentMenuState {
    // You need to search for book before actual rental
    private int bookID = 0;


    private  int bookIDError = 0;

    public RentMenuState(RentMenuState copy) {
        this.bookID = copy.bookID;
        this.bookIDError = copy.bookIDError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public RentMenuState() {}

    public int getBookID(){return this.bookID; }

    public void setBookID(int bookID) {this.bookID = bookID;}

    public int getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(int bookIDError) {
        this.bookIDError = bookIDError;
    }

}


