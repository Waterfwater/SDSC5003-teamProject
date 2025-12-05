package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.service.Impl.ScheduleServiceImpl;
import project.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/manageSchedules")
public class ManageSchedulesServlet extends HttpServlet {
    //新增工作时段
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");

        String doctorId = req.getParameter("doctorId");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ScheduleService service = new ScheduleServiceImpl();
            service.writeSchedule(doctorId, date, time);
            responseMessage.setResponse("新建成功");
        } catch (Exception e) {
            responseMessage.setResponse("新建失败 服务器错误");
        }

        String json = JSON.toJSONString(responseMessage);
        resp.getWriter().write(json);

    }
}
