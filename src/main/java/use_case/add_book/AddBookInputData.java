package use_case.add_book;

/**
 * Represents the input data required to add a book, specifically the ISBN.
 */
public class AddBookInputData {
    final private String isbn;
    final private double price;

    /**
     * Constructs an AddBookInputData instance with the specified ISBN.
     *
     * @param isbn The ISBN of the book.
     */
    public AddBookInputData(String isbn, double price) {
        this.isbn = isbn;
        this.price = price;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN.
     */
    String getIsbn() {
        return this.isbn;
    }

    /**
     * Retrieves the price.
     *
     * @return the price as an integer
     */
    double getPrice() {return this.price;}
}
