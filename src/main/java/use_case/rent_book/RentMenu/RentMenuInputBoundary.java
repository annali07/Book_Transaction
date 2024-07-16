package use_case.rent_book.RentMenu;

import use_case.login.LoginInputData;

public interface RentMenuInputBoundary {
    public boolean execute(RentMenuInputData rentMenuInputData);
    public void cancel();

}
