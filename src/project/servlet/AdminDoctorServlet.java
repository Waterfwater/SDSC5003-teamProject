package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.Doctor;
import project.entity.PageBean;
import project.entity.ResponseMessage;
import project.service.DoctorService;
import project.service.Impl.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//xyz
@WebServlet("/getDoctorList")
public class AdminDoctorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String id =req.getParameter("doctorId");

//        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        PageBean pageBean = new PageBean();
//        pageBean.setPageNum(pageNum);
        try {
            DoctorService adminService = new DoctorServiceImpl();
            List<Doctor> docList = adminService.getDoctorList(id);
            req.setAttribute("docList",docList);
            //转发到前端
            int total = adminService.getTotalNum(id);
            pageBean.setTotalNum(total);
//            pageBean.setTotalPage((int) Math.ceil(total*1.0/pageBean.getPageSize()));
            pageBean.setData(docList);
            String json = JSON.toJSONString(pageBean);
            resp.getWriter().write(json);
        }catch (Exception e){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("暂时没有查到表单");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
