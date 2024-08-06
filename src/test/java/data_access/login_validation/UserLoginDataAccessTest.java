package data_access.login_validation;

import data.misc_info.FilePathConstants;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginDataAccessTest {

    private static final String TEST_FILE_PATH = FilePathConstants.MANAGERS_FILE;
    private UserLoginDataAccess userLoginDataAccess;

    @BeforeEach
    void setUp() throws Exception {
        userLoginDataAccess = new UserLoginDataAccess();
    }

    @Test
    void testValidateUserLoginSuccess() {
        assertTrue(userLoginDataAccess.validateUserLogin("anna", "123"));
    }

    @Test
    void testValidateUserLoginInvalidUsername() {
        assertFalse(userLoginDataAccess.validateUserLogin("invalidUser", "password123"));
    }

    @Test
    void testValidateUserLoginInvalidPassword() {
        assertFalse(userLoginDataAccess.validateUserLogin("anna", "111111"));
    }

    @Test
    void testValidateUserLoginEmptyUsername() {
        assertFalse(userLoginDataAccess.validateUserLogin("", "password123"));
    }

    @Test
    void testValidateUserLoginEmptyPassword() {
        assertFalse(userLoginDataAccess.validateUserLogin("admin", ""));
    }
}
