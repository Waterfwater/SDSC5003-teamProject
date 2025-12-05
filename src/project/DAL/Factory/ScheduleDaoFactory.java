package project.DAL.Factory;

import project.DAL.Factory.Dao.Impl.ReportDaoImpl;
import project.DAL.Factory.Dao.Impl.ScheduleDaoImpl;
import project.DAL.Factory.Dao.ReportDao;
import project.DAL.Factory.Dao.ScheduleDao;

public class ScheduleDaoFactory {
    public static ScheduleDao getScheduleDaoInstance(){
        return new ScheduleDaoImpl();
    }
}
