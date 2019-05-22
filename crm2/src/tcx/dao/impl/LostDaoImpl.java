package tcx.dao.impl;


import tcx.dao.LostDao;
import tcx.pojo.Lost;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LostDaoImpl implements LostDao {
    @Override
    public ArrayList<Lost> searchLost() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select substr(lost_lostdate,0,4),lost_customer,lost_manager,lost_reason from cst_lost";
        ArrayList<Lost> lostList = new ArrayList<Lost>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Lost lost = new Lost();
                lost.setLost_lostdate(rs.getString(1));
                lost.setLost_customer(rs.getString(2));
                lost.setLost_manager(rs.getString(3));
                lost.setLost_reason(rs.getString(4));
                lostList.add(lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return lostList;
    }

    @Override
    public ArrayList<Lost> searchLost(String lstCustName, String lstCustManagerName) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql;
        ArrayList<Lost> lostList=null;
        try {
        if (lstCustName.equals("")){
            if (lstCustManagerName.equals("")){
                sql = "select substr(lost_lostdate,0,4),lost_customer,lost_manager,lost_reason from cst_lost";
                pst = conn.prepareStatement(sql);
            }else{
                sql = "select substr(lost_lostdate,0,4),lost_customer,lost_manager,lost_reason from cst_lost where lost_manager=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1,lstCustManagerName);
            }
        }else{
            if (lstCustManagerName.equals("")){
                sql = "select substr(lost_lostdate,0,4),lost_customer,lost_manager,lost_reason from cst_lost where lost_customer=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1,lstCustName);
            }else {
                sql = "select substr(lost_lostdate,0,4),lost_customer,lost_manager,lost_reason from cst_lost where lost_customer=? and lost_manager=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1,lstCustName);
                pst.setString(2,lstCustManagerName);
            }
        }
            lostList = new ArrayList<Lost>();
            rs = pst.executeQuery();
            while (rs.next()) {
                Lost lost = new Lost();
                lost.setLost_lostdate(rs.getString(1));
                lost.setLost_customer(rs.getString(2));
                lost.setLost_manager(rs.getString(3));
                lost.setLost_reason(rs.getString(4));
                lostList.add(lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return lostList;
    }
}
