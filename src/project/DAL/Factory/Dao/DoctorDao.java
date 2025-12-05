package project.DAL.Factory.Dao;

import project.entity.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDao{
    List<Doctor> getDoctorList(String id);
    boolean login(String id,String passwd);
    Doctor getDoctorById(String doctortId) throws SQLException;
    boolean updateDoctor(Doctor doctor);
    void addDoctor(Doctor doctor);
    void deleteDoctorById(String doctorId);

    int getTotalNum(String doctorId);
}
