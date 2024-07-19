package data_access.data_base_return_book;

/**
 * Interface for a data access object that provides methods to return books.
 */
public interface DatabaseReturnInterface {

    /**
     * Find the book in database with bookID given.
     * Edit the database with update book information
     */
    public void editBookFile(int bookID);

    /**
     * write bookID and Charge into a new file
     *
     */
    public void writeReturnFile(int bookID, int Charge);
}
