package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

public class LoginViewModelTest {

    private LoginViewModel loginViewModel;

    @BeforeEach
    void setUp() {
        loginViewModel = new LoginViewModel();
    }

    @Test
    void testInitialValues() {
        assertEquals("Login Screen", loginViewModel.TITLE_LABEL);
        assertEquals("Enter username", loginViewModel.USERNAME_LABEL);
        assertEquals("Enter password", loginViewModel.PASSWORD_LABEL);
        assertEquals("Log in", loginViewModel.LOGIN_BUTTON_LABEL);
        assertEquals("Cancel", loginViewModel.CANCEL_BUTTON_LABEL);
        assertEquals("log in", loginViewModel.getViewName());
        assertNotNull(loginViewModel.getState());
    }

    @Test
    void testSetState() {
        LoginState newState = new LoginState();
        newState.setUsername("newUser");
        loginViewModel.setState(newState);
        assertEquals(newState, loginViewModel.getState());
    }

    @Test
    void testFirePropertyChanged() {
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        loginViewModel.addPropertyChangeListener(listener);

        LoginState newState = new LoginState();
        newState.setUsername("newUser");
        loginViewModel.setState(newState);
        loginViewModel.firePropertyChanged();

        assertTrue(listener.propertyChangeCalled);
        assertEquals("state", listener.event.getPropertyName());
        assertEquals(newState, listener.event.getNewValue());
    }

    private static class TestPropertyChangeListener implements PropertyChangeListener {
        boolean propertyChangeCalled = false;
        PropertyChangeEvent event;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeCalled = true;
            event = evt;
        }
    }
}
