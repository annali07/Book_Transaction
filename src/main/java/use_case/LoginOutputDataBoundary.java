package use_case;

public interface LoginOutputDataBoundary {
    void prepareSuccessView(LoginOutputData user);
    void prepareFailView(String error);
}
