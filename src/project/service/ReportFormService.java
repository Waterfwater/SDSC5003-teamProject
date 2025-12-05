package project.service;

import project.entity.ReportForm;

import java.util.List;

public interface ReportFormService {
    List<ReportForm> getReportFormList(String repo_id,String student_Id,String teacher_Id,String doctor_Id,String diagnose_Message,String report_Date,int num);
}
