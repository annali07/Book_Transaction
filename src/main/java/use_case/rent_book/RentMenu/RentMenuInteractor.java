package use_case.rent_book.RentMenu;

import Temprorary.TemproraryInfo;
import data_access.database_rental_entry.DatabaseRentalEntryDataAccessInterface;


public class RentMenuInteractor implements RentMenuInputBoundary{
    private final DatabaseRentalEntryDataAccessInterface userGateway;
    private final RentMenuOutputBoundary presenter;

    public RentMenuInteractor(DatabaseRentalEntryDataAccessInterface userGateway, RentMenuOutputBoundary presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

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
    public void cancel(){
        presenter.prepareCancelView();
    }
}
