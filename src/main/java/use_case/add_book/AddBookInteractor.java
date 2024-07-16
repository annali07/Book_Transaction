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

    public AddBookInteractor(BookRepositoryDataAccessInterface bookRepositoryDataAccessObject, ExternalBookApiInterface externalBookAPI, AddBookOutputBoundary presenter) {
        this.bookRepositoryDataAccessObject = bookRepositoryDataAccessObject;
        this.externalBookApi = externalBookAPI;
        this.presenter = presenter;
    }

    @Override
    public void addBook(AddBookInputData addBookInputData) {
        // Make API call
        ApiResponse apiResponse = externalBookApi.fetchBookDetails(addBookInputData.getIsbn());

        // Process API response
        Book book = new Book(apiResponse.getBookName(), apiResponse.getAuthor(), addBookInputData.getPrice());

        // Store data in the database
        bookRepositoryDataAccessObject.saveBook(book);

        System.out.println("Saved to DB\n");
        // Prepare the response
        presenter.prepareSuccessView();

    }
    public void cancel(){
        presenter.prepareCancelView();
    }
}
