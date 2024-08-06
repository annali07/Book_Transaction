package use_case.login;

/**
 * Represents the input data required for a login attempt, specifically the username and password.
 */
public class LoginInputData {
    /**
     * The username for the login attempt.
     */
    final private String username;

    /**
     * The password for the login attempt.
     */
    final private String password;

    /**
     * Constructs a LoginInputData instance with the specified username and password.
     *
     * @param username The username for the login attempt.
     * @param password The password for the login attempt.
     */
    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username for the login attempt.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password for the login attempt.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }
}
