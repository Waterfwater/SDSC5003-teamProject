package project.entity;

public class Admin {

    private String admin_id;
    private String username;
    private String password;
    private String email;

    // 构造函数、Getter 和 Setter 方法省略

    // 默认构造函数
    public Admin() {
    }

    // 构造函数
    public Admin(String adminId, String username, String password, String fullName, String email) {
        this.admin_id = adminId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

