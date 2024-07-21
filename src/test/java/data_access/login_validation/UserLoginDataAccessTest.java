package data_access.login_validation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.FileReader;

public class UserLoginDataAccessTest {
    @InjectMocks
    private UserLoginDataAccess userLoginDataAccess;

    @Mock
    private FileReader fileReader;
    @Mock
    private JSONParser jsonParser;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        JSONObject mockUserDetails = new JSONObject();
        JSONObject userDetails = new JSONObject();
        userDetails.put("username", "anna");
        userDetails.put("password", "123");
        mockUserDetails.put("1", userDetails);

        when(jsonParser.parse(any(FileReader.class))).thenReturn(mockUserDetails);
    }

    @Test
    public void testValidateUserLoginSuccess() throws Exception {
        assertTrue(userLoginDataAccess.validateUserLogin("anna", "123"));
    }

    @Test
    public void testValidateUserLoginFailure() throws Exception {
        assertFalse(userLoginDataAccess.validateUserLogin("wrongUser", "wrongPass"));
    }
}
