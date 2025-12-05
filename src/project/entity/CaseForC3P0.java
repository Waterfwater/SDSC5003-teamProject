package project.entity;

import java.sql.Time;
import java.util.Date;

public class CaseForC3P0 {
    private int case_id;
    private String doctor_id;
    private String student_id;
    private String case_description;
    private Date diagnostic_date;
    private Time diagnostic_time;
    private int diagnostic_num;
    private String diagnostic_des;

    public int getCase_id() {
        return case_id;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCase_description() {
        return case_description;
    }

    public void setCase_description(String case_description) {
        this.case_description = case_description;
    }

    public Date getDiagnostic_date() {
        return diagnostic_date;
    }

    public void setDiagnostic_date(Date diagnostic_date) {
        this.diagnostic_date = diagnostic_date;
    }

    public Time getDiagnostic_time() {
        return diagnostic_time;
    }

    public void setDiagnostic_time(Time diagnostic_time) {
        this.diagnostic_time = diagnostic_time;
    }

    public int getDiagnostic_num() {
        return diagnostic_num;
    }

    public void setDiagnostic_num(int diagnostic_num) {
        this.diagnostic_num = diagnostic_num;
    }

    public String getDiagnostic_des() {
        return diagnostic_des;
    }

    public void setDiagnostic_des(String diagnostic_des) {
        this.diagnostic_des = diagnostic_des;
    }
}
