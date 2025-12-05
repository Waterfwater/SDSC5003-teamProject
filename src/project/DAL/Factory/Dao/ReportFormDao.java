package project.DAL.Factory.Dao;

import project.entity.ReportForm;

import java.util.List;

public interface ReportFormDao {
    List<ReportForm> getReportFormList(String repo_id,String student_Id,String teacher_Id,String doctor_Id,String diagnose_Message,String report_Date,int num);
}
