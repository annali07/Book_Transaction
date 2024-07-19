package use_case.rent_book.ReturnOrBorrow;

import use_case.rent_book.RentMenu.RentMenuOutputData;

/**
 * Interface representing the output boundary for the return or borrow use case.
 */
public interface RobOutputBoundary {

    /**
     * return book operation
     */
    void returnBook();

    /**
     * borrow book operation
     */
    void borrowBook();

    /**
     * Prepare cancel view
     */
    void prepareCancelView();
}
