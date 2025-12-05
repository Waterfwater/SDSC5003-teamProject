package project.service;

import project.entity.Student;
import project.entity.StudentForC3p0;
import project.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
        Student getStudentInfoById(String studentId) throws SQLException;
         void navigateToEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
         boolean updateStudentInfo(Student updatedStudent) throws SQLException;
         void addStudent(Student student);
         void deleteStudentById(String studentId);
         List<StudentForC3p0> getStudentList(String id);

    int getTotalNum(String id);
}

