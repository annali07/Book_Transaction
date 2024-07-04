package use_case;

import data_access.UserLoginDataAccessInterface;
import interface_adapter.LoginPresenter;

public class LoginUseCase{
    private UserLoginDataAccessInterface userGateway;
    private LoginPresenter presenter;

    public LoginUseCase(UserLoginDataAccessInterface userGateway, LoginPresenter presenter) {
        this.userGateway = userGateway;
        this.presenter = presenter;
    }

    public void login(String username, String password) {
        if (userGateway.validateUserLogin(username, password)) {
            LoginOutputData response = new LoginOutputData(username, false);
            presenter.prepareSuccessView(response);
        } else {
            presenter.prepareFailView("Invalid credentials");
        }
    }
}
