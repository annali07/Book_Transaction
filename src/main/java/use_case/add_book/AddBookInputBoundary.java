package use_case.add_book;

/**
 * Interface representing the input boundary for the use case of adding a book.
 */
public interface AddBookInputBoundary {
    /**
     * Adds a book using the provided input data.
     *
     * @param addBookInputData The input data containing the ISBN of the book to be added.
     */
    void addBook(AddBookInputData addBookInputData);

    void cancel();
}
