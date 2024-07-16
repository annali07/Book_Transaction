package use_case.purchase_book;

import com.google.gson.JsonObject;
import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;
import entity.purchase_entry.TransactionEntry;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class PurchaseInteractor implements PurchaseInputDataBoundary{

    private final BookRepositoryDataAccessInterface bookRepositoryDataAccessObject;
    private final DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessObject;
    private final PurchaseOutputDataBoundary presenter;

    public PurchaseInteractor(BookRepositoryDataAccessInterface bookRepositoryDataAccessObject, DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessObject, PurchaseOutputDataBoundary presenter) {
        this.presenter = presenter;
        this.bookRepositoryDataAccessObject = bookRepositoryDataAccessObject;
        this.databaseTransactionEntryDataAccessObject = databaseTransactionEntryDataAccessObject;
    }

    @Override
     public void purchase(PurchaseInputData purchaseInputData){

        JsonObject foundObject = bookRepositoryDataAccessObject.getBook(purchaseInputData.getBookId());

        if(foundObject != null){
            int bookID = foundObject.get("bookID").getAsInt();
            double bookPrice = foundObject.get("bookPrice").getAsDouble();
            String bookName = foundObject.get("bookName").getAsString();
            LocalDate localDate = LocalDate.now();
            Date today = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            TransactionEntry transaction = new TransactionEntry(bookID, bookName, bookPrice, today);

            boolean db = databaseTransactionEntryDataAccessObject.createTransactionEntry(transaction);
            boolean del = bookRepositoryDataAccessObject.deleteBook(bookID);
            if (db && del) {
                presenter.prepareSuccessView();
            }
        }
        else{
            presenter.prepareFailView();
        }
     }

    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
