package project.DAL.Factory;

import project.DAL.Factory.Dao.Impl.ReportDaoImpl;
import project.DAL.Factory.Dao.ReportDao;

public class ReportDaoFactory {
    public static ReportDao getReportDaoInstance(){
        return new ReportDaoImpl();
    }
}
