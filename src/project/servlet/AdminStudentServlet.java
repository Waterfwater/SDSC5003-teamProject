package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.ResponseMessage;
import project.entity.Student;
import project.entity.StudentForC3p0;
import project.service.Impl.StudentServiceImpl;
import project.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//xyz
@WebServlet("/getStudentList")
public class AdminStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");

        String id = req.getParameter("studentId");
        StudentService adminService = new StudentServiceImpl();

//        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        PageBean pageBean = new PageBean();
//        pageBean.setPageNum(pageNum);
        try {
            List<StudentForC3p0> stuList = adminService.getStudentList(id);
            int total = adminService.getTotalNum(id);
            pageBean.setTotalNum(total);
            pageBean.setData(stuList);

            //封装所有的页数信息
            String json = JSON.toJSONString(pageBean);
            resp.getWriter().write(json);
            //转发到前端
        }catch (Exception e){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("数据库出错");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }
    }

}
