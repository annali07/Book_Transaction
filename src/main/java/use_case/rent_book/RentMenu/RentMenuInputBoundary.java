package use_case.rent_book.RentMenu;

import use_case.login.LoginInputData;

/**
 * Interface representing the input boundary for the use case of rent menu.
 */
public interface RentMenuInputBoundary {

    /**
     * Executes the search book operation using the provided input data.
     *
     * @param rentMenuInputData The input data containing the bookID for searching the book.
     */
    public boolean execute(RentMenuInputData rentMenuInputData);

    /**
     * cancel the operation
     */
    public void cancel();

}
