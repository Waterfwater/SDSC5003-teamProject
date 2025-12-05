package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.PageBean;
import project.entity.Report;
import project.entity.ResponseMessage;
import project.service.Impl.ReportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//lxj
@WebServlet("/getReport")
public class ReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");

        String repo_id = req.getParameter("repo_id");
        String student_name = req.getParameter("student_name");
        String student_sex = req.getParameter("student_sex");
        String age = req.getParameter("age");
        String phone_number = req.getParameter("phone_number");
        String teacher_name = req.getParameter("teacher_name");
        String phone = req.getParameter("phone");
        String diagnose_Message = req.getParameter("diagnose_Message");
        String case_description = req.getParameter("case_description");
        String report_Date = req.getParameter("report_Date");
        String student_id = req.getParameter("student_id");
        String teacher_id = req.getParameter("teacher_id");
        String doctor_id = req.getParameter("doctor_id");

        //int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        PageBean pageBean = new PageBean();
        //pageBean.setPageNum(pageNum);

        try {
            ReportServiceImpl reportService = new ReportServiceImpl();
            List<Report> list = reportService.Report(
                    repo_id, student_name, student_sex, age,
                    phone_number, teacher_name, phone,
                    diagnose_Message, case_description,
                    report_Date, student_id, teacher_id, doctor_id
            );


            if (list == null || list.isEmpty()) {
                pageBean.setTotalNum(0);
                pageBean.setData(new ArrayList<>());   // 返回空列表
            } else {
                int total = reportService.getTotalNum(
                        repo_id, student_name, student_sex, age,
                        phone_number, teacher_name, phone,
                        diagnose_Message, case_description,
                        report_Date, student_id, teacher_id, doctor_id
                );
                pageBean.setTotalNum(total);
                pageBean.setData(list);
            }

            String json = JSON.toJSONString(pageBean);
            resp.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            // 出错也要保持返回结构一致
            pageBean.setTotalNum(0);
            pageBean.setData(new ArrayList<>());
            String json = JSON.toJSONString(pageBean);
            resp.getWriter().write(json);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}


