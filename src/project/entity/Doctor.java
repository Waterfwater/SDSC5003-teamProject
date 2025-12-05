package project.entity;

public class Doctor {
    private String doctor_id;

    private String doctor_name;

    private String doctor_sex;
    private String doctor_pwd;

    private int age;

    private String title;

    private String phone_number;

    private String department;

    private String head_of_department;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_sex() {
        return doctor_sex;
    }

    public void setDoctor_sex(String doctor_sex) {
        this.doctor_sex = doctor_sex;
    }

    public String getDoctor_pwd() {
        return doctor_pwd;
    }

    public void setDoctor_pwd(String doctor_pwd) {
        this.doctor_pwd = doctor_pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHead_of_department() {
        return head_of_department;
    }

    public void setHead_of_department(String head_of_department) {
        this.head_of_department = head_of_department;
    }
}
