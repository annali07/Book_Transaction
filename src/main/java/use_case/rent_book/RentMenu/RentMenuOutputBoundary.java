package use_case.rent_book.RentMenu;

import use_case.login.LoginOutputData;

public interface RentMenuOutputBoundary {
    void prepareSuccessView(RentMenuOutputData rentMenuOutputData);
    void prepareFailView(String error);
    void prepareCancelView();
}
