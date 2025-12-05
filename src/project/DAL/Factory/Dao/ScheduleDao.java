package project.DAL.Factory.Dao;

import project.entity.Schedule;
import project.entity.ScheduleForDoctor;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> getSchedules(String doctorId, String date, String time);

    void writeSchedule(String doctorId,String date, String time);

    void book(String doctorId,String date, String time);

    int getTotalNum(String doctorId, String date);

    int getDoctorTotalNum(String date, String time);

    void updateSchedule(String doctorId,String date,String time);

    List<ScheduleForDoctor> getDoctorList(String date, String time);
}

