package project.DAL.Factory;

import project.DAL.Factory.Dao.AdminDao;
import project.DAL.Factory.Dao.DoctorDao;
import project.DAL.Factory.Dao.Impl.AdminDaoImpl;
import project.DAL.Factory.Dao.Impl.DoctorDaoImpl;

public class AdminDaoFactory {
    public static AdminDao getAdminDaoInstance(){
        return new AdminDaoImpl();
    }
}
