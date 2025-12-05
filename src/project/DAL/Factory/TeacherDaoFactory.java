package project.DAL.Factory;


import project.DAL.Factory.Dao.Impl.TeacherDaoImpl;
import project.DAL.Factory.Dao.TeacherDao;

public class TeacherDaoFactory {
    public static TeacherDao getTeacherDaoInstance(){
        return new TeacherDaoImpl();
    }
}
