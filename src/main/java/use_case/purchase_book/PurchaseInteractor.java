package use_case.purchase_book;

import com.google.gson.JsonObject;
import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;
import entity.book.Book;
import entity.purchase_entry.TransactionEntry;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * The PurchaseInteractor class handles the business logic for purchasing a book.
 * It interacts with the book repository and transaction entry database to process the purchase.
 *
 */
public class PurchaseInteractor implements PurchaseInputDataBoundary{

    private final BookRepositoryDataAccessInterface bookRepositoryDataAccessObject;
    private final DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessObject;
    private final PurchaseOutputDataBoundary presenter;

    /**
     * Constructs a PurchaseInteractor object with the specified book repository, transaction entry database, and presenter.
     *
     * @param bookRepositoryDataAccessObject the book repository data access object
     * @param databaseTransactionEntryDataAccessObject the transaction entry database data access object
     * @param presenter the purchase output data boundary presenter
     */
    public PurchaseInteractor(BookRepositoryDataAccessInterface bookRepositoryDataAccessObject, DatabaseTransactionEntryDataAccessInterface databaseTransactionEntryDataAccessObject, PurchaseOutputDataBoundary presenter) {
        this.presenter = presenter;
        this.bookRepositoryDataAccessObject = bookRepositoryDataAccessObject;
        this.databaseTransactionEntryDataAccessObject = databaseTransactionEntryDataAccessObject;
    }


    /**
     * Processes a purchase request by checking if the book exists in the repository,
     * creating a transaction entry, and deleting the book from the repository if the purchase is successful.
     *
     * @param purchaseInputData the input data containing the book ID to be purchased
     */
    @Override
     public void purchase(PurchaseInputData purchaseInputData){
        System.out.println("The bookID of the book to purchase is: " + purchaseInputData.getBookId());
        boolean isFound  = bookRepositoryDataAccessObject.findBook(purchaseInputData.getBookId());
        if(isFound){
            Book book = bookRepositoryDataAccessObject.getBook(purchaseInputData.getBookId());

            int bookID = book.getBookID();
            double bookPrice = book.getBookPrice();
            String bookName = book.getBookName();
            LocalDate localDate = LocalDate.now();
            Date today = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            TransactionEntry transaction = new TransactionEntry(bookID, bookName, bookPrice, today);

            boolean db = databaseTransactionEntryDataAccessObject.createTransactionEntry(transaction);
            boolean del = bookRepositoryDataAccessObject.deleteBook(bookID);
            if (db && del) {
                System.out.println("The book is purchased and deleted from db.");
                presenter.prepareSuccessView();
            }
        }
        else{
            System.out.println("The book of book id " + purchaseInputData.getBookId() + " is not found.");
            presenter.prepareFailView();
        }
     }


    /**
     * Cancels the purchase process and invokes the presenter's cancel view.
     */
    @Override
    public void cancel() {
        presenter.prepareCancelView();
    }
}
