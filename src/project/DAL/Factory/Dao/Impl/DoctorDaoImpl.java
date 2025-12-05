package project.DAL.Factory.Dao.Impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.DoctorDao;
import project.entity.Doctor;
import project.util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {


    @Override
    public List<Doctor> getDoctorList(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select * from doctor where 1=1 ";

        List<Object> params =new ArrayList<>();
        if(!"".equals(id)&& null != id){
            sql+="and doctor_id = ?";
            params.add(id);
        }
        List<Doctor> list = new ArrayList<>();
        try {
            list = queryRunner.query(sql,
                    new BeanListHandler<Doctor>(Doctor.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return list;
    }

    @Override
    public boolean login(String id, String passwd) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //对唯一性进行校验
        Doctor student=null;
        try {
            student = queryRunner.query("select * from doctor where doctor_id = ? and doctor_pwd = ?",new BeanHandler<Doctor>(Doctor.class),id,passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (null!=student);
    }
    @Override
    public Doctor getDoctorById(String doctortId) throws SQLException {
        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
            String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, doctortId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {

                        Doctor doctor = new Doctor();
                        doctor.setDoctor_id(resultSet.getString("doctor_id"));
                        doctor.setDoctor_name(resultSet.getString("doctor_name"));
                        doctor.setAge(resultSet.getInt("age"));
                        doctor.setDepartment(resultSet.getString("department"));
                        doctor.setDoctor_sex(resultSet.getString("doctor_sex"));
                        doctor.setTitle(resultSet.getString("title"));
                        doctor.setPhone_number(resultSet.getString("phone_number"));
                        return doctor;
                    }
                }
            }
        }
        return null; //
    }
    @Override
    public boolean updateDoctor(Doctor doctor) {
        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
            String sql = "UPDATE doctor SET doctor_name = ?, age = ?, department = ?, doctor_sex = ?, " +
                    "title = ?, phone_number = ? ,doctor_pwd = ? WHERE doctor_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set the parameters for the update query
                statement.setString(1, doctor.getDoctor_name());
                statement.setInt(2, doctor.getAge());
                statement.setString(3, doctor.getDepartment());
                statement.setString(4, doctor.getDoctor_sex());
                statement.setString(5, doctor.getTitle());
                statement.setString(6, doctor.getPhone_number());
                statement.setString(7, doctor.getDoctor_pwd());
                statement.setString(8, doctor.getDoctor_id());

                int rowsUpdated = statement.executeUpdate();

                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public void addDoctor(Doctor doctor) {
//        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
//            String sql = "insert into doctor (doctor_id,doctor_name,doctor_pwd,doctor_sex,age,title,phone_number,head_of_department)" +
//                    "values (?,?,?,?,?,?,?,?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, doctor.getDoctor_id());
//                statement.setString(2, doctor.getDoctor_name());
//                statement.setString(3, doctor.getDoctor_pwd());
//                statement.setString(4, doctor.getDoctor_sex());
//                statement.setInt(5, doctor.getAge());
//                statement.setString(6, doctor.getTitle());
//                statement.setString(7, doctor.getDepartment());
//                statement.setString(8, doctor.getHead_of_department());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql =  "insert into doctor (doctor_id,doctor_name,doctor_pwd,doctor_sex,age,title,phone_number,department,head_of_department)" +
                    "values (?,?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql,doctor.getDoctor_id(),doctor.getDoctor_name(),doctor.getDoctor_pwd(),doctor.getDoctor_sex(),doctor.getAge(),doctor.getTitle(),doctor.getPhone_number(),doctor.getDepartment(),doctor.getHead_of_department());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteDoctorById(String doctorId) {
//        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
//            String sql = "delete from doctor where doctor_id = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1,doctorId);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "delete from doctor where doctor_id = ?";

        try {
            queryRunner.update(sql,doctorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getTotalNum(String doctorId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select count(1) from doctor where 1=1 ";

        List<Object> params =new ArrayList<>();
        if(!"".equals(doctorId)&& null != doctorId){
            sql+="and doctor_id = ?";
            params.add(doctorId);
        }
        int num=0;
        try {
            num = queryRunner.query(sql,
                    new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return num;
    }
}
