package project.service;

import project.entity.Appointment;

import java.util.List;

public interface StuAppoService {

    List<Appointment> getappointmentList(String appointmentId);
    int updateappointmentList(String appointmentId, String appointmentTime, String appointmentDate);

    int insertappointmentList(String studentId, String doctorId, String appointmentTime, String appointmentDate);



    int newDiagnoseForm(String doctorId, String studentId);
}