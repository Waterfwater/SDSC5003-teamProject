package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.ReportDao;
import project.entity.Report;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {

    @Override
    public List<Report> Report(String repo_id,
                        String student_name,
                        String student_sex,
                        String age,
                        String phone_number,
                        String teacher_name,
                        String phone,
                        String diagnose_Message,
                        String case_description,
                        String report_Date,
                        String student_id,
                        String teacher_id,
                        String doctor_id){

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<String> params = new ArrayList<>();


        String sql= "select * from report where 1=1";
        if(!"".equals(student_id)&& null !=student_id){
            sql+=" and student_id=?";
            params.add(student_id);
        }
        if(!"".equals(doctor_id)&& null !=doctor_id){
            sql+=" and doctor_id=?";
            params.add(doctor_id);
        }
        if(!"".equals(teacher_id)&& null !=teacher_id){
            sql+=" and teacher_id=?";
            params.add(teacher_id);
        }


        List<Report> Report=null;

        try {
            Report = queryRunner.query(sql,
                    new BeanListHandler<Report>(Report.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Report;
    }

    @Override
    public void writeSuggestion(String studentId, String suggestion, String time) {
        QueryRunner queryRunner =new QueryRunner(C3P0Util.getDataSource());
        String sql = "update report set diagnose_message = ? where student_id = ?";

        try {
            queryRunner.update(sql,suggestion,studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertNewRepo(String student_id, String doctor_id,String teacher_id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into report (student_id,doctor_id,teacher_id) value (?,?,?)";

        try {
            queryRunner.update(sql,student_id,doctor_id,teacher_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTotalNum(String repo_id, String student_name, String student_sex, String age, String phone_number, String teacher_name, String phone, String diagnose_Message, String case_description, String report_Date, String student_id, String teacher_id, String doctor_id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<String> params = new ArrayList<>();


        String sql= "select count(1) from report where 1=1";
        if(!"".equals(student_id)&& null !=student_id){
            sql+=" and student_id=?";
            params.add(student_id);
        }
        if(!"".equals(doctor_id)&& null !=doctor_id){
            sql+=" and doctor_id=?";
            params.add(doctor_id);
        }
        if(!"".equals(teacher_id)&& null !=teacher_id){
            sql+=" and teacher_id=?";
            params.add(teacher_id);
        }


        int totalNum = 0;
        try {
            totalNum = queryRunner.query(sql,
                    new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalNum;
    }
}
