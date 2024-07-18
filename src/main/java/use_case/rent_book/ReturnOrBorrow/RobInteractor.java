package use_case.rent_book.ReturnOrBorrow;

import use_case.rent_book.RentMenu.RentMenuOutputBoundary;

/**
 * The RobInteractor class handles the business logic for deciding between returning or borrowing a book.
 * It interacts with the presenter to prepare views based on the user's action.
 *
 */
public class RobInteractor{
    private final RobOutputBoundary presenter;

    /**
     * Constructs a RobInteractor object with the specified presenter.
     *
     * @param presenter the presenter for preparing views
     */
    public RobInteractor(RobOutputBoundary presenter){this.presenter = presenter;}

    /**
     * Cancels the operation and invokes the presenter's cancel view.
     */
    public void cancel(){presenter.prepareCancelView();}

    /**
     * Initiates the return book operation and invokes the presenter's return book view.
     */
    public void returnBook(){presenter.returnBook();}

    /**
     * Initiates the borrow book operation and invokes the presenter's borrow book view.
     */
    public void borrowBook(){presenter.borrowBook();}
}
