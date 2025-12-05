package project.DAL.Factory.Dao.Impl;//package project.DAL.Factory.Dao.Impl;
//
//import org.apache.commons.dbutils.*;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//import project.DAL.Factory.Dao.ReportFormDao;
//import project.entity.ReportForm;
//import project.util.C3P0Util;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReportFormDaoImpl implements ReportFormDao {
//    @Override
//    public List<ReportForm> getReportFormList(String repo_id,String student_Id,String teacher_Id,String doctor_Id,String diagnose_Message,String report_Date){
//        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
//        List<String> params = new ArrayList<>();
//
//        List<ReportForm> ReportFormList = null;
//        try {
//            BeanProcessor beanProcessor = new GenerousBeanProcessor();
//            RowProcessor processor = new BasicRowProcessor(beanProcessor);
//            ReportFormList = queryRunner.query( "select * from report_form",
//                        new BeanListHandler<>(ReportForm.class));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return ReportFormList;
//    }
//}
