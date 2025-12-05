package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.CasesDao;
import project.entity.CaseForC3P0;
import project.entity.Cases;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasesDaoImpl implements CasesDao {
    @Override
    public List<Cases> Cases(String student_id,String doctor_id, String teacher_id) {

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<Object> params = new ArrayList<>();

        String sql = "select * from cases where 1=1";
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

//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        List<Cases> casesList = new ArrayList<>();
        try {
            casesList = queryRunner.query(sql,
                    new BeanListHandler<Cases>(Cases.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return casesList;
    }

    @Override
    public int getTotalNum(String studentId, String doctorId, String teacherId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<Object> params = new ArrayList<>();

        String sql = "select count(1) from cases where 1=1";
        if(!"".equals(studentId)&& null !=studentId){
            sql+=" and student_id=?";
            params.add(studentId);
        }
        if(!"".equals(doctorId)&& null !=doctorId){
            sql+=" and doctor_id=?";
            params.add(doctorId);
        }
        if(!"".equals(teacherId)&& null !=teacherId){
            sql+=" and teacher_id=?";
            params.add(teacherId);
        }

//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        int num = 0;
        try {
            num = queryRunner.query(sql,
                    new ScalarHandler<Long>(),params.toArray()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }

    @Override
    public void writeCases(String studentId, String caseDescription, String diagnosedMessage, String diagnosticTime, int diagnosticNum, String diagnosticDate) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "update cases set case_description = ? ,diagnostic_des = ?,diagnostic_time = ?,diagnostic_date = ?,diagnostic_num = ? where student_id = ?" ;

        //插入数据
        try {
            queryRunner.update(sql,caseDescription,diagnosedMessage,diagnosticTime,diagnosticDate,diagnosticNum,studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int searchTimes(String studentId) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        int num = 0;
        try {
            //查询记录条数
            num = queryRunner.query("select count(1) from cases where student_id =?",new ScalarHandler<Long>(),studentId).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public CaseForC3P0 searchNewestCase(String studentId, int num) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from cases where student_id = ? and diagnostic_num = ?";
        CaseForC3P0 cases = null;
        try {
            cases = queryRunner.query(sql,new BeanHandler<CaseForC3P0>(CaseForC3P0.class),studentId,num);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cases;
    }

//    @Override
//    public List<Cases> getCases(String studentId) {
//        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
//        String sql = "select * from cases where "
//    }
}
