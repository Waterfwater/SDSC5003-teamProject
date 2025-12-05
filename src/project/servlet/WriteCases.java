package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.ResponseMessage;
import project.service.CasesService;
import project.service.Impl.CasesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateCases")
public class WriteCases extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String studentId = req.getParameter("studentId");
        String caseDescription = req.getParameter("description");
        String diagnosticMessage = req.getParameter("diagnosticMessage");
        String date = req.getParameter("Date");
        System.out.println(date);
        String time = req.getParameter("Time");
        System.out.println(time);
        ResponseMessage responseMessage = new ResponseMessage();

        //参数拦截前端来写
        try {
            CasesService casesService = new CasesServiceImpl();
            casesService.writeCases(studentId, caseDescription, diagnosticMessage, time, date);
            responseMessage.setResponse("写入成功!");
        }catch (Exception e){
            e.printStackTrace();
            responseMessage.setResponse("服务器出错，写入失败");
        }

        String json = JSON.toJSONString(responseMessage);
        resp.getWriter().write(json);

    }
}
