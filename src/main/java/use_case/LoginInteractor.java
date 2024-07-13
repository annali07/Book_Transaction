package use_case;

import data_access.UserLoginDataAccessInterface;
import interface_adapter.login.LoginPresenter;

public class LoginInteractor implements LoginInputDataBoundary{
    private UserLoginDataAccessInterface userGateway;
    private LoginOutputDataBoundary presenter;

    public LoginInteractor(UserLoginDataAccessInterface userGateway, LoginOutputDataBoundary loginOutputDataBoundary) {
        this.userGateway = userGateway;
        this.presenter = loginOutputDataBoundary;
    }

    public void execute(LoginInputData loginInputData) {
        if (userGateway.validateUserLogin(loginInputData.getUsername(), loginInputData.getPassword())) {
            LoginOutputData response = new LoginOutputData(loginInputData.getUsername(), false);
            presenter.prepareSuccessView(response);
        } else {
            presenter.prepareFailView("Invalid credentials");
        }
    }
}
