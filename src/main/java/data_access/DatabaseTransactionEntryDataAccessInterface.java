package data_access;

import entity.TransactionEntry;

public interface DatabaseTransactionEntryDataAccessInterface {
//    public TransactionEntry getTransactionEntry(int id);
    public boolean createTransactionEntry(TransactionEntry transactionEntry);
    public int createTransactionID();
}
