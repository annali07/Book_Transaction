package use_case.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginOutputDataTest {

    private LoginOutputData loginOutputData;
    private final String username = "testuser";
    private final boolean loginFailed = false;

    @BeforeEach
    void setUp() {
        loginOutputData = new LoginOutputData(username, loginFailed);
    }

    @Test
    void getUsername() {
        assertEquals(username, loginOutputData.getUsername());
    }

    @Test
    void setSuccess() {
        loginOutputData.setSuccess(true);
        assertEquals(true, loginOutputData.loginFailed);
    }

    @Test
    void defaultButton() {
        assertEquals("none", loginOutputData.defaultButton());
    }
}