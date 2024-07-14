package entity.manager;

public class ManagerFactory {
    public static Manager createManager(String username, String password, int accessLevel){
        if(accessLevel != Manager.ALL && accessLevel != Manager.READMODIFY && accessLevel != Manager.READ){
            return null;
        }
        return new Manager(username, password, accessLevel);
    }

    public static Manager createReadManager(String username, String password){
        return new Manager(username, password, Manager.READ);
    }

    public static Manager createReadModifyManager(String username, String password){
        return new Manager(username, password, Manager.READMODIFY);
    }

    public static Manager createAllManager(String username, String password){
        return new Manager(username, password, Manager.ALL);
    }

}
