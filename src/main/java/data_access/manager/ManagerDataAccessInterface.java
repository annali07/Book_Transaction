package data_access.manager;

import entity.manager.Manager;

public interface ManagerDataAccessInterface {
    Manager getManagerByUName(String managerId);
    void updateManager(Manager manager);
    void deleteManager(String managerId);
}
