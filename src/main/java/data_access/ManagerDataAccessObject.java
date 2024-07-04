//package data_access;
//
//import entity.Manager;
//import java.sql.*;
//
//public class ManagerDataAccessObject implements  ManagerDataAccessInterface{
//
//    // REASON: Signals a fixed link to the database throughout the object's lifecycle
//    final Connection connection;
//
//    public ManagerDataAccessObject(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public Manager getManagerByUName(String managerId) {
//        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM managers WHERE Username = ?")) {
//            ps.setString(1, managerId);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Manager(rs.getString("Username"), rs.getString("Password"), rs.getString("AccessLevel"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public void updateManager(Manager manager) {
//        try (PreparedStatement ps = connection.prepareStatement("UPDATE managers SET name = ?, email = ? WHERE manager_id = ?")) {
//            ps.setString(1, manager.getName());
//            ps.setString(2, manager.getEmail());
//            ps.setString(3, manager.getManagerId());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteManager(String managerId) {
//        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM managers WHERE manager_id = ?")) {
//            ps.setString(1, managerId);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
