package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.ResponseMessage;
import project.entity.Teacher;
import project.service.Impl.TeacherServiceImpl;
import project.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//lxj
@WebServlet("/getTeacherList")
public class AdminTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息

        resp.setContentType("application/json;charset=UTF-8");

        String id = req.getParameter("teacherId");
        String className = req.getParameter("className");
       // int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        PageBean pageBean = new PageBean();
       // pageBean.setPageNum(pageNum);

        try {
            TeacherService teacherService = new TeacherServiceImpl();
            List<Teacher> teacherList = teacherService.getTeacherList(id,className);
            pageBean.setData(teacherList);

            int total = teacherService.getTotalNum(id,className);
            pageBean.setTotalNum(total);

            //封装所有的页数信息
            String json = JSON.toJSONString(pageBean);
            resp.getWriter().write(json);
        }catch (Exception e){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("数据库错误");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
