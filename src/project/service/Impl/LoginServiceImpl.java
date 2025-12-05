package project.service.Impl;

import project.DAL.Factory.AdminDaoFactory;
import project.DAL.Factory.Dao.AdminDao;
import project.DAL.Factory.Dao.DoctorDao;
import project.DAL.Factory.Dao.StudentDao;
import project.DAL.Factory.Dao.TeacherDao;
import project.DAL.Factory.DoctorDaoFactory;
import project.DAL.Factory.StudentDaoFactory;
import project.DAL.Factory.TeacherDaoFactory;
import project.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private static DoctorDao doctorDao = DoctorDaoFactory.getDoctorDaoInstance();
    private static StudentDao studentrDao = StudentDaoFactory.getStudentDaoInstance();
    private static TeacherDao teacherDao = TeacherDaoFactory.getTeacherDaoInstance();
    private static AdminDao adminDao = AdminDaoFactory.getAdminDaoInstance();

    private String url = "";

    @Override
    public String login(String id, String passwd) {
        if (id == null)
            return null;
        if (id.startsWith("S-")) {
            if (studentrDao.login(id, passwd)) {
                url = "student";
                return url;
            }
        } else if (id.startsWith("T-")) {
            if (teacherDao.login(id, passwd)) {
                url = "teacher";
                return url;
            }
        } else if (id.startsWith("D-")) {
            if (doctorDao.login(id, passwd)) {
                url = "doctor";
                return url;
            }
        } else if (id.startsWith("A-")) {
            if (adminDao.login(id, passwd)) {
                url = "manage";
                return url;
            }


        }
        //登录失败
        return null;
    }
}
