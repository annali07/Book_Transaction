package use_case.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInputDataTest {
    private LoginInputData loginInputData;
    private final String username = "testuser";
    private final String password = "testpassword";

    @BeforeEach
    void setUp() {
        loginInputData = new LoginInputData(username, password);
    }

    @Test
    void getUsername() {
        assertEquals(username, loginInputData.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals(password, loginInputData.getPassword());
    }
}