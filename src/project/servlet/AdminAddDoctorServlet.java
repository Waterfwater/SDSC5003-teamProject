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
import java.io.IOException;
@WebServlet("/registerDoc")
public class AdminAddDoctorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String doctorId = req.getParameter("id");
        String doctorName = req.getParameter("doctorName");
        int age = Integer.parseInt(req.getParameter("age")); // Assuming age is an integer
        String department = req.getParameter("department");
        String doctorSex = req.getParameter("doctorSex");
        String title = req.getParameter("title");
        String phoneNumber = req.getParameter("phoneNumber");
        String doctorPwd = req.getParameter("doctorPwd");
        String headofdepartment = req.getParameter("headofdepartment");

        try {

            Doctor addDoctor = new Doctor();
            addDoctor.setDoctor_id(doctorId);
            addDoctor.setDoctor_name(doctorName);
            addDoctor.setAge(age);
            addDoctor.setDepartment(department);
            addDoctor.setDoctor_sex(doctorSex);
            addDoctor.setTitle(title);
            addDoctor.setPhone_number(phoneNumber);
            addDoctor.setDoctor_pwd(doctorPwd);
            addDoctor.setHead_of_department(headofdepartment);

            DoctorService adminService = new DoctorServiceImpl();
            adminService.addDoctor(addDoctor);

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
