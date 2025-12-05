package project.servlet;//package project.servlet;
//
//import project.entity.Appointment;
//import project.service.Impl.StuAppoServiceImp;
//import project.service.StuAppoService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/getStuAppo")
//public class getStuAppo extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String appointmentId = req.getParameter("appointmentId");
//
//        StuAppoService stuAppoService = new StuAppoServiceImp();
//        List<Appointment> list = stuAppoService.getappointmentList(appointmentId);
//        //响应用户
//        for (Appointment appointment : list) {
//            System.out.println((appointment.toString()).valueOf(appointment)+"</br>");
//
//        }
//    }
//}
