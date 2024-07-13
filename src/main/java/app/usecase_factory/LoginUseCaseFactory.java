package app.usecase_factory;

import data_access.login_validation.UserLoginDataAccess;
import data_access.login_validation.UserLoginDataAccessInterface;
import interface_adapter.view.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.login.LoginInputDataBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputDataBoundary;
import view.views.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {
    private LoginUseCaseFactory(){}

    public static LoginView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainMenuViewModel mainMenuViewModel) {
        try {
            LoginController loginController = createUserLoginUseCase(viewManagerModel, loginViewModel, mainMenuViewModel);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;
    }
    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainMenuViewModel mainMenuViewModel) throws IOException {
        UserLoginDataAccessInterface userGateway = new UserLoginDataAccess();

        LoginOutputDataBoundary loginOutputDataBoundary = new LoginPresenter(viewManagerModel,loginViewModel, mainMenuViewModel);

        LoginInputDataBoundary userLoginInteractor = new LoginInteractor(
                userGateway, loginOutputDataBoundary);

        return new LoginController(userLoginInteractor);
    }
}
