package tcx.dao.impl;


import tcx.dao.StorageDao;
import tcx.pojo.Dict;
import tcx.pojo.Storage;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public ArrayList<Storage> searchStorage() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select p_id,p_name,p_storagename,p_ware,p_count,p_memo from BASD_PRODUCT";
        ArrayList<Storage> storageList = new ArrayList<Storage>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Storage storage = new Storage();
                storage.setP_id(rs.getInt(1));
                storage.setP_name(rs.getString(2));
                storage.setP_storagename(rs.getString(3));
                storage.setP_ware(rs.getString(4));
                storage.setP_count(rs.getString(5));
                storage.setP_memo(rs.getString(6));
                storageList.add(storage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return storageList;
    }

    @Override
    public ArrayList<Storage> searchStorageByCondition(String p_name, String p_storagename) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<Storage> storageList = null;
        try {
            if (p_name.equals("")){
                if (p_storagename.equals("")){
                    sql="select p_id,p_name,p_storagename,p_ware,p_count,p_memo from BASD_PRODUCT";
                    pst = conn.prepareStatement(sql);
                }else{
                    sql="select p_id,p_name,p_storagename,p_ware,p_count,p_memo from BASD_PRODUCT where p_storagename=?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,p_storagename);
                }
            }else {
                if (p_storagename.equals("")){
                    sql="select p_id,p_name,p_storagename,p_ware,p_count,p_memo from BASD_PRODUCT where p_name=?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,p_name);
                }else{
                    sql="select p_id,p_name,p_storagename,p_ware,p_count,p_memo from BASD_PRODUCT where p_name=? and p_storagename=?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,p_name);
                    pst.setString(2,p_storagename);
                }
            }
            storageList=new ArrayList<Storage>();
            rs = pst.executeQuery();
            while (rs.next()) {
                Storage storage = new Storage();
                storage.setP_id(rs.getInt(1));
                storage.setP_name(rs.getString(2));
                storage.setP_storagename(rs.getString(3));
                storage.setP_ware(rs.getString(4));
                storage.setP_count(rs.getString(5));
                storage.setP_memo(rs.getString(6));
                storageList.add(storage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return storageList;
    }

	@Override
	public List<Storage> splitPage(List<Storage> list, int begin, int end) {
		ArrayList<Storage> l = new ArrayList<Storage>();
		for (int i = begin; i <= end; i++) {
			if (i > list.size()) {
				return l;
			}
			l.add(list.get(i - 1));
		}
		return l;
	}
}
