package project.servlet;//package project.servlet;
//
//import project.service.Impl.StuAppoServiceImp;
//import project.service.StuAppoService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////更新学生预约请求--修改预约表
//@WebServlet("/UpdateAppo")
//public class UpdateStuAppo extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String appointmentId=req.getParameter("appointmentId");
//
//        String appointmentTime=req.getParameter("appointmentTime");
//        String appointmentDate=req.getParameter("appointmentDate");
//
//
//        StuAppoService updateStuAppoService= new StuAppoServiceImp();
//
//        int flag = updateStuAppoService.updateappointmentList(appointmentId, appointmentTime, appointmentDate);
//
//
//    }
//}
