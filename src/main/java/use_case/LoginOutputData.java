package use_case;

public class LoginOutputData {
        private boolean loginFailed;
        private String username;
        private String activeButton = "none";

        public LoginOutputData(String username, boolean loginFailed) {
            this.username = username;
            this.loginFailed = loginFailed;
        }

        public String getUsername(){
            return this.username;
        }

        public void setSuccess(boolean success) {
            this.loginFailed = success;
        }
        public String defaultButton(){
            return this.activeButton;
        }

}
