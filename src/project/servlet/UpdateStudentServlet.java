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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("id") != null) {
            // 获取登录用户的学生ID
            String studentId = (String) session.getAttribute("id");


            String studentName = request.getParameter("studentName");

            ResponseMessage responseMessage = new ResponseMessage();

            int age = Integer.parseInt(request.getParameter("age")); // Assuming age is an integer
            String majorClass = request.getParameter("majorClass");
            String studentSex = request.getParameter("studentSex");
            String idCardNum = request.getParameter("idCardNum");
            String phoneNumber = request.getParameter("phoneNumber");
            String studentPwd = request.getParameter("studentPwd");

            Student updatedStudent = new Student();
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