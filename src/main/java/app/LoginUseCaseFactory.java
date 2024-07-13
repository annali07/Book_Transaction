package app;

import data_access.UserLoginDataAccess;
import data_access.UserLoginDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_menu.MainMenuViewModel;
import use_case.LoginInputDataBoundary;
import use_case.LoginInteractor;
import use_case.LoginOutputDataBoundary;
import view.LoginView;

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

        // Notice how we pass this method's parameters to the Presenter.
        LoginOutputDataBoundary loginOutputDataBoundary = new LoginPresenter(viewManagerModel,loginViewModel, mainMenuViewModel);

        LoginInputDataBoundary userLoginInteractor = new LoginInteractor(
                userGateway, loginOutputDataBoundary);

        return new LoginController(userLoginInteractor);
    }
}
