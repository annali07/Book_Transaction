package use_case.add_book;

import data_access.add_book_repository.BookRepositoryDataAccessInterface;
import data_access.api.ExternalBookApiInterface;
import entity.api.ApiResponse;
import entity.book.Book;

/**
 * Use case class for adding a book.
 * This class contains the business logic for adding a book and
 * interacts with the presenter to update the view.
 */
public class AddBookInteractor implements AddBookInputBoundary{

    private final BookRepositoryDataAccessInterface bookRepositoryDataAccessObject;
    private final ExternalBookApiInterface externalBookApi;
    private final AddBookOutputBoundary presenter;

    /**
     * Constructs a new AddBookInteractor with the specified data access object, external API interface, and presenter.
     *
     * @param bookRepositoryDataAccessObject the data access object for book repository
     * @param externalBookAPI the interface for external book API
     * @param presenter the presenter to update the view
     */
    public AddBookInteractor(BookRepositoryDataAccessInterface bookRepositoryDataAccessObject, ExternalBookApiInterface externalBookAPI, AddBookOutputBoundary presenter) {
        this.bookRepositoryDataAccessObject = bookRepositoryDataAccessObject;
        this.externalBookApi = externalBookAPI;
        this.presenter = presenter;
    }

    /**
     * Adds a book based on the provided input data.
     * Fetches book details from an external API and stores the book in the database.
     * Notifies the presenter about the success or failure of the operation.
     *
     * @param addBookInputData the input data for adding a book
     */
    @Override
    public void addBook(AddBookInputData addBookInputData) {

        ApiResponse apiResponse = externalBookApi.fetchBookDetails(addBookInputData.getIsbn());
        Book book = new Book(apiResponse.getBookName(), addBookInputData.getPrice());

        boolean result = bookRepositoryDataAccessObject.saveBook(book);
        if (!result){
            presenter.prepareFailView("Failed to save to DB");
        }

        System.out.println("Saved to DB\n");
        presenter.prepareSuccessView();
    }

    /**
     * Cancels the current add book operation.
     * Notifies the presenter to update the view accordingly.
     */
    @Override
    public void cancel(){
        presenter.prepareCancelView();
    }
}
