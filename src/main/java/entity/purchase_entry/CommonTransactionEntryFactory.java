package entity.purchase_entry;

import entity.rent_entry.CommonRentalEntry;

import java.util.Date;

public class CommonTransactionEntryFactory implements TransactionEntryFactory{
    @Override
    public CommonTransactionEntry createCommonTransactionEntry(int bookId, String bookName, double soldPrice, Date date){
        return new CommonTransactionEntry(bookId, bookName, soldPrice, date);
    }

    @Override
    public CommonTransactionEntry createCommonTransactionEntry(int transactionId, int bookId, String bookName, double soldPrice, Date date){
        return new CommonTransactionEntry(transactionId, bookId, bookName, soldPrice, date);
    }

}
