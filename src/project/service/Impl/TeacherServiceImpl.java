package project.service.Impl;

import project.DAL.Factory.Dao.Impl.StudentClassTeacherDaoImpl;
import project.DAL.Factory.Dao.StudentClassTeacherDao;
import project.DAL.Factory.Dao.StudentDao;
import project.DAL.Factory.Dao.TeacherDao;
import project.DAL.Factory.StudentDaoFactory;
import project.DAL.Factory.TeacherDaoFactory;
import project.entity.StudentClassTeacher;
import project.entity.Teacher;
import project.entity.TeacherAndStudent;
import project.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private static TeacherDao teacherDao = TeacherDaoFactory.getTeacherDaoInstance();
    @Override
    public List<Teacher> getTeacherList(String id, String className) {
        return teacherDao.getTeacherList(id,className);
    }

    @Override
    public int getTotalNum(String id, String className) {
        return teacherDao.getTotalNum(id,className);
    }

    @Override
    public List<TeacherAndStudent> getStudentList(String teacherId) {
        StudentClassTeacherDao studentClassTeacherDao = new StudentClassTeacherDaoImpl();
        return studentClassTeacherDao.getStudentByTeacher(teacherId);
    }

    @Override
    public int getTotalNumByTeacher(String teacherId) {
        StudentClassTeacherDao studentClassTeacherDao = new StudentClassTeacherDaoImpl();
        return studentClassTeacherDao.getTotalNumByTeacher(teacherId);
    }
}
