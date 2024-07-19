package data_access.database_borrow_book;

import java.util.Date;

/**
 * Interface for a data access object that provides methods to borrow books.
 */
public interface DatabaseBorrowInterface {

    /**
     * Find the book in database with bookID given.
     * Edit the database with borrow book information
     */
    public void writeBorrowFile(int bookID, Date startDate, Date endDate, String borrowerName,String borrowerNumber);
}
