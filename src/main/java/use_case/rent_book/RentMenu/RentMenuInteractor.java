package use_case.rent_book.RentMenu;

import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;

/**
 * The RentMenuInteractor class handles the business logic for the rent menu.
 * It interacts with the database to validate books and prepares views through the presenter.
 *
 */
public class RentMenuInteractor implements RentMenuInputBoundary{

    /**
     * The user gateway for accessing relevant book information.
     */
    private final DatabaseRentalEntryDataAccessInterface userGateway;

    /**
     * The presenter to prepare the output data for the view.
     */
    private final RentMenuOutputBoundary presenter;

    /**
     * Constructs a RentMenuInteractor object with the specified database gateway and presenter.
     *
     * @param userGateway the database gateway for validating books
     * @param presenter the presenter for preparing views
     */
    public RentMenuInteractor(DatabaseRentalEntryDataAccessInterface userGateway, RentMenuOutputBoundary presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    /**
     * Executes the rent menu operation by validating the book ID.
     * If the book is valid, it prepares a success view, otherwise, it prepares a fail view.
     *
     * @param rentMenuInputData the input data containing the book ID to be validated
     * @return true if the book is valid, false otherwise
     */
    @Override
    public boolean execute(RentMenuInputData rentMenuInputData) {
        if (userGateway.validatebook(rentMenuInputData.getBookID())) {
            RentMenuOutputData response = new RentMenuOutputData(rentMenuInputData.getBookID(), false);
            presenter.prepareSuccessView(response);
            return true;
        } else {
            presenter.prepareFailView("cannot find the book");
            return false;
        }

    }

    /**
     * Cancels the rent menu operation and invokes the presenter's cancel view.
     */
    public void cancel(){
        presenter.prepareCancelView();
    }
}
