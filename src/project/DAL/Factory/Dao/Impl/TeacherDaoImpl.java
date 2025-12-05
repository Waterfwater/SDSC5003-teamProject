package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.TeacherDao;
import project.entity.Doctor;
import project.entity.Teacher;
import project.util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public boolean login(String id, String passwd) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //对唯一性进行校验
        Teacher list=null;
        try {
            list = queryRunner.query("select * from teacher where teacher_id = ? and passwd = ?",new BeanHandler<Teacher>(Teacher.class),id,passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (null!=list);
    }

    @Override
    public List<Teacher> getTeacherList(String id, String className) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from teacher_plus_class";

        List<Object> params =new ArrayList<>();

        if(!"".equals(id)&& null != id){
            sql+="and teacher_id = ?";
            params.add(id);
        }

        if(!"".equals(className)&& null != id){
            sql+="and major_class = ?";
            params.add(className);
        }

        List<Teacher> list = new ArrayList<>();
        try {
            list = queryRunner.query(sql,
                    new BeanListHandler<Teacher>(Teacher.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return list;
    }

    @Override
    public Doctor getTeacherById(String teacherId) throws SQLException {
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
            String sql = "UPDATE teacher SET teacher_name = ?,phone_number = ? ,passwd = ? WHERE teacher_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, teacher.getTeacher_name());
                statement.setString(2, teacher.getPhone());
                statement.setString(3, teacher.getPasswd());
                statement.setString(4, teacher.getTeacher_id());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public void addTeacher(Teacher teacher) {
//        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
//            String sql = "insert into teacher (teacher_id,teacher_name,phone,passwd)" +
//                    "values (?,?,?,?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, teacher.getTeacher_id());
//                statement.setString(2, teacher.getTeacher_name());
//                statement.setString(3, teacher.getPhone());
//                statement.setString(4, teacher.getPasswd());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into teacher (teacher_id,teacher_name,phone,passwd)" +
                    "values (?,?,?,?)";
        try {
            queryRunner.update(sql,teacher.getTeacher_id(),teacher.getTeacher_name(),teacher.getPhone(),teacher.getPasswd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacherById(String teacherId) {
        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
            String sql = "delete from teacher where teacher_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, teacherId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getTotalNum(String id, String className) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select count(1) from teacher_plus_class";

        List<Object> params =new ArrayList<>();

        if(!"".equals(id)&& null != id){
            sql+="and teacher_id = ?";
            params.add(id);
        }

        if(!"".equals(className)&& null != id){
            sql+="and major_class = ?";
            params.add(className);
        }
        int num=0;
        try {
            num = queryRunner.query(sql,
                    new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return num;
    }
}
