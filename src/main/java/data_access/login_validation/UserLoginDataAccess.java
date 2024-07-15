package data_access.login_validation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of UserLoginDataAccessInterface for validating user login credentials.
 */
public class UserLoginDataAccess implements UserLoginDataAccessInterface{
        /**
         * Validates the user login by checking the provided username and password against stored user data.
         *
         * @param username the username to validate
         * @param password the password to validate
         * @return true if the username and password match a stored user, false otherwise
         */
        @Override
        public boolean validateUserLogin(String username, String password) {
            JSONObject userData = readUserData();
            if (userData == null) return false;

            Set keys = userData.keySet();  // Get all keys from the JSONObject
            Iterator<String> it = keys.iterator();

            while (it.hasNext()) {
                String key = it.next();
                JSONObject user = (JSONObject) userData.get(key);
                String storedUsername = (String) user.get("username");
                String storedPassword = (String) user.get("password");

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true;
                }
            }

            return false;
        }
        /**
         * Reads the user data from a JSON file.
         *
         * @return a JSONObject containing the user data, or null if an error occurs
         */
        private JSONObject readUserData() {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader("/Users/sakuramao/Desktop/Book_Transaction/src/main/java/data/managers.json"));
                return (JSONObject) obj;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}


