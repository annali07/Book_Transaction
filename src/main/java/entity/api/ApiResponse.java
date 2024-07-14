package entity.api;

/**
 * Represents the response from an external book API.
 */
public class ApiResponse {
    private final String bookName;
    private final String author;

    /**
     * Constructs an ApiResponse with the specified book name and author.
     *
     * @param bookName the name of the book
     * @param author the author of the book
     */
    public ApiResponse(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    /**
     * Returns the name of the book.
     *
     * @return the book name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
}
