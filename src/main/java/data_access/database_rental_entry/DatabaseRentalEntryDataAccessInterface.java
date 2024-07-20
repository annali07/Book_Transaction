package data_access.database_rental_entry;

import entity.purchase_entry.TransactionEntry;
import entity.rent_entry.RentalEntry;

import java.util.ArrayList;
import java.util.Date;

/**
 * DatabaseRentalEntryDataAccessInterface provides methods to perform operations on rental entries,
 * such as validating book IDs, retrieving rental entries, and calculating rental revenue.
 */
public interface DatabaseRentalEntryDataAccessInterface{
    /**
     * Validates the bookID by checking the provided bookID against stored book data.
     *
     * @param bookID the bookID to validate
     * @return true if the bookID matches a stored book, false otherwise
     */
    boolean validatebook(int bookID);

    /**
     * Retrieves a rental entry by its ID.
     *
     * @param entryID The ID of the rental entry to retrieve.
     * @return The RentalEntry object if found, or null if not found.
     */
    public RentalEntry getRentalEntry(int entryID);

    /**
     * Calculates the total rental revenue between two dates.
     *
     * @param startDate The start date of the period.
     * @param endDate   The end date of the period.
     * @return The total rental revenue between the given dates.
     */
    public double getRentRevenueBetweenDate(Date startDate, Date endDate);
}