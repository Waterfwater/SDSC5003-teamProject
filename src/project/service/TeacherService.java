package project.service;

import project.entity.Teacher;
import project.entity.TeacherAndStudent;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeacherList(String id, String className);

    int getTotalNum(String id, String className);

    List<TeacherAndStudent> getStudentList(String teacherId);

    int getTotalNumByTeacher(String teacherId);
}
