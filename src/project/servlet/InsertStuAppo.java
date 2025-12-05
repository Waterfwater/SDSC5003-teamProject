package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.service.Impl.StuAppoServiceImp;
import project.service.StuAppoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertAppo")
public class InsertStuAppo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String appointmentId = req.getParameter("appointmentId");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String studentId = req.getParameter("studentId");
        String doctorId = req.getParameter("doctorId");
        String appointmentTime = req.getParameter("appointmentTime");
        String appointmentDate = req.getParameter("appointmentDate");

        try {
            StuAppoService stuAppoService = new StuAppoServiceImp();

            int flag = stuAppoService.insertappointmentList(studentId, doctorId, appointmentTime, appointmentDate);

            int flag2 = stuAppoService.newDiagnoseForm(doctorId, studentId);
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("预约成功！已成功生成病历");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }catch (Exception e){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("新建失败");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }
    }
}
