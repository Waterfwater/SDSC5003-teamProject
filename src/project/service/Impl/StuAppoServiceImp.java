package project.service.Impl;

import project.DAL.Factory.Dao.CasesDao;
import project.DAL.Factory.Dao.Impl.AppointmentDaoImpl;
import project.DAL.Factory.Dao.ScheduleDao;
import project.DAL.Factory.ScheduleDaoFactory;
import project.entity.Appointment;
import project.service.CasesService;
import project.service.StuAppoService;

import java.util.List;

public class StuAppoServiceImp implements StuAppoService {
    private static ScheduleDao scheduleDao = ScheduleDaoFactory.getScheduleDaoInstance();

    public List<Appointment> getappointmentList(String appointmentId) {

        return new AppointmentDaoImpl().getappointmentList(appointmentId);
    }
    public int updateappointmentList(String appointmentId,String appointmentTime, String appointmentDate){
        return new AppointmentDaoImpl().updateappointmentList(appointmentId,appointmentTime,appointmentDate);
    }

    //创建预约 级联修改医生的值班情况（booking）
    @Override
    public int insertappointmentList(String studentId, String doctorId, String appointmentTime, String appointmentDate) {
        //修改医生的值班信息
        scheduleDao.book(doctorId,appointmentDate,appointmentTime);
        //创建预约表单
        return new AppointmentDaoImpl().insertappointmentList(studentId,doctorId,appointmentTime,appointmentDate);

    }

    @Override
    public int newDiagnoseForm(String doctorId, String studentId) {
        int num = 1;//初始值
        CasesService casesService = new CasesServiceImpl();
        num = casesService.searchDiagnosticTime(studentId)+1;
        return new AppointmentDaoImpl().newDiagnoseForm(doctorId,studentId,num);
    }
}
