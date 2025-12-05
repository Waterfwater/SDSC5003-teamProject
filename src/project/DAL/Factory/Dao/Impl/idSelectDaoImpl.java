package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.idSelectDao;
import project.entity.ReportForm;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class idSelectDaoImpl implements idSelectDao {

    //num是起始页号
    @Override
    public List<ReportForm> getFormList(String student_Id, String teacher_Id, String doctor_Id, String diagnose_Message, String report_Date) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<Object> params = new ArrayList<>();

        //检索
        String sql = "select * from report_form where 1=1";
        if(!"".equals(student_Id)&& null !=student_Id){
            sql+=" and student_id=?";
            params.add(student_Id);
        }
        if(!"".equals(teacher_Id)&& null !=teacher_Id){
            sql+=" and teacher_id=?";
            params.add(teacher_Id);
        }
        if(!"".equals(doctor_Id)&& null !=doctor_Id){
            sql+=" and doctor_id=?";
            params.add(doctor_Id);
        }

//        //新增
//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        List<ReportForm> getFormList = new ArrayList<>();
        try {
            getFormList = queryRunner.query(sql,
                    new BeanListHandler<ReportForm>(ReportForm.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getFormList;
    }

    @Override
    public int getTotalNum(String student_Id, String teacher_Id, String doctor_Id, String diagnose_Message, String report_Date) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        List<Object> params = new ArrayList<>();

        String sql = "select count(1) from report_form where 1=1";
        if(!"".equals(student_Id)&& null !=student_Id){
            sql+=" and student_id=?";
            params.add(student_Id);
        }
        if(!"".equals(teacher_Id)&& null !=teacher_Id){
            sql+=" and teacher_id=?";
            params.add(teacher_Id);
        }
        if(!"".equals(doctor_Id)&& null !=doctor_Id){
            sql+=" and doctor_id=?";
            params.add(doctor_Id);
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
