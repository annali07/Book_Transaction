package interface_adapter;

import use_case.LoginOutputDataBoundary;
import use_case.LoginOutputData;

/**
 * The presenter for handling the login output data.
 * This class updates the view models based on the success or failure of the login process.
 */
public class LoginPresenter implements LoginOutputDataBoundary {

    private final LoginViewModel loginViewModel;
    private final MainMenuViewModel mainMenuViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a LoginPresenter with the specified view manager model,
     * login view model, and main menu view model.
     *
     * @param viewManagerModel the view manager model to manage active views
     * @param loginViewModel the login view model to update the login state
     * @param mainMenuViewModel the main menu view model to update the main menu state
     */
    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoginViewModel loginViewModel, MainMenuViewModel mainMenuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }

    /**
     * Prepares the success view upon successful login.
     * Updates the main menu state and switches to the main menu view.
     *
     * @param response the login output data containing the default button to activate
     */
    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the login success view
        LoginState loginState = loginViewModel.getState();
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        mainMenuState.setActiveButton(response.defaultButton());
        this.mainMenuViewModel.setState(mainMenuState);
        mainMenuViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("Login Success");
    }

    /**
     * Prepares the failure view upon unsuccessful login.
     * Updates the login state with an error message.
     *
     * @param error the error message indicating the reason for login failure
     */
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setPasswordError(error);
        loginViewModel.firePropertyChanged();
        System.out.println("Wrong Password");
    }
}
