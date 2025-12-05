package project.DAL.Factory.Dao;

import project.entity.ReportForm;

import java.util.List;

public interface idSelectDao {
    List<ReportForm> getFormList(String student_Id, String teacher_Id, String doctor_Id, String diagnose_Message, String report_Date);

    int getTotalNum(String student_Id, String teacher_Id, String doctor_Id, String diagnose_Message, String report_Date);
}
