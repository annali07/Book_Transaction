package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStateTest {

    private LoginState loginState;

    @BeforeEach
    void setUp() {
        loginState = new LoginState();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(loginState);
        assertEquals("", loginState.getUsername());
        assertNull(loginState.getUsernameError());
        assertEquals("", loginState.getPassword());
        assertNull(loginState.getPasswordError());
    }

    @Test
    void testCopyConstructor() {
        LoginState originalState = new LoginState();
        originalState.setUsername("testUser");
        originalState.setUsernameError("username error");
        originalState.setPassword("testPass");
        originalState.setPasswordError("password error");

        LoginState copiedState = new LoginState(originalState);

        assertEquals("testUser", copiedState.getUsername());
        assertEquals("username error", copiedState.getUsernameError());
        assertEquals("testPass", copiedState.getPassword());
        assertEquals("password error", copiedState.getPasswordError());
    }

    @Test
    void testSetAndGetUsername() {
        loginState.setUsername("newUser");
        assertEquals("newUser", loginState.getUsername());
    }

    @Test
    void testSetAndGetUsernameError() {
        loginState.setUsernameError("newUsernameError");
        assertEquals("newUsernameError", loginState.getUsernameError());
    }

    @Test
    void testSetAndGetPassword() {
        loginState.setPassword("newPass");
        assertEquals("newPass", loginState.getPassword());
    }

    @Test
    void testSetAndGetPasswordError() {
        loginState.setPasswordError("newPasswordError");
        assertEquals("newPasswordError", loginState.getPasswordError());
    }
}
