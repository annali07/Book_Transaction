package interface_adapter.returnorborrow;

import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuInputData;
import use_case.rent_book.ReturnOrBorrow.RobInteractor;

/**
 * Controller for handling return or borrow book functionality.
 * It interacts with the use case interactor to perform the return or borrow book operation and cancel the operation.
 *
 */
public class ReturnOrBorrowController {
    final RobInteractor robInteractor;

    /**
     * Constructs a robInteractor with the specified use case interactor.
     *
     * @param robInteractor the use case interactor for choice of returning or borrowing a book
     */

    public ReturnOrBorrowController(RobInteractor robInteractor) {
        this.robInteractor = robInteractor;
    }

    /**
     * Choose to return the book
     */

    public void returnBook() {
        this.robInteractor.returnBook();
    }

    /**
     * Cancel the operation
     */

    public void cancel() {
        this.robInteractor.cancel();
    }

    /**
     * Choose to borrow the book
     */

    public void borrowBook(){
        this.robInteractor.borrowBook();
    }

}
