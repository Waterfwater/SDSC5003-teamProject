package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import project.DAL.Factory.Dao.AppointmentDao;
import project.entity.Appointment;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements AppointmentDao {
    @Override
    public List<Appointment> getappointmentList(String appointmentId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sqlquerry = "select * from appointment where 1=1";

        List<String> params = new ArrayList<>();

        List<Appointment> appointmentList = new ArrayList<>();

        if (!"".equals(appointmentId) && null != appointmentId) {
            sqlquerry += " and appointment_id=?";
            params.add(appointmentId);
        }



        try {
            //驼峰转换--查询出来有些格式不对--可以用此函数来转换
            BeanProcessor beanProcessor = new GenerousBeanProcessor();
            RowProcessor processor = new BasicRowProcessor(beanProcessor);
            appointmentList = queryRunner.query(sqlquerry, new BeanListHandler<Appointment>(Appointment.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }

    @Override
    public int updateappointmentList (String appointmentId, String appointmentTime, String appointmentDate) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sqlupdate = "update appointment set appointment_time=?,appointment_date=? where appointment_id=?";
        int flag=0;

            BeanProcessor beanProcessor = new GenerousBeanProcessor();
            RowProcessor processor = new BasicRowProcessor(beanProcessor);

        try {
            flag= queryRunner.update(sqlupdate, appointmentTime, appointmentDate, appointmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int insertappointmentList(String studentId, String doctorId, String appointmentTime, String appointmentDate) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sqlupdate = "insert into appointment(student_id,doctor_id,appointment_time,appointment_date) values (?,?,?,?)";
        int flag=0;

        BeanProcessor beanProcessor = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(beanProcessor);

        try {
            flag= queryRunner.update(sqlupdate,studentId,doctorId, appointmentTime, appointmentDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int newDiagnoseForm(String doctorId, String studentId,int num) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());

        String sqlupdate = "insert into cases(case_id,doctor_id,student_id,diagnostic_num) values (null,?,?,?)";
        int flag=0;

//        BeanProcessor beanProcessor = new GenerousBeanProcessor();
//        RowProcessor processor = new BasicRowProcessor(beanProcessor);


        try {
            flag= queryRunner.update(sqlupdate,doctorId,studentId,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
