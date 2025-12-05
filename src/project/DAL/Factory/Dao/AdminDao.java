package project.DAL.Factory.Dao;

import project.entity.Admin;
import project.entity.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    List<Admin> getAdminList();
    boolean login(String id,String passwd);
    void addAdmin(Admin admin);
    void deleteAdminById(String adminId);
}
