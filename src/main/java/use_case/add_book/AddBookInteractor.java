package use_case.add_book;

import interface_adapter.add_book.AddBookPresenter;

/**
 * Use case class for adding a book.
 * This class contains the business logic for adding a book and
 * interacts with the presenter to update the view.
 */
public class AddBookInteractor {
    private final AddBookPresenter presenter;

    /**
     * Constructs an AddBookUseCase with the specified presenter.
     *
     * @param presenter the presenter used to update the view
     */
    public AddBookInteractor(AddBookPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Adds a book and prepares the success view.
     * This method contains the logic for adding a book and interacts with the
     * presenter to prepare the success view.
     */
    public void addBook() {
        presenter.prepareSuccessView();
    }
}
