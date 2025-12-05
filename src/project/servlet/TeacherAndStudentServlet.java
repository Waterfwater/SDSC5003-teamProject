package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.ResponseMessage;
import project.entity.StudentClassTeacher;
import project.entity.TeacherAndStudent;
import project.service.Impl.TeacherServiceImpl;
import project.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/getStudentByTeacher")
public class TeacherAndStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        String teacherId = req.getParameter("teacherId");

        TeacherService teacherService = new TeacherServiceImpl();
        List<TeacherAndStudent> list = new ArrayList<>();
        try {
            list=teacherService.getStudentList(teacherId);
            PageBean pageBean = new PageBean();
            pageBean.setData(list);
            pageBean.setTotalNum(teacherService.getTotalNumByTeacher(teacherId));
            String json = JSON.toJSONString(pageBean);
            resp.getWriter().write(json);
        }catch (Exception e){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("出错了");
            String json = JSON.toJSONString(responseMessage);
            resp.getWriter().write(json);
        }


    }
}
