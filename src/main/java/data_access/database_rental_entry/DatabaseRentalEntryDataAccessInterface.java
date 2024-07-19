package data_access.database_rental_entry;

import entity.purchase_entry.TransactionEntry;
import entity.rent_entry.RentalEntry;

import java.util.ArrayList;
import java.util.Date;

public interface DatabaseRentalEntryDataAccessInterface{

    /**
     * Validates the bookID by checking the provided bookID against stored bookData.
     *
     * @param bookID the bookID to validate
     * @return true if the bookID matches a stored user, false otherwise
     */

    boolean validatebook(int bookID);
//    public boolean createTransactionEntry(TransactionEntry transactionEntry);
//    public int createTransactionID();
    public RentalEntry getRentalEntry(int entryID);
    public double getRentRevenueBetweenDate(Date startDate, Date endDate);

}