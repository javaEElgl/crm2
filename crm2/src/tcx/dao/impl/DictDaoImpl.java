package tcx.dao.impl;


import tcx.dao.DictDao;
import tcx.pojo.Dict;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cust.entity.Customer;

public class DictDaoImpl implements DictDao {
    @Override
    public ArrayList<Dict> searchDict() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from BASD_DICT";
        ArrayList<Dict> dictList = new ArrayList<Dict>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Dict dict = new Dict();
                dict.setD_id(rs.getInt(1));
                dict.setD_type(rs.getString(2));
                dict.setD_item(rs.getString(3));
                dict.setD_value(rs.getString(4));
                dict.setP_isedit(rs.getString(5));
                dictList.add(dict);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return dictList;
    }

    @Override
    public ArrayList<Dict> searchDict(String d_type, String d_item, String d_value) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql;
        ArrayList<Dict> dictList = null;
        try {
            if (d_type.equals("")) {
                if (d_item.equals("")) {
                    if (d_value.equals("")) {
                        sql = "select * from BASD_DICT";
                        pst = conn.prepareStatement(sql);
                    } else {
                        sql = "select * from BASD_DICT where d_value=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_value);
                    }
                } else {
                    if (d_value.equals("")) {
                        sql = "select * from BASD_DICT where d_item=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_item);
                    } else {
                        sql = "select * from BASD_DICT where d_item=? and d_value=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_item);
                        pst.setString(2, d_value);
                    }
                }
            } else {
                if (d_item.equals("")) {
                    if (d_value.equals("")) {
                        sql = "select * from BASD_DICT where d_type=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_type);
                    } else {
                        sql = "select * from BASD_DICT where d_type=? and d_value=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_type);
                        pst.setString(2, d_value);
                    }
                } else {
                    if (d_value.equals("")) {
                        sql = "select * from BASD_DICT where d_type=? and d_item=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_type);
                        pst.setString(2, d_item);
                    } else {
                        sql = "select * from BASD_DICT where d_type=? and d_item=? and d_value=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, d_type);
                        pst.setString(2, d_item);
                        pst.setString(3, d_value);
                    }
                }
            }
            dictList = new ArrayList<Dict>();
            rs = pst.executeQuery();
            while (rs.next()) {
                Dict dict = new Dict();
                dict.setD_id(rs.getInt(1));
                dict.setD_type(rs.getString(2));
                dict.setD_item(rs.getString(3));
                dict.setD_value(rs.getString(4));
                dict.setP_isedit(rs.getString(5));
                dictList.add(dict);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return dictList;
    }

    @Override
    public boolean addDict(String d_type, String d_item, String d_value, String p_isedit) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        String sql = "insert into BASD_DICT values (seq_dict_id.nextval,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, d_type);
            pst.setString(2, d_item);
            pst.setString(3, d_value);
            pst.setString(4, p_isedit);
            int result = pst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst);
        }
        return false;
    }

    @Override
    public boolean updateDict(String d_type, String d_item, String d_value, String p_isedit, String id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        try {
            String sql = "update BASD_DICT set d_type=?,d_item=?,d_value=?,p_isedit=? where d_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, d_type);
            pst.setString(2, d_item);
            pst.setString(3, d_value);
            pst.setString(4, p_isedit);
            pst.setString(5, id);
            int result = pst.executeUpdate();
            if (result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst);
        }
        return false;
    }

	@Override
	public List<Dict> splitPage(List<Dict> list, int begin, int end) {
		ArrayList<Dict> l = new ArrayList<Dict>();
		for (int i = begin; i <= end; i++) {
			if (i > list.size()) {
				return l;
			}
			l.add(list.get(i - 1));
		}
		return l;
	}

	@Override
	public List<String> getType() {
		Connection conn=DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select distinct(d_type) from basd_dict";
		List<String> list=new ArrayList<String>();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return list;
	}

	@Override
	public boolean delDict(int id) {
		Connection conn=DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="delete from basd_dict where d_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			int flag=pst.executeUpdate();
			if(flag>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst);
		}
		return false;
	}
}
