package project.servlet;


import com.alibaba.fastjson.JSON;
import project.entity.Doctor;
import project.entity.ResponseMessage;
import project.service.DoctorService;
import project.service.Impl.DoctorServiceImpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/getDoctorInfo")
public class DoctorInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("id") != null) {

            String doctorId = (String) session.getAttribute("id");

            try {

                String action = req.getParameter("action");
                DoctorService doctorService = new DoctorServiceImpl();
                Doctor doctor = doctorService.getDoctorInfoById(doctorId);
                req.setAttribute("doctor", doctor);

                    JSONObject jsondoctor = new JSONObject();
                    jsondoctor.put("doctorId", doctor.getDoctor_id());
                    jsondoctor.put("doctorName", doctor.getDoctor_name());
                    jsondoctor.put("age", doctor.getAge());
                    jsondoctor.put("department", doctor.getDepartment());
                    jsondoctor.put("doctorSex", doctor.getDoctor_sex());
                    jsondoctor.put("title", doctor.getTitle());
                    jsondoctor.put("phoneNumber", doctor.getPhone_number());
                    // 设置响应内容类型为 JSON
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");

                    // 将 JSON 数据写回到前端

            } catch (SQLException e) {
                e.printStackTrace();
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setResponse("获取医生信息失败");
                String json = JSON.toJSONString(responseMessage);
                resp.getWriter().write(json);
            }
        } else {
            // 用户未登录，重定向到登录页面
            resp.sendRedirect("/login");
        }
    }
}
