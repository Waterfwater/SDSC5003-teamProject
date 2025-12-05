package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.StudentClassTeacherDao;
import project.entity.StudentClassTeacher;
import project.entity.StudentForC3p0;
import project.entity.TeacherAndStudent;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentClassTeacherDaoImpl implements StudentClassTeacherDao {
    @Override
    public List<StudentClassTeacher> getStudentClassTeacherList(String studentId, String teacherId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select * from student_class_teacher where 1=1 ";

        List<Object> params =new ArrayList<>();

        if(!"".equals(studentId)&& null != studentId){
            sql+="and student_id = ?";
            params.add(studentId);
        }
        if(!"".equals(teacherId)&& null != teacherId){
            sql+="and teacher_id = ?";
            params.add(teacherId);
        }
        List<StudentClassTeacher> list = new ArrayList<>();
        try {
            list = queryRunner.query(sql,
                    new BeanListHandler<StudentClassTeacher>(StudentClassTeacher.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return list;
    }

    @Override
    public int getTotalNum(String studentId, String teacherId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select * from student_class_teacher where 1=1 ";

        List<Object> params =new ArrayList<>();

        if(!"".equals(studentId)&& null != studentId){
            sql+="and student_id = ?";
            params.add(studentId);
        }
        if(!"".equals(teacherId)&& null != teacherId){
            sql+="and teacher_id = ?";
            params.add(teacherId);
        }
        int num = 0;
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
    public StudentClassTeacher getStudentClassTeacher(String studentId, String teacherId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql ="select * from student_class_teacher where 1=1 ";

        List<Object> params =new ArrayList<>();

        if(!"".equals(studentId)&& null != studentId){
            sql+="and student_id = ?";
            params.add(studentId);
        }
        if(!"".equals(teacherId)&& null != teacherId){
            sql+="and teacher_id = ?";
            params.add(teacherId);
        }
        StudentClassTeacher studentClassTeacher = null;
        try {
            studentClassTeacher = queryRunner.query(sql,
                    new BeanHandler<StudentClassTeacher>(StudentClassTeacher.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取到数据 一层一层向上返回
        return studentClassTeacher;
    }

    @Override
    public List<TeacherAndStudent> getStudentByTeacher(String teacherId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from teacher_student where teacher_id=?";
        List<TeacherAndStudent> list = new ArrayList<>();
        try {
            list=queryRunner.query(sql,new BeanListHandler<TeacherAndStudent>(TeacherAndStudent.class),teacherId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getTotalNumByTeacher(String teacherId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select count(1) from teacher_student where teacher_id=?";
        int num = 0;
        try {
            num=queryRunner.query(sql,new ScalarHandler<Long>(),teacherId).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
