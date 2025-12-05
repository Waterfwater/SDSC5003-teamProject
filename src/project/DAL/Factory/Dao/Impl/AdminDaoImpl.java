package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import project.DAL.Factory.Dao.AdminDao;
import project.entity.Admin;
import project.entity.Doctor;
import project.entity.Teacher;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public List<Admin> getAdminList() {
        return null;
    }

    @Override
    public boolean login(String id, String passwd) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //对唯一性进行校验
        Admin list=null;
        try {
            list = queryRunner.query("select * from admins where admin_id = ? and admin_psw = ?",new BeanHandler<Admin>(Admin.class),id,passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (null!=list);
    }

    @Override
    public void addAdmin(Admin admin) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "update admin set (fullname = ?,phone = ?,password = ?) where admin_id = ?)";
        try {
            queryRunner.update(sql,admin.getUsername(),admin.getEmail(),admin.getPassword(),admin.getAdmin_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAdminById(String adminId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "delete from admin where admin_id = ?";

        try {
            queryRunner.update(sql,adminId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
