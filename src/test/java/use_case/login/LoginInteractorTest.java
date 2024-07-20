//package use_case.login;
//
//import data_access.login_validation.UserLoginDataAccessInterface;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class LoginInteractorTest {
//
//    private UserLoginDataAccessInterface userGateway;
//    private LoginOutputDataBoundary presenter;
//    private LoginInteractor loginInteractor;
//
//    @BeforeEach
//    void setUp() {
//        userGateway = mock(UserLoginDataAccessInterface.class);
//        presenter = mock(LoginOutputDataBoundary.class);
//
//        loginInteractor = new LoginInteractor(userGateway, presenter);
//    }
//
//    @Test
//    void executeSuccess() {
//        String username = "anna";
//        String password = "123";
//        LoginInputData loginInputData = new LoginInputData(username, password);
//
//        when(userGateway.validateUserLogin(username, password)).thenReturn(true);
//
//        loginInteractor.execute(loginInputData);
//
//        ArgumentCaptor<LoginOutputData> captor = ArgumentCaptor.forClass(LoginOutputData.class);
//        verify(presenter).prepareSuccessView(captor.capture());
//
//        LoginOutputData capturedResponse = captor.getValue();
//        assertEquals(username, capturedResponse.getUsername());
//
//        verify(presenter, never()).prepareFailView(anyString());
//    }
//
//    @Test
//    void executeFailure() {
//        String username = "invalidUser";
//        String password = "invalidPass";
//        LoginInputData loginInputData = new LoginInputData(username, password);
//
//        when(userGateway.validateUserLogin(username, password)).thenReturn(false);
//
//        loginInteractor.execute(loginInputData);
//
//        verify(presenter).prepareFailView("Invalid credentials");
//        verify(presenter, never()).prepareSuccessView(any(LoginOutputData.class));
//    }
//}
