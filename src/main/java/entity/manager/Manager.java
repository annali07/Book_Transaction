package entity.manager;

public class Manager {
    private String Username;
    private String Password;
    private int AccessLevel;

    public static final int READ = 2;
    public static final int READMODIFY = 1;
    public static final int ALL = 0;

    public Manager(String username, String password, int accessLevel) {
        this.Username = username;
        this.Password = password;
        this.AccessLevel = accessLevel;
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public int getAccessLevel() {
        return AccessLevel;
    }
    public void setAccessLevel(int accessLevel) {
        AccessLevel = accessLevel;
    }

    public Boolean isREAD(){
        return AccessLevel == READ;
    }

    public Boolean isREADMODIFY(){
        return AccessLevel == READMODIFY;
    }

    public Boolean isALL(){
        return AccessLevel == ALL;
    }
}
