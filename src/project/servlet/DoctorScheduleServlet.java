package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.Schedule;
import project.entity.ScheduleForDoctor;
import project.service.Impl.ScheduleServiceImpl;
import project.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//lyx
@WebServlet("/doctorSchedule")
public class DoctorScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String date = req.getParameter("date");
        //不接受时间作为参数
        String time = req.getParameter("time");

        PageBean pageBean = new PageBean();

        ScheduleService service = new ScheduleServiceImpl();
        //输入时间以查询医生列表（返回一个视图列表版本）
        List<ScheduleForDoctor> list =  service.getDoctorList(date,time);
        int total = service.getScheduleTotalNum(date,time);
        pageBean.setTotalNum(total);
        pageBean.setData(list);

        String json = JSON.toJSONString(pageBean);
        resp.getWriter().write(json);
        resp.setStatus(200);
    }
}
