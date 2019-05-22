package tcx.dao.impl;


import tcx.dao.LevelDao;
import tcx.pojo.Level;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LevelDaoImpl implements LevelDao {

    @Override
    public ArrayList<Level> searchLevel() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select cst_level,count(cst_name) from cst_customer group by cst_level";
        ArrayList<Level> levelList =new ArrayList<Level>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Level level = new Level();
                level.setCst_level(rs.getString(1));
                level.setCst_name(rs.getString(2));
                levelList.add(level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return levelList;
    }

    @Override
    public ArrayList<Level> searchLevelBySatisfy() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select cst_level,count(cst_id) from cst_customer group by cst_satisfy,cst_level order by cst_satisfy";
        ArrayList<Level> levelList =new ArrayList<Level>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Level level = new Level();
                level.setCst_level(rs.getString(1));
                level.setCst_name(rs.getString(2));
                levelList.add(level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return levelList;
    }

    @Override
    public ArrayList<Level> searchLevelByCredit() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select cst_level,count(cst_id) from cst_customer group by cst_credit,cst_level order by cst_credit";
        ArrayList<Level> levelList =new ArrayList<Level>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Level level = new Level();
                level.setCst_level(rs.getString(1));
                level.setCst_name(rs.getString(2));
                levelList.add(level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return levelList;
    }
}
