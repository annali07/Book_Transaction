
package interface_adapter.RentMenu;

/**
 * Represents the state of the search book operation, including bookID.
 *
 */
public class RentMenuState {
    // You need to search for book before actual rental
    private int bookID = 0;


    private  int bookIDError = 0;

    /**
     * Constructs a new RentMenuState by copying another RentMenuState.
     *
     * @param copy the RentMenuState to copy
     */
    public RentMenuState(RentMenuState copy) {
        this.bookID = copy.bookID;
        this.bookIDError = copy.bookIDError;
    }

    /**
     * Constructs a new RentMenuState with default values.
     */

    public RentMenuState() {}

    /**
     * Returns the bookID of this state.
     *
     * @return the bookID
     */

    public int getBookID(){return this.bookID; }

    /**
     * Sets the bookID for this state.
     *
     * @param bookID the bookID to set
     */
    public void setBookID(int bookID) {this.bookID = bookID;}

}


