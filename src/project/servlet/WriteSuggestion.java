package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.service.Impl.ReportServiceImpl;
import project.service.ReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateReportForm")
public class WriteSuggestion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String studentId = req.getParameter("studentId");
        //写入的建议
        String suggestion = req.getParameter("diagnose_message");
        String time = req.getParameter("time");

        ResponseMessage responseMessage = new ResponseMessage();

        try {
            ReportService reportService = new ReportServiceImpl();
            reportService.writeSuggestion(studentId,suggestion,time);
            responseMessage.setResponse("写入成功");
        }
        catch (Exception e){
            responseMessage.setResponse("写入失败");
        }

        String json = JSON.toJSONString(responseMessage);
        resp.getWriter().write(json);
    }
}
