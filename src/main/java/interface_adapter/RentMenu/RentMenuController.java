package interface_adapter.RentMenu;

import use_case.login.LoginInputData;
import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuInputData;

/**
 * Controller for handling rental menu functionality
 * It interacts with the use case interactor to perform the search book operation and cancel the operation.
 *
 */
public class RentMenuController {
    final RentMenuInputBoundary rentMenuInputInteractor;

    /**
     * Constructs an RentMenuController with the specified use case interactor.
     *
     * @param rentMenuInputBoundary the use case interactor for searching a book
     */
    public RentMenuController(RentMenuInputBoundary rentMenuInputBoundary) {
        this.rentMenuInputInteractor = rentMenuInputBoundary;
    }

    /**
     * Executes the search book operation with the provided bookID.
     *
     * @param bookID the bookID of the book to search
     */

    public boolean execute(int bookID) {
        RentMenuInputData rentMenuInputData = new RentMenuInputData(bookID);
        boolean indicator = rentMenuInputInteractor.execute(rentMenuInputData);
        return indicator;
    }

    /**
     * Cancels the add book operation.
     */

    public void cancel() {
        rentMenuInputInteractor.cancel();
    }
}
