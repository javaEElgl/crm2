package tcx.dao.impl;


import tcx.dao.ServiceDao;
import tcx.pojo.Service;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public ArrayList<Service> searchService() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select sv_type,count(sv_id) from CST_SERVICE group by sv_type";
        ArrayList<Service> serviceList = new ArrayList<Service>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setSv_type(rs.getString(1));
                service.setSv_id(rs.getInt(2));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return serviceList;
    }

    @Override
    public ArrayList<Service> searchServiceByYear(String year) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select sv_type,count(sv_id) from CST_SERVICE where substr(sv_duedate,0,4)=? group by sv_type";
        ArrayList<Service> serviceList = new ArrayList<Service>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,year);
            rs = pst.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setSv_type(rs.getString(1));
                service.setSv_id(rs.getInt(2));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return serviceList;
    }
}
