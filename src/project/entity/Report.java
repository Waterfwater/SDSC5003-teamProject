package project.entity;

public class Report {
    private String repo_id;
    private String student_name;
    private String student_sex;
    private String age;
    private String phone_number;
    private String teacher_name;
    private String phone;
    private String diagnose_Message;
    private String case_description;
    private String report_Date;
    private String student_id;
    private String teacher_id;
    private String doctor_id;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Override
    public String toString() {
        return "Report{" +
                "repo_id='" + repo_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", age='" + age + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", phone='" + phone + '\'' +
                ", diagnose_Message='" + diagnose_Message + '\'' +
                ", case_description='" + case_description + '\'' +
                ", report_Date='" + report_Date + '\'' +
                '}';
    }

    public String getRepo_id() {
        return repo_id;
    }

    public void setRepo_id(String repo_id) {
        this.repo_id = repo_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiagnose_Message() {
        return diagnose_Message;
    }

    public void setDiagnose_Message(String diagnose_Message) {
        this.diagnose_Message = diagnose_Message;
    }

    public String getCase_description() {
        return case_description;
    }

    public void setCase_description(String case_description) {
        this.case_description = case_description;
    }

    public String getReport_Date() {
        return report_Date;
    }

    public void setReport_Date(String report_Date) {
        this.report_Date = report_Date;
    }
}
