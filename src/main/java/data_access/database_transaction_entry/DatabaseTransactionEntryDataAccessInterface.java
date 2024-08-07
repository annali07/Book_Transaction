package data_access.database_transaction_entry;

import entity.purchase_entry.CommonTransactionEntry;

import java.util.Date;

/**
 * DatabaseTransactionEntryDataAccessInterface provides methods to perform CRUD operations on transaction entries.
 */
public interface DatabaseTransactionEntryDataAccessInterface {
    /**
     * Retrieves a transaction entry by its ID.
     *
     * @param id The ID of the transaction to retrieve.
     * @return The CommonTransactionEntry object if found, or null if not found.
     */
    public CommonTransactionEntry getTransactionEntry(int id);

    /**
     * Creates a new transaction entry.
     *
     * @param commonTransactionEntry The transaction entry to be created.
     * @return true if the transaction entry is successfully created, false otherwise.
     */
    public boolean createTransactionEntry(CommonTransactionEntry commonTransactionEntry);

    /**
     * Calculates the total purchase revenue between two dates.
     *
     * @param startDate The start date of the period.
     * @param endDate   The end date of the period.
     * @return The total purchase revenue between the given dates.
     */
    public double getPurchaseRevenueBetweenDate(Date startDate, Date endDate);
}
