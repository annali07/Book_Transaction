package use_case.login;

/**
 * Interface representing the output boundary for the login use case.
 */
public interface LoginOutputDataBoundary {
    /**
     * Prepares the success view with the provided user data.
     *
     * @param user The output data containing the user information after a successful login.
     */
    void prepareSuccessView(LoginOutputData user);

    /**
     * Prepares the failure view with the provided error message.
     *
     * @param error The error message indicating why the login attempt failed.
     */
    void prepareFailView(String error);
}
