package data_access.data_base_return_book;

import entity.rent_entry.CommonRentalEntry;

/**
 * Interface for database operations related to returning books.
 */
public interface DatabaseReturnInterface {
    /**
     * Edits the book file to update information related to the return of a book.
     *
     * @param bookID the ID of the book to edit
     */
    public void editBookFile(int bookID);

    /**
     * Writes the rental entry information to the return file.
     *
     * @param commonRentalEntry the rental entry to write
     */
    public void writeReturnFile(CommonRentalEntry commonRentalEntry);
}
