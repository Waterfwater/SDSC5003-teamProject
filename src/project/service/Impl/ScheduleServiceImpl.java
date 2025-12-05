package project.service.Impl;

import project.DAL.Factory.Dao.ScheduleDao;
import project.DAL.Factory.ScheduleDaoFactory;
import project.entity.Schedule;
import project.entity.ScheduleForDoctor;
import project.service.ScheduleService;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private static ScheduleDao scheduleDao = ScheduleDaoFactory.getScheduleDaoInstance();
    List<Schedule> list = new ArrayList<>();

    @Override
    public List<Schedule> getSchedules(String doctorId, String date, String time) {
        return list =scheduleDao.getSchedules(doctorId,date,time);
//        for (Schedule schedule: list) {
//            Time time1 =
//            schedule.setSchedule_time(date.to(schedule.getSchedule_time()));
//
//        }

    }

    @Override
    public List<ScheduleForDoctor> getDoctorList(String date, String time) {
        return scheduleDao.getDoctorList(date,time);
    }

    @Override
    public void writeSchedule(String doctorId,String date, String time) {
        scheduleDao.writeSchedule(doctorId,date,time);
    }

    @Override
    public void book(String doctorId,String date, String time) {
        scheduleDao.book(doctorId,date,time);
    }

    @Override
    public void updateSchedule(String doctorId, String date, String time) {
        scheduleDao.updateSchedule(doctorId,date,time);
    }

    @Override
    public int getTotalNum(String doctorId, String date) {
        return scheduleDao.getTotalNum(doctorId,date);
    }

    @Override
    public int getScheduleTotalNum(String date, String time) {
        return scheduleDao.getDoctorTotalNum(date,time);
    }
}
