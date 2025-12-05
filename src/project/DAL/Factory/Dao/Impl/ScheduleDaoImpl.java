package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.ScheduleDao;
import project.entity.AppointmentShowReal;
import project.entity.Schedule;
import project.entity.ScheduleForDoctor;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {
    @Override
    public List<Schedule> getSchedules(String doctorId, String date, String time) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from doctor_schedules where 1=1";
        List<Object> params = new ArrayList<>();
        if(!"".equals(doctorId)&& null !=doctorId){
            sql+=" and doctor_id=?";
            params.add(doctorId);
        }
        if(!"".equals(date)&& null !=date){
            sql+=" and =?";
            params.add(date);
        }

        if(!"".equals(time)&& null !=time){
            sql+=" and schedule_time=?";
            params.add(time);
        }
//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        List<Schedule> query= null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<Schedule>(Schedule.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void writeSchedule(String doctorId,String date, String time) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into doctor_schedules(doctor_id,schedule_date,schedule_time) values(?,?,?)";

        try {
            queryRunner.update(sql,doctorId,date,time);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void book(String doctorId,String date, String time) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "update doctor_schedules set booking = 1 where doctor_id = ? and schedule_date = ? and schedule_time = ?";

        try {
            queryRunner.update(sql,doctorId,date,time);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateSchedule(String doctorId, String date, String time) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "update doctor_schedules set schedule_date = ?, schedule_time = ? where doctor_id = ?";

        try {
            queryRunner.update(sql,date,time,doctorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ScheduleForDoctor> getDoctorList(String date, String time) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql =
                "SELECT \n" +
                        "    DATE_FORMAT(ds.schedule_time, '%H:%i:%s') AS schedule_time,\n" +
                        "    ds.schedule_date,\n" +
                        "    ds.booking,\n" +
                        "    d.doctor_id,\n" +
                        "    d.doctor_name,\n" +
                        "    d.title\n" +
                        "FROM doctor_schedules ds\n" +
                        "JOIN doctor d ON ds.doctor_id = d.doctor_id\n" +
                        "WHERE 1=1;\n";
//        String sql = "select * from doctor_schedules where booking is null and 1=1";
        List<Object> params = new ArrayList<>();
        if(!"".equals(date)&& null !=date){
            sql+=" and schedule_date =?";
            params.add(date);
        }

        if(!"".equals(time)&& null !=time){
            sql+=" and schedule_time=?";
            params.add(time);
        }

        List<ScheduleForDoctor> query= null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<ScheduleForDoctor>(ScheduleForDoctor.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int getDoctorTotalNum(String date, String time) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select count(1) from doctor_schedules where booking is null and 1=1";
        List<Object> params = new ArrayList<>();
        if(!"".equals(date)&& null !=date){
            sql+=" and schedule_date =?";
            params.add(date);
        }

        if(!"".equals(time)&& null !=time){
            sql+=" and schedule_time=?";
            params.add(time);
        }

        int num = 0;
        try {
            num = queryRunner.query(sql, new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int getTotalNum(String doctorId, String date) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select count(1) from doctor_schedules where 1=1";
        List<Object> params = new ArrayList<>();
        if(!"".equals(doctorId)&& null !=doctorId){
            sql+=" and doctor_id=?";
            params.add(doctorId);
        }
        if(!"".equals(date)&& null !=date){
            sql+=" and =?";
            params.add(date);
        }

        int num = 0;
        try {
            num = queryRunner.query(sql, new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
