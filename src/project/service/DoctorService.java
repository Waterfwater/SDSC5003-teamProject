package project.service;

import project.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DoctorService {
    Doctor getDoctorInfoById(String doctorId) throws SQLException;
    void navigateToEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    boolean updateDoctorInfo(Doctor updateDoctor) throws SQLException;
    void addDoctor(Doctor doctor);
    void deleteDoctorById(String doctorId);
    List<Doctor> getDoctorList(String id);
    int getTotalNum(String doctorId);
}
