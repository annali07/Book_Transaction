package use_case.purchase_book;

import com.google.gson.JsonObject;
import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.database_transaction_entry.DatabaseTransactionEntryDataAccessInterface;
import entity.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data_access.add_book_repository.BookRepositoryDataAccessObject;
import data_access.database_transaction_entry.DataTransactionEntryDataAccessObject;
import entity.purchase_entry.TransactionEntry;
import use_case.purchase_book.PurchaseOutputDataBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

class PurchaseInteractorTest {

    private BookRepositoryDataAccessObject bookRepositoryDataAccessObject;
    private DataTransactionEntryDataAccessObject databaseTransactionEntryDataAccessObject;
    private PurchaseOutputDataBoundary presenter;
    private PurchaseInteractor purchaseInteractor;

    private int CANCELLED = 0;
    private int SUCCESS = 1;
    private int FAILED = 2;


    @BeforeEach
    void setUp() {
        this.bookRepositoryDataAccessObject = new BookRepositoryDataAccessObject();
        this.databaseTransactionEntryDataAccessObject = new DataTransactionEntryDataAccessObject();

        this.presenter = new PurchaseOutputDataBoundary() {
            @Override

            public int prepareCancelView() {
                System.out.println("prepareCancelView");
                return CANCELLED;
            }

            @Override
            public int prepareFailView() {
                System.out.println("prepareFailView");
                return FAILED;
            }

            @Override
            public int prepareSuccessView() {
                System.out.println("prepareSuccessView");
                return SUCCESS;
            }
        };
        this.purchaseInteractor = new PurchaseInteractor(this.bookRepositoryDataAccessObject, this.databaseTransactionEntryDataAccessObject, this.presenter);
    }

    @AfterEach
    void tearDown() {
    }

    // Test purchase Successfully case
    @Test
    void testPurchaseSuccess() {
        PurchaseInputData input = new PurchaseInputData() {
            @Override
            public int getBookId() {
                return 1;
            }
        };

        // Assume a mock book in the repository
        Book mockBook = new Book("A Game of Thrones", 99.0);
        bookRepositoryDataAccessObject.saveBook(mockBook);

        // purchase the book, implement the method
        purchaseInteractor.purchase(input);


        // Test that the transaction entry was created in the database
        TransactionEntry transaction = databaseTransactionEntryDataAccessObject.getTransactionEntry(1);
        assertEquals(1, transaction.getBookId());
        assertEquals("A Game of Thrones", transaction.getBookName());
        assertEquals(99.0, transaction.getSoldPrice(), 0.01);

        // Test the success status
        assertEquals(1, presenter.prepareSuccessView());



    }

    // Helper method to create a mock JsonObject representing a book
    private JsonObject createMockBookJsonObject(int bookID, String bookName, double bookPrice) {
        JsonObject book = new JsonObject();
        book.addProperty("bookID", bookID);
        book.addProperty("bookName", bookName);
        book.addProperty("bookPrice", bookPrice);
        return book;
    }

    // Test purchase failure situation
    @Test
    void testFoundNoBookId(){
        PurchaseInputData input = new PurchaseInputData() {
            @Override
            public int getBookId() {
                return 114514;
            }
        };

        // purchase the book, implement the method
        purchaseInteractor.purchase(input);

        assertEquals(2, presenter.prepareFailView());

    }

    @Test
    void testNoneInStock() {
        PurchaseInputData input = new PurchaseInputData() {
            @Override
            public int getBookId() {
                return 1;
            }
        };

        purchaseInteractor.purchase(input);

        assertEquals(2, presenter.prepareFailView());
    }

    void testCancel(){
        PurchaseInputData input = new PurchaseInputData() {
            @Override
            public int getBookId() {
                return 1;
            }
        };

        purchaseInteractor.cancel();

        assertEquals(0, presenter.prepareCancelView());
    }


}
