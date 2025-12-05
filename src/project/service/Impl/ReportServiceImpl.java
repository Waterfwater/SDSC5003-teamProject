package project.service.Impl;

import project.DAL.Factory.Dao.Impl.CasesDaoImpl;
import project.DAL.Factory.Dao.Impl.ReportDaoImpl;
import project.DAL.Factory.Dao.ReportDao;
import project.DAL.Factory.ReportDaoFactory;
import project.entity.Cases;
import project.entity.Report;
import project.service.ReportService;

import java.util.Collections;
import java.util.List;


//这是表单查询+生成
public class ReportServiceImpl implements ReportService {
    private static ReportDao reportDao= ReportDaoFactory.getReportDaoInstance();

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
                               String doctor_id
                               ) {
        CasesDaoImpl casesDaoImpl = new CasesDaoImpl();
        //查询cases表单
        //这里可能会返回若干个表单
        List<Cases> list = casesDaoImpl.Cases(student_id,doctor_id,teacher_id);
        ReportDao reportDao = new ReportDaoImpl();
        if (list.isEmpty() ) {
        //如果填写完整生成新的reportForm
            //没有查询到
            return Collections.emptyList();

        }else
        {

            //这个是查询最终表单的结果
            return reportDao.Report(repo_id,
                    student_name,
                    student_sex,
                    age,
                    phone_number,
                    teacher_name,
                    phone,
                    diagnose_Message,
                    case_description,
                    report_Date,
                    student_id,
                    teacher_id,
                    doctor_id);
        }
    }

    @Override
    public void writeSuggestion(String studentId, String suggestion, String time) {
        reportDao.writeSuggestion(studentId,suggestion,time);
    }

    @Override
    public void insertNewRepo(String student_id, String doctor_id,String teacher_id) {
        reportDao.insertNewRepo(student_id,doctor_id,teacher_id);
    }

    @Override
    public int getTotalNum(String repo_id, String student_name, String student_sex, String age, String phone_number, String teacher_name, String phone, String diagnose_Message, String case_description, String report_Date, String student_id, String teacher_id, String doctor_id) {
        return reportDao.getTotalNum(repo_id,student_name,student_sex,age,phone_number,teacher_name, phone,diagnose_Message,case_description,report_Date,student_id,teacher_id,doctor_id);
    }
}
