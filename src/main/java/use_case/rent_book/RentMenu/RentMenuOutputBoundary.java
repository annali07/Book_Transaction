package use_case.rent_book.RentMenu;

import use_case.login.LoginOutputData;

/**
 * Interface representing the output boundary for the search book use case.
 */
public interface RentMenuOutputBoundary {

    /**
     * Prepares the success view with the provided user data.
     *
     * @param rentMenuOutputData The output data containing the book information after a successful login.
     */
    void prepareSuccessView(RentMenuOutputData rentMenuOutputData);

    /**
     * Prepares the failure view with the provided error message.
     *
     * @param error The error message indicating why the search book attempt failed.
     */
    void prepareFailView(String error);

    /**
     * Prepare the cancel view
     *
     */
    void prepareCancelView();
}
