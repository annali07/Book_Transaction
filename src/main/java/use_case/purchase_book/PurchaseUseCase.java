package use_case.purchase_book;


import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import data_access.database_book.DatabaseBookDataAccessObject;
import entity.book.Book;
import entity.purchase_entry.TransactionEntry;
import entity.purchase_entry.TransactionEntryFactory;
import interface_adapter.purchase_book.PurcahseBookPresenter;

import java.util.Date;

public class PurchaseUseCase implements PurchaseInputDataBoundary{

    private PurcahseBookPresenter presenter;

    public PurchaseUseCase(PurcahseBookPresenter presenter) {
        this.presenter = presenter;
    }

     public void purchase(PurchaseInputData pd){

         DatabaseBookDataAccessObject db = new DatabaseBookDataAccessObject();
         Book foundObject = db.getBook(pd.getBookId());

         if(foundObject != null){
             // Create a new transaction record
             TransactionEntryFactory factory = new TransactionEntryFactory();


             DataTransactionEntryDataAccessObject transactionData = new DataTransactionEntryDataAccessObject();
             TransactionEntry transaction = factory.createTransactionEntry(transactionData.createTransactionID(),foundObject.getBookID(), foundObject.getBookName(), foundObject.getBookPrice(), new Date());


             transactionData.createTransactionEntry(transaction);

             // Present SuccessView



         }
         // Present FailureView
     }
}
