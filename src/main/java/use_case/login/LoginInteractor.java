package use_case.login;

import data_access.login_validation.UserLoginDataAccessInterface;

public class LoginInteractor implements LoginInputDataBoundary{
    private final UserLoginDataAccessInterface userGateway;
    private final LoginOutputDataBoundary presenter;

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
