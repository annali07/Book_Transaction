package data_access;

public interface UserLoginDataAccessInterface {
    boolean validateUserLogin(String username, String password);
}
