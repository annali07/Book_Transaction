package use_case.login;

public interface LoginOutputDataBoundary {
    void prepareSuccessView(LoginOutputData user);
    void prepareFailView(String error);
}
