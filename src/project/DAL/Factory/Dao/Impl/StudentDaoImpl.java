package project.DAL.Factory.Dao.Impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.StudentDao;
import project.entity.Student;
import project.entity.StudentForC3p0;
import project.util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    //这俩是为了分页或者管理员页面写的 请自行调整
    @Override
    public List<StudentForC3p0> getStudentList(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select * from student where 1=1 ";

        List<Object> params =new ArrayList<>();

        if(!"".equals(id)&& null != id){
            sql+="and student_id = ?";
            params.add(id);
        }
        List<StudentForC3p0> list = new ArrayList<>();
        try {
            list = queryRunner.query(sql,
                    new BeanListHandler<StudentForC3p0>(StudentForC3p0.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return list;
    }

    @Override
    public int getStudentTotalNum(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select count(1) from student where 1=1 ";

        List<Object> params =new ArrayList<>();

        if(!"".equals(id)&& null != id){
            sql+="and student_id = ?";
            params.add(id);
        }
        List<StudentForC3p0> list = new ArrayList<>();

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

    @Override
    public boolean login(String id, String passwd) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //对唯一性进行校验
        Student student=null;
        try {
            student = queryRunner.query("select * from student where student_id = ? and student_pwd = ?",new BeanHandler<Student>(Student.class),id,passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (null!=student);
    }
    @Override
    public Student getStudentById(String studentId) throws SQLException {
        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
            String sql = "SELECT * FROM student WHERE student_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, studentId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // 创建学生对象并设置属性
                        Student student = new Student();
                        student.setStudentId(resultSet.getString("student_id"));
                        student.setStudentName(resultSet.getString("student_name"));
                        student.setAge(resultSet.getInt("age"));
                        student.setMajorClass(resultSet.getString("major_class"));
                        student.setStudentSex(resultSet.getString("student_sex"));
                        student.setIdCardNum(resultSet.getString("idcard_num"));
                        student.setPhoneNumber(resultSet.getString("phone_number"));
                        // 添加调试语句
                        System.out.println("Student found: " + student.getStudentId() + " - " + student.getStudentName());
                        return student; // 返回学生对象
                    }
                }
            }
        }
        return null; // 如果没有找到学生，返回null
    }

    @Override
    public void addStudent(Student student) {
//        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
//            String sql = "insert into student (student_id,student_name,student_pwd,student_sex,age,major_class,phone_number,idcard_num)" +
//                    "values (?,?,?,?,?,?,?,?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                    statement.setString(1, student.getStudentId());
//                statement.setString(2, student.getStudentName());
//                statement.setString(3, student.getStudentPwd());
//                statement.setString(4, student.getStudentSex());
//                statement.setInt(5, student.getAge());
//                statement.setString(6, student.getMajorClass());
//                statement.setString(7, student.getPhoneNumber());
//                statement.setString(8, student.getIdCardNum());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into student (student_id,student_name,student_pwd,student_sex,age,major_class,phone_number,idcard_num)" +
                    "values (?,?,?,?,?,?,?,?)";
        try {
            queryRunner.update(sql,student.getStudentId(),student.getStudentName(),student.getStudentPwd(),student.getStudentSex(),student.getAge(),student.getMajorClass(),student.getPhoneNumber(),student.getIdCardNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void deleteStudentById(String studentId) {
//        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
////            String sql = "delete from student where student_id = ?";
////            try (PreparedStatement statement = connection.prepareStatement(sql)) {
////                statement.setString(1, studentId);
////    }
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "delete from student where student_id = ?";
        try {
            queryRunner.update(sql,studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try (Connection connection = C3P0Util.getDataSource().getConnection()) {
            String sql = "UPDATE student SET student_name = ?, age = ?, major_class = ?, student_sex = ?, " +
                    "idcard_num = ?, phone_number = ? ,student_pwd = ? WHERE student_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, student.getStudentName());
                statement.setInt(2, student.getAge());
                statement.setString(3, student.getMajorClass());
                statement.setString(4, student.getStudentSex());
                statement.setString(5, student.getIdCardNum());
                statement.setString(6, student.getPhoneNumber());
                statement.setString(7, student.getStudentPwd());
                statement.setString(8, student.getStudentId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }
}
