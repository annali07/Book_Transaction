package entity.purchase_entry;

import entity.rent_entry.CommonRentalEntry;

import java.util.Date;

public interface TransactionEntryFactory {

    public CommonTransactionEntry createCommonTransactionEntry(int bookId, String bookName, double soldPrice, Date date);

    public CommonTransactionEntry createCommonTransactionEntry(int transactionId, int bookId, String bookName, double soldPrice, Date date);
}
