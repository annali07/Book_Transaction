package data_access.add_book_repository;
import com.google.gson.JsonObject;
import entity.book.Book;

/**
 * Interface for a data access object that provides methods to save books.
 */
public interface BookRepositoryDataAccessInterface {
    /**
     * Saves the given book to the repository.
     *
     * @param book the book to be saved
     */
    void saveBook(Book book);
    JsonObject getBook(int bookId);
}
