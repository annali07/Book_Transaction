package interface_adapter.login;

import use_case.LoginInputData;
import use_case.LoginInputDataBoundary;
import use_case.LoginInteractor;

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
