package data_access;

import entity.Manager;

public interface ManagerDataAccessInterface {
    Manager getManagerByUName(String managerId);
    void updateManager(Manager manager);
    void deleteManager(String managerId);
}
