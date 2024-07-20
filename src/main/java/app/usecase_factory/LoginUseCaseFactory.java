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

/**
 * Factory class for creating instances related to the Login use case.
 */
public class LoginUseCaseFactory {
    private LoginUseCaseFactory(){}

    /**
     * Creates an instance of LoginView.
     *
     * @param viewManagerModel the model managing views
     * @param loginViewModel the view model for login
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of LoginView, or null if an IOException occurs
     */
    public static LoginView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainMenuViewModel mainMenuViewModel) {
        try {
            LoginController loginController = createUserLoginUseCase(viewManagerModel, loginViewModel, mainMenuViewModel);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;
    }

    /**
     * Creates an instance of LoginController.
     *
     * @param viewManagerModel the model managing views
     * @param loginViewModel the view model for login
     * @param mainMenuViewModel the view model for the main menu
     * @return an instance of LoginController
     * @throws IOException if an error occurs while creating the data access objects
     */
    private static LoginController createUserLoginUseCase(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, MainMenuViewModel mainMenuViewModel) throws IOException {
        UserLoginDataAccessInterface userGateway = new UserLoginDataAccess();

        LoginOutputDataBoundary loginOutputDataBoundary = new LoginPresenter(viewManagerModel,loginViewModel, mainMenuViewModel);

        LoginInputDataBoundary userLoginInteractor = new LoginInteractor(
                userGateway, loginOutputDataBoundary);

        return new LoginController(userLoginInteractor);
    }
}
