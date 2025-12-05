package project.DAL.Factory.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.DAL.Factory.Dao.AppointgmentShowDao;
import project.entity.AppointmentShowReal;
import project.util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentShowDaoImpl implements AppointgmentShowDao {
    @Override
    public List<AppointmentShowReal> Select() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from appointment_show";
        List<Object> params = new ArrayList<>();

//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        List<AppointmentShowReal> query=queryRunner.query(sql, new BeanListHandler<AppointmentShowReal>(AppointmentShowReal.class),params.toArray());
        return query;
    }

    @Override
    public List<AppointmentShowReal> selectFromStudent(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //嵌套查询
        String sql = "select * from appointment_show where student_name = (select student_name from student where student_id = ?)";
        List<Object> params = new ArrayList<>();

//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        List<AppointmentShowReal> query= null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<AppointmentShowReal>(AppointmentShowReal.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public List<AppointmentShowReal> selectFromDoctor(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //嵌套查询
        String sql = "select * from appointment_show where doctor_name = (select doctor_name from doctor where doctor_id = ?)";

        List<Object> params = new ArrayList<>();

        List<AppointmentShowReal> query= null;

//        sql+="LIMIT ?,?";
//        params.add(num);
//        params.add(pageSize);

        try {
            query = queryRunner.query(sql, new BeanListHandler<AppointmentShowReal>(AppointmentShowReal.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int getTotalNum() {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select count(1) from appointment_show";
        int num = 0;
        try {
            num=queryRunner.query(sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int getTotalNumFromStuId(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //嵌套查询
        String sql = "select count(1) from appointment_show where student_name = (select student_name from student where student_id = ?)";
        int num = 0;
        try {
            num = queryRunner.query(sql, new ScalarHandler<Long>(),id).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int getTotalNumFromDocId(String id) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //嵌套查询
        String sql = "select count(1) from appointment_show where doctor_name = (select doctor_name from doctor where doctor_id = ?)";
        int num = 0;
        try {
            num = queryRunner.query(sql, new ScalarHandler<Long>(),id).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
