package project.DAL.Factory;

import project.DAL.Factory.Dao.DoctorDao;
import project.DAL.Factory.Dao.Impl.DoctorDaoImpl;

public class DoctorDaoFactory {
    public static DoctorDao getDoctorDaoInstance(){
        return new DoctorDaoImpl();
    }
}
