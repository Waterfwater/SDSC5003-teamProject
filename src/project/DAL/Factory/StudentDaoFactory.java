package project.DAL.Factory;

import project.DAL.Factory.Dao.Impl.StudentDaoImpl;
import project.DAL.Factory.Dao.StudentDao;

public class StudentDaoFactory{
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }
}
