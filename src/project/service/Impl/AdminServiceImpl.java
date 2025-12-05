package project.service.Impl;

import project.DAL.Factory.Dao.DoctorDao;
import project.DAL.Factory.Dao.StudentDao;
import project.DAL.Factory.Dao.TeacherDao;
import project.entity.Doctor;
import project.entity.Student;
import project.entity.Teacher;
import project.DAL.Factory.DoctorDaoFactory;
import project.DAL.Factory.StudentDaoFactory;
import project.DAL.Factory.TeacherDaoFactory;
import project.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static final DoctorDao doctorDao = DoctorDaoFactory.getDoctorDaoInstance();
    private static final StudentDao studentDao = StudentDaoFactory.getStudentDaoInstance();
    private static final TeacherDao teacherDao = TeacherDaoFactory.getTeacherDaoInstance();

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public List<Student> findAllStudent() {
        return null;
    }

    @Override
    public void deleteStudentById(String studentId) {

    }

    @Override
    public void updateStudentById(String studentId) {

    }

    @Override
    public void addDoctor(Doctor doctor) {

    }

    @Override
    public List<Doctor> findAllDoctor() {
        return null;
    }

    @Override
    public void deleteDoctorById(String doctorId) {

    }

    @Override
    public void updateDoctorById(String doctorId) {

    }

    @Override
    public List<Teacher> findAllTeacher() {
        return null;
    }

    @Override
    public void deleteTeacherById(String doctorId) {
    }
    @Override
    public void updateTeacherById(String doctorId) {

    }
}
