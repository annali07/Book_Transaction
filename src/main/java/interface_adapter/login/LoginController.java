package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInputDataBoundary;

public class LoginController {
    final LoginInputDataBoundary userLoginUseCaseInteractor;
    public LoginController(LoginInputDataBoundary userLoginUseCaseInteractor) {
        this.userLoginUseCaseInteractor = userLoginUseCaseInteractor;
    }

    public void execute (String username, String password){
        LoginInputData loginInputData = new LoginInputData(
                username, password);
        userLoginUseCaseInteractor.execute(loginInputData);
    }
}
