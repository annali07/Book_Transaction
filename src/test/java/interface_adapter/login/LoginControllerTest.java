package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginInputData;
import use_case.login.LoginInputDataBoundary;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginControllerTest {

    private LoginController loginController;
    private TestLoginInputDataBoundary testBoundary;

    @BeforeEach
    void setUp() {
        testBoundary = new TestLoginInputDataBoundary();
        loginController = new LoginController(testBoundary);
    }

    @Test
    void testExecute() {
        String username = "testUser";
        String password = "testPass";

        loginController.execute(username, password);

        assertEquals(username, testBoundary.loginInputData.getUsername());
        assertEquals(password, testBoundary.loginInputData.getPassword());
    }

    private static class TestLoginInputDataBoundary implements LoginInputDataBoundary {
        LoginInputData loginInputData;

        @Override
        public void execute(LoginInputData loginInputData) {
            this.loginInputData = loginInputData;
        }
    }
}
