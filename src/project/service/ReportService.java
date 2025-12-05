package project.service;

import project.entity.Report;

import java.util.List;

public interface ReportService {

    List<Report> Report(String repo_id,
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
                        );
    void writeSuggestion(String studentId,String suggestion,String time);

    void insertNewRepo(String student_id, String doctor_id,String teacher_id);

    int getTotalNum(String repo_id,
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
                    String doctor_id);
}
