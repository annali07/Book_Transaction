package interface_adapter.RentMenu;

import use_case.login.LoginInputData;
import use_case.rent_book.RentMenu.RentMenuInputBoundary;
import use_case.rent_book.RentMenu.RentMenuInputData;

public class RentMenuController {
    final RentMenuInputBoundary rentMenuInputInteractor;

    public RentMenuController(RentMenuInputBoundary rentMenuInputBoundary) {
        this.rentMenuInputInteractor = rentMenuInputBoundary;
    }

    public boolean execute(int bookID) {
        RentMenuInputData rentMenuInputData = new RentMenuInputData(bookID);
        boolean indicator = rentMenuInputInteractor.execute(rentMenuInputData);
        return indicator;
    }

    public void cancel() {
        rentMenuInputInteractor.cancel();
    }
}
