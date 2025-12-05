package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.Cases;
import project.entity.PageBean;
import project.service.CasesService;
import project.service.Impl.CasesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getCases")
public class CaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");

        String studentId = req.getParameter("studentId");
        String doctorId = req.getParameter("doctorId");

        CasesService casesService = new CasesServiceImpl();

        List<Cases> list = new ArrayList<>();

        list=casesService.getCases(studentId,doctorId,null);

        PageBean pageBean = new PageBean();
        pageBean.setTotalNum(casesService.getTotalNum(studentId,doctorId,null));
        pageBean.setData(list);
        String json = JSON.toJSONString(pageBean);
        resp.getWriter().write(json);





    }
}
