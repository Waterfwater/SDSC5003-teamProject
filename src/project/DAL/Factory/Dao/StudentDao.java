package project.DAL.Factory.Dao;

import project.entity.Student;
import project.entity.StudentForC3p0;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<StudentForC3p0> getStudentList(String id);

    int getStudentTotalNum(String id);

    boolean login(String id,String passwd);
    Student getStudentById(String studentId) throws SQLException;
    boolean updateStudent(Student student);
    void addStudent(Student student);
    void deleteStudentById(String studentId);

}
