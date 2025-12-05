package project.DAL.Factory.Dao;

import project.entity.Appointment;

import java.util.List;

public interface AppointmentDao {
    public List<Appointment> getappointmentList(String appointmentId);
    public int updateappointmentList(String appointmentId,  String appointmentTime, String appointmentDate);

    public int insertappointmentList(String studentId, String doctorId, String appointmentTime, String appointmentDate);

    int newDiagnoseForm(String doctorId, String studentId,int num);
}
