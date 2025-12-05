package project.service;

import project.entity.AppointmentShow;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentShowService {
    public List<AppointmentShow> get_AppointmentShowList(String type,String id) throws SQLException;//根据某个参数搜索数据列表

    int getTotalNum(String type, String id);
}
