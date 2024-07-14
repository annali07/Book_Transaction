package data_access.database_transaction_entry;

import entity.purchase_entry.TransactionEntry;

public interface DatabaseTransactionEntryDataAccessInterface {
//    public TransactionEntry getTransactionEntry(int id);
    public boolean createTransactionEntry(TransactionEntry transactionEntry);
    public int createTransactionID();
}
