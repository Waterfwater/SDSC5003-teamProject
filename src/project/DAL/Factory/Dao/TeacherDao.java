package project.DAL.Factory.Dao;

import project.entity.Doctor;
import project.entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    public boolean login(String id,String passwd);

    List<Teacher> getTeacherList(String id,String className);
    Doctor getTeacherById(String teacherId) throws SQLException;
    boolean updateTeacher(Teacher teacher);
    void addTeacher(Teacher teacher);
    void deleteTeacherById(String teacherId);

    int getTotalNum(String id, String className);
}
