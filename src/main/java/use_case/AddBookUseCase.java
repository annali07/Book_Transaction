package use_case;

import interface_adapter.AddBookPresenter;

/**
 * Use case class for adding a book.
 * This class contains the business logic for adding a book and
 * interacts with the presenter to update the view.
 */
public class AddBookUseCase {
    private final AddBookPresenter presenter;

    /**
     * Constructs an AddBookUseCase with the specified presenter.
     *
     * @param presenter the presenter used to update the view
     */
    public AddBookUseCase(AddBookPresenter presenter) {
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
