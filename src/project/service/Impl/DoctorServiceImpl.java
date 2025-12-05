package project.service.Impl;

import project.DAL.Factory.Dao.DoctorDao;
import project.entity.Doctor;
import project.DAL.Factory.DoctorDaoFactory;
import project.service.DoctorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private static final DoctorDao doctorDao = DoctorDaoFactory.getDoctorDaoInstance();

    @Override
    public List<Doctor> getDoctorList(String id) {
        return doctorDao.getDoctorList(id);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }

    @Override
    public void deleteDoctorById(String doctorId) {
        doctorDao.deleteDoctorById(doctorId);
    }

    @Override
    public Doctor getDoctorInfoById(String doctorId) throws SQLException {
        return doctorDao.getDoctorById(doctorId);
    }

    @Override
    public void navigateToEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editDoctor.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public boolean updateDoctorInfo(Doctor updateDoctor) throws SQLException {
        return doctorDao.updateDoctor(updateDoctor);
    }

    @Override
    public int getTotalNum(String doctorId) {
        return doctorDao.getTotalNum(doctorId);
    }
}
