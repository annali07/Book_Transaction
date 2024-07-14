package use_case.login;

import data_access.login_validation.UserLoginDataAccessInterface;

/**
 * The interactor class that implements the login use case.
 */
public class LoginInteractor implements LoginInputDataBoundary {
    /**
     * The user gateway for accessing and validating user login data.
     */
    private final UserLoginDataAccessInterface userGateway;

    /**
     * The presenter to prepare the output data for the view.
     */
    private final LoginOutputDataBoundary presenter;

    /**
     * Constructs a LoginInteractor instance with the specified user gateway and presenter.
     *
     * @param userGateway             The user gateway for accessing and validating user login data.
     * @param loginOutputDataBoundary The presenter to prepare the output data for the view.
     */
    public LoginInteractor(UserLoginDataAccessInterface userGateway, LoginOutputDataBoundary loginOutputDataBoundary) {
        this.userGateway = userGateway;
        this.presenter = loginOutputDataBoundary;
    }

    /**
     * Executes the login process using the provided input data.
     *
     * @param loginInputData The input data containing the username and password for the login attempt.
     */
    public void execute(LoginInputData loginInputData) {
        if (userGateway.validateUserLogin(loginInputData.getUsername(), loginInputData.getPassword())) {
            LoginOutputData response = new LoginOutputData(loginInputData.getUsername(), false);
            presenter.prepareSuccessView(response);
        } else {
            presenter.prepareFailView("Invalid credentials");
        }
    }
}
