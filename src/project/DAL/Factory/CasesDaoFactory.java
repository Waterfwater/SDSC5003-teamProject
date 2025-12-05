package project.DAL.Factory;

import project.DAL.Factory.Dao.CasesDao;
import project.DAL.Factory.Dao.Impl.CasesDaoImpl;

public class CasesDaoFactory {
    public static CasesDao getCasesDaoInstance(){
        return new CasesDaoImpl();
    }
}
