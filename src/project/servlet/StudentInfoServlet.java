package project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.entity.Student;
import project.service.Impl.StudentServiceImpl;
import project.service.StudentService;
import com.alibaba.fastjson.JSONObject;

@WebServlet("/getStudentInfo")
public class StudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("id") != null) {
            // 获取登录用户的学生ID
            String studentId = (String) session.getAttribute("id");


            try {

                String action = req.getParameter("action");
                StudentService studentService = new StudentServiceImpl();
                //查询学生信息
                Student student = studentService.getStudentInfoById(studentId);
                req.setAttribute("student", student);

                // 将学生信息转换为 JSON 格式
                JSONObject jsonStudent = new JSONObject();
                jsonStudent.put("studentId", student.getStudentId());
                jsonStudent.put("studentName", student.getStudentName());
                jsonStudent.put("age", student.getAge());
                jsonStudent.put("majorClass", student.getMajorClass());
                jsonStudent.put("studentSex", student.getStudentSex());
                jsonStudent.put("idCardNum", student.getIdCardNum());
                jsonStudent.put("phoneNumber", student.getPhoneNumber());
                // 设置响应内容类型为 JSON
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");

                // 将 JSON 数据写回到前端
                resp.getWriter().write(jsonStudent.toString());

            } catch (SQLException e) {
//
            }
        } else {
            // 用户未登录，重定向到登录页面
            resp.sendRedirect("/login");
        }
    }
}