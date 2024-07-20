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
     * @param book the book to be updated
     */
    boolean saveBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(int bookId);
    JsonObject getBook(int bookId);
}
