package use_case.add_book;

public class AddBookInputData {
    final private String isbn;

    public AddBookInputData(String isbn){
        this.isbn = isbn;
    }

    String getIsbn(){return this.isbn;}
}
