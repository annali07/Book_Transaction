package use_case.rent_book.ReturnOrBorrow;

import use_case.rent_book.RentMenu.RentMenuOutputBoundary;

/**
 * The interactor class that implements the return or borrow use case.
 */
public class RobInteractor{

    /**
     * The presenter to prepare the output data for the view.
     */
    private final RobOutputBoundary presenter;

    /**
     * Constructs a RobInteractor instance with the specified presenter.
     *
     * @param presenter The presenter to prepare the output data for the view.
     */
    public RobInteractor(RobOutputBoundary presenter){this.presenter = presenter;}

    /**
     * Cancel the operation
     */
    public void cancel(){presenter.prepareCancelView();}

    /**
     * Choose to return the book
     */
    public void returnBook(){presenter.returnBook();}

    /**
     * Choose to borrow the book
     */
    public void borrowBook(){presenter.borrowBook();}
}
