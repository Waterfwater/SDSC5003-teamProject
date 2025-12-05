package project.entity;

public class Student {

    private String studentId;
    private String studentName;
    private String studentPwd;
    private String studentSex;
    private int age;
    private String majorClass;
    private String phoneNumber;
    private String idCardNum;

    public Student() {
        // 默认构造函数
    }

    // 构造函数
    public Student(String studentId, String studentName, String studentSex, int age, String majorClass, String phoneNumber, String idCardNum) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.age = age;
        this.majorClass = majorClass;
        this.phoneNumber = phoneNumber;
        this.idCardNum = idCardNum;
    }
//    public void setPropertiesFromMap(Map<String, ?> map) {
//        if (map.containsKey("studentId")) {
//            this.studentId = map.get("studentId");
//        }
//        if (map.containsKey("studentName")) {
//            this.studentName = map.get("studentName");
//        }
//        if (map.containsKey("age")) {
//            try {
//                this.age = Integer.parseInt(map.get("age"));
//            } catch (NumberFormatException e) {
//                // 处理转换失败的情况
//                e.printStackTrace();
//            }
//            if (map.containsKey("studentPwd")) {
//                this.studentName = map.get("studentPwd");
//            } if (map.containsKey("studentSex")) {
//                this.studentName = map.get("studentSex");
//            } if (map.containsKey("studentPwd")) {
//                this.studentName = map.get("majorClass");
//            } if (map.containsKey("majorClass")) {
//                this.studentName = map.get("studentPwd");
//            }  if (map.containsKey("majorClass")) {
//                this.studentName = map.get("phoneNumber");
//            }  if (map.containsKey("idCardNum")) {
//                this.studentName = map.get("idCardNum");
//            }
//
//        }
//        // 设置其他属性...
//    }
    // Getters and Setters

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajorClass() {
        return majorClass;
    }

    public void setMajorClass(String majorClass) {
        this.majorClass = majorClass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }
    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }
}
