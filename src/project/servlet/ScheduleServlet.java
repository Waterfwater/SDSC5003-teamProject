package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.ReportForm;
import project.entity.ResponseMessage;
import project.entity.Schedule;
import project.service.Impl.ScheduleServiceImpl;
import project.service.Impl.idSelectServiceImpl;
import project.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//lyx
@WebServlet("/Schedules")
public class ScheduleServlet extends HttpServlet {

    //查询所有表单
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("text/html;charset=UTF-8");
        String doctorId = req.getParameter("doctorId");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
//            int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        PageBean pageBean = new PageBean();
//            pageBean.setPageNum(pageNum);
        try {
            ScheduleService service = new ScheduleServiceImpl();
            List<Schedule> list = service.getSchedules(doctorId, date, time);

            if (list.isEmpty()) {
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setResponse("暂时没有查到该账号的表单噢");
                String json = JSON.toJSONString(responseMessage);
                resp.getWriter().write(json);
            } else {
                int total = service.getTotalNum(doctorId, date);
                pageBean.setTotalNum(total);
//                    pageBean.setTotalPage((int) Math.ceil(total*1.0/pageBean.getPageSize()));
                pageBean.setData(list);
                String json = JSON.toJSONString(pageBean);
                resp.getWriter().write(json);
            }
        } catch (Exception e) {

        }
    }
}
