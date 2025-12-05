package project.service.Impl;

import project.DAL.Factory.Dao.Impl.AppointmentShowDaoImpl;
import project.entity.AppointmentShow;
import project.entity.AppointmentShowReal;
import project.service.AppointmentShowService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AppointmentShowServiceImpl implements AppointmentShowService {
    List<AppointmentShowReal> list = new ArrayList<>();
    @Override
    public List<AppointmentShow> get_AppointmentShowList(String type,String id) throws SQLException {

        //让list进入不同的分支
     if("student".equals(type)){
            list = new AppointmentShowDaoImpl().selectFromStudent(id);
        }
        else if("doctor".equals(type)){
            list = new AppointmentShowDaoImpl().selectFromDoctor(id);
        }else if("admin".equals(type)){
            list = new AppointmentShowDaoImpl().Select();
     }



        //清洗数据，把时间戳转换回时间字符串
        List<AppointmentShow> list2=new ArrayList<>();
        for (AppointmentShowReal ap:list){
            AppointmentShow show=new AppointmentShow();
            show.setDoctor_name(ap.getDoctor_name());
            show.setStudent_name(ap.getStudent_name());
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String Date = sdf1.format(ap.getAppointment_date());
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            String Time = sdf2.format(ap.getAppointment_time());
            show.setAppointment_date(Date);
            show.setAppointment_time(Time);
            list2.add(show);
        }
        return list2;
    }

    @Override
    public int getTotalNum(String type, String id) {

        int num = 0;
        //让list进入不同的分支
        if(null==type) {
            num = new AppointmentShowDaoImpl().getTotalNum();
        }
        else if("student".equals(type)){
            num = new AppointmentShowDaoImpl().getTotalNumFromStuId(id);
        }
        else if("doctor".equals(type)){
            num = new AppointmentShowDaoImpl().getTotalNumFromDocId(id);
        }
        else if("admin".equals(type)){
            num = new AppointmentShowDaoImpl().getTotalNum();
        }
        return num;
    }
}
