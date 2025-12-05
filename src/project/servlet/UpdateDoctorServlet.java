package project.servlet;


import com.alibaba.fastjson.JSON;
import project.entity.Doctor;
import project.entity.ResponseMessage;
import project.service.DoctorService;
import project.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateDoctor")
public class UpdateDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("id") != null) {
            // 获取登录用户的学生ID
            String doctorId = (String) session.getAttribute("id");
            String doctorName = request.getParameter("doctorName");
            int age = Integer.parseInt(request.getParameter("age")); // Assuming age is an integer
            String department = request.getParameter("department");
            String doctorSex = request.getParameter("doctorSex");
            String title = request.getParameter("title");
            String phoneNumber = request.getParameter("phoneNumber");
            String doctorPwd = request.getParameter("doctorPwd");

            ResponseMessage responseMessage = new ResponseMessage();


            Doctor updatedDoctor = new Doctor();
            updatedDoctor.setDoctor_id(doctorId);
            updatedDoctor.setDoctor_name(doctorName);
            updatedDoctor.setAge(age);
            updatedDoctor.setDepartment(department);
            updatedDoctor.setDoctor_sex(doctorSex);
            updatedDoctor.setTitle(title);
            updatedDoctor.setPhone_number(phoneNumber);
            updatedDoctor.setDoctor_pwd(doctorPwd);

            DoctorService doctorService = new DoctorServiceImpl();
            boolean success = false;
            try {
                success = doctorService.updateDoctorInfo(updatedDoctor);
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
