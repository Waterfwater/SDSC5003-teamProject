package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.ReportForm;
import project.entity.ResponseMessage;
import project.service.Impl.idSelectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//cmy
@WebServlet("/idSelect")
public class idSelectServlet extends HttpServlet {

//    @Override
//    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//
//        String student_Id = req.getParameter("student_Id");
//        String teacher_Id = req.getParameter("teacher_Id");
//        String doctor_Id = req.getParameter("doctor_Id");
//        String diagnose_Message = req.getParameter("diagnose_Message");
//        String report_Date = req.getParameter("report_Date");
//
//        idSelectServiceImpl idSelectService = new idSelectServiceImpl();
//        List<ReportForm> list = idSelectService.getFormList(student_Id, teacher_Id, doctor_Id,diagnose_Message,report_Date);
//
//
//
//        String json = JSON.toJSONString(list);
//        resp.getWriter().write(json);
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");


        resp.setContentType("text/html;charset=UTF-8");

        String student_Id = req.getParameter("student_Id");
        String teacher_Id = req.getParameter("teacher_Id");
        String doctor_Id = req.getParameter("doctor_Id");
        String diagnose_Message = req.getParameter("diagnose_Message");
        String report_Date = req.getParameter("report_Date");
        //String pageNum = req.getParameter("pageNum");
        try {
            //try也不要了

            PageBean pageBean = new PageBean();
            //pageBean.setPageNum(pageNum);
            try {
                idSelectServiceImpl idSelectService = new idSelectServiceImpl();
                List<ReportForm> list = idSelectService.getFormList(student_Id, teacher_Id, doctor_Id,diagnose_Message,report_Date);
                if(list.isEmpty()){
                    ResponseMessage responseMessage = new ResponseMessage();
                    responseMessage.setResponse("暂时没有查到该账号的表单噢");
                    String json = JSON.toJSONString(responseMessage);
                    resp.getWriter().write(json);
                }else {
                    int total = idSelectService.getTotalNum(student_Id, teacher_Id, doctor_Id,diagnose_Message,report_Date);
                    pageBean.setTotalNum(total);
//                    pageBean.setTotalPage((int) Math.ceil(total*1.0/pageBean.getPageSize()));
                    pageBean.setData(list);
                    String json = JSON.toJSONString(pageBean);
                    resp.getWriter().write(json);
                }
            }catch (Exception e){

            }
        }catch (Exception e){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setResponse("没有传递页号！");
        }





    }
}
