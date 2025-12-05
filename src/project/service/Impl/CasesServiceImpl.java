package project.service.Impl;

import project.DAL.Factory.CasesDaoFactory;
import project.DAL.Factory.Dao.CasesDao;
import project.DAL.Factory.Dao.Impl.StudentClassTeacherDaoImpl;
import project.DAL.Factory.Dao.StudentClassTeacherDao;
import project.entity.CaseForC3P0;
import project.entity.Cases;
import project.entity.StudentClassTeacher;
import project.service.CasesService;
import project.service.ReportService;

import java.util.List;

public class CasesServiceImpl implements CasesService {
    private static CasesDao casesDao = CasesDaoFactory.getCasesDaoInstance();
    @Override
    public void writeCases(String studentId, String casesDescription, String diagnosticMessage, String diagnosticTime, String diagnosticDate) {
        int num = 0;
        num = this.searchDiagnosticTime(studentId)+1;
        casesDao.writeCases(studentId,casesDescription,diagnosticMessage,diagnosticTime,num,diagnosticDate);
        CaseForC3P0 cases = casesDao.searchNewestCase(studentId,num);
        if(null!=cases.getCase_description()&&null!=cases.getDiagnostic_des()){
            //先查找老师id
            StudentClassTeacher studentClassTeacher = new StudentClassTeacher();
            StudentClassTeacherDao studentClassTeacherDao = new StudentClassTeacherDaoImpl();
            studentClassTeacher = studentClassTeacherDao.getStudentClassTeacher(studentId,null);
            String teacher_id = studentClassTeacher.getTeacher_id();
            //写入之后生成一个新reportForm
            ReportService reportService = new ReportServiceImpl();
            reportService.insertNewRepo(cases.getStudent_id(),cases.getDoctor_id(),teacher_id);
        }


    }

    @Override
    public int searchDiagnosticTime(String studentId) {
        return casesDao.searchTimes(studentId);
    }

    @Override
    public List<Cases> getCases(String studentId, String doctorId, String teacherId) {
        return casesDao.Cases(studentId,doctorId,teacherId);
    }

    @Override
    public int getTotalNum(String studentId, String doctorId, String teacherId) {
        return casesDao.getTotalNum(studentId,doctorId,teacherId);
    }
}
