package project.service;

import project.entity.Doctor;
import project.entity.Student;
import project.entity.Teacher;

import java.util.List;

public interface AdminService {
    void addStudent(Student student);
    List<Student> findAllStudent();
    void deleteStudentById(String studentId);
    void updateStudentById(String studentId);
    void addDoctor(Doctor doctor);
    List<Doctor> findAllDoctor();
    void deleteDoctorById(String doctorId);
    void updateDoctorById(String doctorId);
    List<Teacher> findAllTeacher();
    void deleteTeacherById(String doctorId);
    void updateTeacherById(String doctorId);
}
