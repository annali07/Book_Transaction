package data_access.add_book_repository;

import entity.book.CommonBook;

import java.util.Date;

/**
 * Interface for a data access object that provides methods to save books.
 */
public interface BookRepositoryDataAccessInterface {
    /**
     * Saves the given book to the repository.
     *
     * @param book the book to be updated
     */
    boolean saveBook(CommonBook book);
    public boolean updateBook(int bookID, Date startDate, Date endDate, String borrowerName, String borrowerNumber);    boolean deleteBook(int bookId);
    boolean findBook(int bookId);
    CommonBook getBook(int bookId);
}
