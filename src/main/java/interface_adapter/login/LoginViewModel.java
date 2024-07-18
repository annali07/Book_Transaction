package interface_adapter.login;

import interface_adapter.view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The LoginViewModel class represents the view model for the login screen.
 * It manages the state of the login process and provides property change support.
 *
 */
public class LoginViewModel extends ViewModel {

    public final String TITLE_LABEL = "Login Screen";
    public final String USERNAME_LABEL = "Enter username";
    public final String PASSWORD_LABEL = "Enter password";

    public final String LOGIN_BUTTON_LABEL = "Log in";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private LoginState state = new LoginState();

    /**
     * Constructs a LoginViewModel object with the default view name "log in".
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the current state of the login process.
     *
     * @param state the new login state
     */
    public void setState(LoginState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event for the state property.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the login process.
     *
     * @return the current login state
     */
    public LoginState getState() {
        return state;
    }
}