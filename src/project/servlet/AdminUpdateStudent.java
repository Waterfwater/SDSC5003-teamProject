package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.entity.Student;
import project.service.Impl.StudentServiceImpl;
import project.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateStu")
public class AdminUpdateStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        response.setContentType("application/json;charset=UTF-8");
        String studentId = request.getParameter("studentId");
        if(null != studentId){
            String studentName = request.getParameter("studentName");
            Student updatedStudent = new Student();
            ResponseMessage responseMessage = new ResponseMessage();

            int age = Integer.parseInt(request.getParameter("age")); // Assuming age is an integer
            String majorClass = request.getParameter("majorClass");
            String studentSex = request.getParameter("studentSex");
            String idCardNum = request.getParameter("idCardNum");
            String phoneNumber = request.getParameter("phoneNumber");
            String studentPwd = request.getParameter("studentPwd");

            updatedStudent.setStudentId(studentId);
            updatedStudent.setStudentName(studentName);
            updatedStudent.setAge(age);
            updatedStudent.setMajorClass(majorClass);
            updatedStudent.setStudentSex(studentSex);
            updatedStudent.setIdCardNum(idCardNum);
            updatedStudent.setPhoneNumber(phoneNumber);
            updatedStudent.setStudentPwd(studentPwd);
            StudentService studentService = new StudentServiceImpl();
            boolean success = false;
            try {
                success = studentService.updateStudentInfo(updatedStudent);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (success) {
                responseMessage.setResponse("修改成功");


            } else {
                responseMessage.setResponse("修改失败");
            }
            String json = JSON.toJSONString(responseMessage);
            response.getWriter().write(json);
        }
    }
}
