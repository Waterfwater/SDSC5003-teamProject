package project.DAL.Factory.Dao;

import project.entity.CaseForC3P0;
import project.entity.Cases;

import java.util.List;

public interface CasesDao {
    List<Cases> Cases(
                      String student_id,
                      String doctor_id,
                      String teacher_id
//                      int num,
//                      int pageSize
                     );

    void writeCases(String studentId,String caseDescription,String diagnosedMessage,String diagnosticTime,int diagnosticNum,String diagnosticDate);

    int searchTimes(String studentId);


    CaseForC3P0 searchNewestCase(String studentId, int num);

    int getTotalNum(String studentId, String doctorId, String teacherId);

//    List<Cases> getCases(String studentName);
}
