package project.service.Impl;


import project.DAL.Factory.Dao.Impl.idSelectDaoImpl;
import project.entity.ReportForm;
import project.service.idSelectService;

import java.util.List;

public class idSelectServiceImpl implements idSelectService {

    @Override
    public List<ReportForm> getFormList(String student_Id, String teacher_Id, String doctor_Id, String diagnose_Message, String report_Date) {
        return new idSelectDaoImpl().getFormList(student_Id,teacher_Id,doctor_Id,diagnose_Message,report_Date);
    }

    @Override
    public int getTotalNum(String student_Id, String teacher_Id, String doctor_Id, String diagnose_Message, String report_Date) {
        return new idSelectDaoImpl().getTotalNum(student_Id,teacher_Id,doctor_Id,diagnose_Message,report_Date);
    }
}
