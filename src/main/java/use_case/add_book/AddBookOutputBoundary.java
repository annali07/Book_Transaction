package use_case.add_book;

import use_case.login.LoginOutputData;

public interface AddBookOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
    void prepareCancelView();
}
