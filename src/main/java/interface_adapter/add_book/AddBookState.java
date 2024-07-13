package interface_adapter.add_book;

public class AddBookState {
    private String isbn = "";
    private int price = 0;
    private String addBookError = null;

    public AddBookState(AddBookState copy) {
        addBookError = copy.addBookError;
        isbn = copy.isbn;
        price = copy.price;
    }

    public AddBookState(){}

    public void setISBN(String isbn) {this.isbn = isbn;}

    public void setPrice(int price){this.price = price;}

    public String getISBN() {return isbn;}

    public int getPrice() {return price;}
}
