package use_case;


import data_access.DataTransactionEntryDataAccessObject;
import data_access.DatabaseBookDataAccessInterface;
import data_access.DatabaseBookDataAccessObject;
import entity.Book;
import entity.TransactionEntry;
import entity.TransactionEntryFactory;
import interface_adapter.PurchasePresenter;

import java.util.Date;

public class PurchaseUseCase implements PurchaseInputDataBoundary{

    private PurchasePresenter presenter;

    public PurchaseUseCase(PurchasePresenter presenter) {
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
