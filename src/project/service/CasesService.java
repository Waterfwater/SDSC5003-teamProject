package project.service;

import project.entity.Cases;

import java.util.List;

public interface CasesService {
    void writeCases(String studentId,String casesDescription,String diagnosticMessage,String diagnosticTime,String diagnosticDate);

    int searchDiagnosticTime(String studentId);

    List<Cases> getCases(String studentId,String doctorId,String teacherId);

    int getTotalNum(String studentId,String doctorId,String teacherId);

}
