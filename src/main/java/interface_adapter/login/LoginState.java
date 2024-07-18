package interface_adapter.login;

/**
 * The LoginState class represents the state of the login process.
 * It includes the username, password, and any associated error messages.
 *
 */
public class LoginState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Constructs a new LoginState object by copying another LoginState object.
     *
     * @param copy the LoginState object to copy
     */

    public LoginState(LoginState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    /**
     * Constructs a new LoginState object with default values.
     */
    public LoginState() {}

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the username error message.
     *
     * @return the username error message
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the password error message.
     *
     * @return the password error message
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the username.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the username error message.
     *
     * @param usernameError the username error message to set
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Sets the password error message.
     *
     * @param passwordError the password error message to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}