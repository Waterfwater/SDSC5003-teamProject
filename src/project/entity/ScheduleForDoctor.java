package project.entity;

import java.sql.Time;

public class ScheduleForDoctor {
    private String doctor_id;
    private String doctor_name;
    private String title;
    private String schedule_time;


    private String schedule_date;
    private String booking;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchedule_time() {
        return schedule_time;
    }


    public void setSchedule_time(String t){
        this.schedule_time = t;
    }


    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }
}
