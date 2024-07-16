package data_access.database_transaction_entry;

import entity.purchase_entry.TransactionEntry;

import java.util.ArrayList;
import java.util.Date;

public interface DatabaseTransactionEntryDataAccessInterface {
    public TransactionEntry getTransactionEntry(int id);
    public boolean createTransactionEntry(TransactionEntry transactionEntry);
    public ArrayList<TransactionEntry> getTransactionEntriesBetweenDate(Date startDate, Date endDate);

}
