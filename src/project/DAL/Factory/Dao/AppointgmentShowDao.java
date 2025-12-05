package project.DAL.Factory.Dao;

import project.entity.AppointmentShowReal;

import java.sql.SQLException;
import java.util.List;

public interface AppointgmentShowDao {
    public List<AppointmentShowReal> Select() throws SQLException;//type指查询的键类型，data指具体值,返回查询的对象列表

    public List<AppointmentShowReal> selectFromStudent (String id);

    public List<AppointmentShowReal> selectFromDoctor (String id);

    int getTotalNum();

    int getTotalNumFromStuId(String id);

    int getTotalNumFromDocId(String id);
}
