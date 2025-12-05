package project.entity;

public class ReportForm {
    private String student_Id;
    private String  teacher_Id;
    private String  doctor_Id;
    private String diagnose_Message;
    private String report_Date;
    private String repo_id;

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    public String getTeacher_Id() {
        return teacher_Id;
    }

    public void setTeacher_Id(String teacher_Id) {
        this.teacher_Id = teacher_Id;
    }

    public String getDoctor_Id() {
        return doctor_Id;
    }

    public void setDoctor_Id(String doctor_Id) {
        this.doctor_Id = doctor_Id;
    }

    public String getDiagnose_Message() {
        return diagnose_Message;
    }

    public void setDiagnose_Message(String diagnose_Message) {
        this.diagnose_Message = diagnose_Message;
    }

    public String getReport_Date() {
        return report_Date;
    }

    public void setReport_Date(String report_Date) {
        this.report_Date = report_Date;
    }

    public String getRepo_id() {
        return repo_id;
    }

    public void setRepo_id(String repo_id) {
        this.repo_id = repo_id;
    }

    @Override
    public String toString() {
        return "ReportForm{" +
                "student_Id='" + student_Id + '\'' +
                ", teacher_Id='" + teacher_Id + '\'' +
                ", doctor_Id='" + doctor_Id + '\'' +
                ", diagnose_Message='" + diagnose_Message + '\'' +
                ", report_Date='" + report_Date + '\'' +
                ", repo_id='" + repo_id + '\'' +
                '}';
    }
}
