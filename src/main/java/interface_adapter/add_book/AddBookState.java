package interface_adapter.add_book;

/**
 * Represents the state of the add book operation, including the ISBN, price, and any error message.
 */
public class AddBookState {
    private String isbn = "";
    private int price = 0;
    private String addBookError = null;

    /**
     * Constructs a new AddBookState by copying another AddBookState.
     *
     * @param copy the AddBookState to copy
     */
    public AddBookState(AddBookState copy) {
        addBookError = copy.addBookError;
        isbn = copy.isbn;
        price = copy.price;
    }

    /**
     * Constructs a new AddBookState with default values.
     */
    public AddBookState(){}

    /**
     * Sets the ISBN for this state.
     *
     * @param isbn the ISBN to set
     */
    public void setISBN(String isbn) {this.isbn = isbn;}

    /**
     * Sets the price for this state.
     *
     * @param price the price to set
     */
    public void setPrice(int price){this.price = price;}

    /**
     * Returns the ISBN of this state.
     *
     * @return the ISBN
     */
    public String getISBN() {return this.isbn;}

    /**
     * Returns the price of this state.
     *
     * @return the price
     */
    public int getPrice() {return this.price;}
}
