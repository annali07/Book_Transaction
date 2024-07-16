package data_access.database_rental_entry;

public interface DatabaseRentalEntryDataAccessInterface{

    /**
     * Validates the bookID by checking the provided bookID against stored bookData.
     *
     * @param bookID the bookID to validate
     * @return true if the bookID matches a stored user, false otherwise
     */

    boolean validatebook(int bookID);
}