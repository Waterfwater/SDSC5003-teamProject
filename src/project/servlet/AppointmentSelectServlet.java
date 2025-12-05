package project.servlet;

import com.alibaba.fastjson.JSON;
import project.entity.AppointmentShow;
import project.entity.PageBean;
import project.entity.ResponseMessage;
import project.service.AppointmentShowService;
import project.service.Impl.AppointmentShowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//cmy
@WebServlet("/appointmentSearch")
public class AppointmentSelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8082"); // 允许任何来源
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方式
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); // 允许的头信息
        resp.setContentType("application/json;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String type = req.getParameter("type");
        String id = req.getParameter("id_data");
//        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        PageBean pageBean = new PageBean();
        //pageBean.setPageNum(pageNum);

        AppointmentShowService appointmentService = new AppointmentShowServiceImpl();
        List<AppointmentShow> list = null;
        try {
            list = appointmentService.get_AppointmentShowList(type,id);
            if(list.isEmpty()){
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setResponse("暂时没有查到该账号的表单噢");
                throw new ServletException();
            }else {
                int total = appointmentService.getTotalNum(type,id);
                pageBean.setTotalNum(total);
//                pageBean.setTotalPage((int) Math.ceil(total*1.0/pageBean.getPageSize()));
                pageBean.setData(list);
                String json = JSON.toJSONString(pageBean);
                resp.getWriter().write(json);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException();
        }

//        String jsonList = JSON.toJSONString(list);
//        resp.getWriter().write(jsonList);
    }
}
