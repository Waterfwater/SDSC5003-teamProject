package project.DAL.Factory.Dao;

import project.entity.StudentClassTeacher;
import project.entity.TeacherAndStudent;

import java.util.List;

public interface StudentClassTeacherDao {
    List<StudentClassTeacher> getStudentClassTeacherList(String studentId,String teacherId);


    int getTotalNum(String studentId,String teacherId);

    StudentClassTeacher getStudentClassTeacher(String studentId, String teacherId);

    List<TeacherAndStudent> getStudentByTeacher(String teacherId);
    int getTotalNumByTeacher(String teacherId);
}
