package use_case.login;

/**
 * Interface representing the input boundary for the use case of logging in.
 */
public interface LoginInputDataBoundary {
    /**
     * Executes the login process using the provided input data.
     *
     * @param loginInputData The input data containing the username and password for the login attempt.
     */
    void execute(LoginInputData loginInputData);
}
