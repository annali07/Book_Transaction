package data_access.login_validation;

public interface UserLoginDataAccessInterface {
    boolean validateUserLogin(String username, String password);
}
