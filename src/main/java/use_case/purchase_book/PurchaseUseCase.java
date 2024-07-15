package use_case.purchase_book;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.add_book_repository.BookRepositoryDataAccessObject;
import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import data_access.database_book.DatabaseBookDataAccessObject;
import entity.book.Book;
import entity.purchase_entry.TransactionEntry;
import entity.purchase_entry.TransactionEntryFactory;
import interface_adapter.purchase_book.PurchaseBookPresenter;

import java.util.Date;

public class PurchaseUseCase implements PurchaseInputDataBoundary{

    private PurchaseOutputDataBoundary presenter;
    private BookRepositoryDataAccessInterface bookRepositoryDataAccessObject;

    public PurchaseUseCase(PurchaseOutputDataBoundary presenter) {
        this.presenter = presenter;
        this.bookRepositoryDataAccessObject = new BookRepositoryDataAccessObject();
    }
    @Override
     public void purchase(PurchaseInputData pd){

        // Take data from the database
        JsonObject foundObject = bookRepositoryDataAccessObject.getBook(pd.getBookId());
        Gson gson = new Gson();
        Book foundbook = gson.fromJson(foundObject, Book.class);

         if(foundObject != null){
             // Create a new transaction record
             TransactionEntryFactory factory = new TransactionEntryFactory();

             DataTransactionEntryDataAccessObject transactionData = new DataTransactionEntryDataAccessObject();
             TransactionEntry transaction = factory.createTransactionEntry(transactionData.createTransactionID(),foundbook.getBookID(), foundbook.getBookName(), foundbook.getBookPrice(), new Date());

             transactionData.createTransactionEntry(transaction);

             // Present SuccessView
            presenter.prepareSuccessView();


         }
         // Present FailureView
        presenter.prepareCancelView();
     }

    @Override
    public void cancel() {presenter.prepareCancelView();

    }


}
