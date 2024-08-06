package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.view.ViewManagerModel;
import use_case.login.LoginOutputData;
import static org.junit.jupiter.api.Assertions.*;

class LoginPresenterTest {

    private LoginPresenter loginPresenter;
    private TestViewManagerModel viewManagerModel;
    private TestLoginViewModel loginViewModel;
    private TestMainMenuViewModel mainMenuViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = new TestViewManagerModel();
        loginViewModel = new TestLoginViewModel();
        mainMenuViewModel = new TestMainMenuViewModel();
        loginPresenter = new LoginPresenter(viewManagerModel, loginViewModel, mainMenuViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        LoginOutputData response = new LoginOutputData("none", false);
        loginPresenter.prepareSuccessView(response);

        assertEquals("none", mainMenuViewModel.getState().getActiveButton());
        assertEquals(mainMenuViewModel.getViewName(), viewManagerModel.getActiveView());
        assertTrue(mainMenuViewModel.propertyChangedFired);
        assertTrue(viewManagerModel.propertyChangedFired);
    }

    @Test
    void testPrepareFailView() {
        String errorMessage = "Invalid password";
        loginPresenter.prepareFailView(errorMessage);

        assertEquals(errorMessage, loginViewModel.getState().getPasswordError());
        assertTrue(loginViewModel.propertyChangedFired);
    }

    // Test classes for ViewManagerModel, LoginViewModel, MainMenuViewModel, LoginState, and MainMenuState

    private static class TestViewManagerModel extends ViewManagerModel {
        private String activeView;
        boolean propertyChangedFired = false;

        @Override
        public void setActiveView(String viewName) {
            this.activeView = viewName;
        }

        @Override
        public String getActiveView() {
            return activeView;
        }

        @Override
        public void firePropertyChanged() {
            propertyChangedFired = true;
        }
    }

    private static class TestLoginViewModel extends LoginViewModel {
        private final TestLoginState state = new TestLoginState();
        boolean propertyChangedFired = false;

        @Override
        public TestLoginState getState() {
            return state;
        }

        @Override
        public void firePropertyChanged() {
            propertyChangedFired = true;
        }
    }

    private static class TestMainMenuViewModel extends MainMenuViewModel {
        private final TestMainMenuState state = new TestMainMenuState();
        boolean propertyChangedFired = false;

        @Override
        public TestMainMenuState getState() {
            return state;
        }

        @Override
        public void firePropertyChanged() {
            propertyChangedFired = true;
        }
    }

    private static class TestLoginState extends LoginState {
        private String passwordError;

        @Override
        public String getPasswordError() {
            return passwordError;
        }

        @Override
        public void setPasswordError(String passwordError) {
            this.passwordError = passwordError;
        }
    }

    private static class TestMainMenuState extends MainMenuState {
        private String activeButton;

        public String getActiveButton() {
            return activeButton;
        }

        @Override
        public void setActiveButton(String activeButton) {
            this.activeButton = activeButton;
        }
    }
}
