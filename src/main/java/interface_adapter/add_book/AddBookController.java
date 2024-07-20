package interface_adapter.add_book;


import use_case.add_book.AddBookInputBoundary;
import use_case.add_book.AddBookInputData;

/**
 * Controller for handling the add book functionality.
 * It interacts with the use case interactor to perform the add book operation and cancel the operation.
 */
public class AddBookController {
    final AddBookInputBoundary addBookUsecaseInteractor;

    /**
     * Constructs an AddBookController with the specified use case interactor.
     *
     * @param addBookUsecaseInteractor the use case interactor for adding a book
     */
    public AddBookController(AddBookInputBoundary addBookUsecaseInteractor) {
        this.addBookUsecaseInteractor = addBookUsecaseInteractor;
    }

    /**
     * Executes the add book operation with the provided ISBN and price.
     *
     * @param isbn the ISBN of the book to add
     * @param price the price of the book to add
     */
    public void execute (String isbn, double price){
        AddBookInputData addBookInputData = new AddBookInputData(isbn, price);
        addBookUsecaseInteractor.addBook(addBookInputData);
    }

    /**
     * Cancels the add book operation.
     */
    public void cancel(){
        addBookUsecaseInteractor.cancel();
    }
}
