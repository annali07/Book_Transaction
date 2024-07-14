package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInputDataBoundary;

/**
 * Controller for handling user login functionality.
 * It interacts with the use case interactor to perform the login operation.
 */
public class LoginController {
    final LoginInputDataBoundary userLoginUseCaseInteractor;

    /**
     * Constructs a LoginController with the specified use case interactor.
     *
     * @param userLoginUseCaseInteractor the use case interactor for user login
     */
    public LoginController(LoginInputDataBoundary userLoginUseCaseInteractor) {
        this.userLoginUseCaseInteractor = userLoginUseCaseInteractor;
    }

    /**
     * Executes the login operation with the provided username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public void execute (String username, String password){
        LoginInputData loginInputData = new LoginInputData(
                username, password);
        userLoginUseCaseInteractor.execute(loginInputData);
    }
}
