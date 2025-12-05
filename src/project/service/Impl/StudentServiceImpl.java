package project.service.Impl;

import project.DAL.Factory.Dao.StudentDao;
import project.entity.Student;
import project.DAL.Factory.StudentDaoFactory;
import project.entity.StudentForC3p0;
import project.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static final StudentDao studentDao = StudentDaoFactory.getStudentDaoInstance();

    @Override
    public boolean updateStudentInfo(Student updatedStudent) throws SQLException {
        return studentDao.updateStudent(updatedStudent);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public List<StudentForC3p0> getStudentList(String id) {
        return studentDao.getStudentList(id);
    }

    @Override
    public void deleteStudentById(String studentId) {
        studentDao.deleteStudentById(studentId);
    }

    @Override
    public void navigateToEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Forward to the editStudent.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/editStudent.jsp");
            dispatcher.forward(request, response);
        }


    @Override
    public Student getStudentInfoById(String studentId) throws SQLException {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public int getTotalNum(String id) {
        return studentDao.getStudentTotalNum(id);
    }
}
