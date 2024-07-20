package use_case.login;

/**
 * Represents the output data for a login attempt, including the username and the status of the login attempt.
 */
public class LoginOutputData {
    /**
     * Indicates whether the login attempt failed.
     */
    public boolean loginFailed;

    /**
     * The username of the user attempting to log in.
     */
    private final String username;

    /**
     * Constructs a LoginOutputData instance with the specified username and login status.
     *
     * @param username    The username of the user attempting to log in.
     * @param loginFailed Indicates whether the login attempt failed.
     */
    public LoginOutputData(String username, boolean loginFailed) {
        this.username = username;
        this.loginFailed = loginFailed;
    }

    /**
     * Returns the username of the user attempting to log in.
     *
     * @return The username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the success status of the login attempt.
     *
     * @param success The success status to set.
     */
    public void setSuccess(boolean success) {
        this.loginFailed = success;
    }

    /**
     * Returns the default active button status.
     *
     * @return The default active button status.
     */
    public String defaultButton() {
        /**
         * The active button status, default is "none".
         */
        return "none";
    }
}
