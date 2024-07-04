package entity;

import java.util.Date;

public class TransactionEntryFactory {
    public static TransactionEntry createTransactionEntry(int transactionId, int bookId, String bookName, double soldPrice, Date date){
        if (!validate(bookId, soldPrice, transactionId)){
            throw new IllegalArgumentException("Invalid arguments for creating RentalHistory");
        }
        return new TransactionEntry(transactionId, bookId, bookName, soldPrice, date);
    }

    public static boolean validate(int bookId, double soldPrice, int transactionId) {
        return bookId > 0 && soldPrice >= 0 && transactionId > 0;
    }

}
