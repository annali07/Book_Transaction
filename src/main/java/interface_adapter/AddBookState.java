package interface_adapter;

public class AddBookState {
    private String isbn = "";
    private String addBookError = null;

    public AddBookState(AddBookState copy) {
        addBookError = copy.addBookError;
        isbn = copy.isbn;
    }

    public AddBookState(){}

    public void setISBN(String isbn) {this.isbn = isbn;}

    public String getISBN() {return isbn;}
}
