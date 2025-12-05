package project.entity;

import java.util.Date;

public class RepoForm {
    private String studentId;

    private String teacherId;

    private String doctorId;

    private String diagnoseMessage;

    private Date reportDate;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnoseMessage() {
        return diagnoseMessage;
    }

    public void setDiagnoseMessage(String diagnoseMessage) {
        this.diagnoseMessage = diagnoseMessage;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}
