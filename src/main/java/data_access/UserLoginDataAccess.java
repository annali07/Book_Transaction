package data_access;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

public class UserLoginDataAccess implements UserLoginDataAccessInterface{

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

        private JSONObject readUserData() {
            JSONParser parser = new JSONParser();
            try {
                // Change to local machine path
                Object obj = parser.parse(new FileReader("/Users/nana/Desktop/BookTransaction/src/main/java/data/managers.json"));
                return (JSONObject) obj;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}


