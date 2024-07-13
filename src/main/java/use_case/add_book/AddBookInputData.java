package use_case.add_book;

/**
 * Represents the input data required to add a book, specifically the ISBN.
 */
public class AddBookInputData {
    /**
     * The ISBN of the book to be added.
     */
    final private String isbn;

    /**
     * Constructs an AddBookInputData instance with the specified ISBN.
     *
     * @param isbn The ISBN of the book.
     */
    public AddBookInputData(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN.
     */
    String getIsbn() {
        return this.isbn;
    }
}
