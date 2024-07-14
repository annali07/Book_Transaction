package data_access.login_validation;

/**
 * Interface for validating user login credentials.
 */
public interface UserLoginDataAccessInterface {
    /**
     * Validates the user login by checking the provided username and password against stored user data.
     *
     * @param username the username to validate
     * @param password the password to validate
     * @return true if the username and password match a stored user, false otherwise
     */
    boolean validateUserLogin(String username, String password);
}
