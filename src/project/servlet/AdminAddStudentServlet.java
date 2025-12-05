package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import project.service.Impl.StudentServiceImpl;
import project.service.StudentService;
@WebServlet("/registerStu")
public class AdminAddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");

        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        int age = Integer.parseInt(req.getParameter("age")); // Assuming age is an integer
        String majorClass = req.getParameter("majorClass");
        String studentSex = req.getParameter("studentSex");
        String idCardNum = req.getParameter("idCardNum");
        String phoneNumber = req.getParameter("phoneNumber");
        String studentPwd = req.getParameter("studentPwd");

        try {
            Student addStudent = new Student();
            addStudent.setStudentId(studentId);
            addStudent.setStudentName(studentName);
            addStudent.setAge(age);
            addStudent.setMajorClass(majorClass);
            addStudent.setStudentSex(studentSex);
            addStudent.setIdCardNum(idCardNum);
            addStudent.setPhoneNumber(phoneNumber);
            addStudent.setStudentPwd(studentPwd);
            StudentService adminService = new StudentServiceImpl();
            adminService.addStudent(addStudent);

            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("添加成功");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }catch (Exception e){
            e.printStackTrace();
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("添加失败");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }
    }
}
