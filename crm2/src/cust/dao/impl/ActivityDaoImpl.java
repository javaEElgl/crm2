package cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import cust.dao.ActivityDao;
import cust.entity.Activity;
import cust.entity.Customer;
import cust.entity.Linkman;

public class ActivityDaoImpl implements ActivityDao{

	@Override
	public List<Activity> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> find(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from  cst_activity where at_cst_id=?";
		ArrayList<Activity> list=new ArrayList<Activity>();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getID());
			rs=pst.executeQuery();
			while(rs.next()){
				Customer cust=new CustomerDaoImpl().findById(rs.getInt(6));
				Activity a=new Activity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), cust);
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst,rs);
		}
		return list;
	}

	@Override
	public boolean add(Activity a) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="insert into cst_activity values(seq_activity_id.nextval,?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, a.getDate());
			pst.setString(2, a.getPlace());
			pst.setString(3, a.getTitle());
			pst.setString(4, a.getDesc());
			pst.setInt(5, a.getCustomer().getID());
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

	@Override
	public boolean del(Activity a) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "delete from cst_activity  where at_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,a.getID());
			int flag = pst.executeUpdate();
			if (flag>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst);
		}
		return false;
	}

	@Override
	public boolean update(Activity a) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "update cst_activity set at_date=?,at_place=?,at_title=?,at_desc=? where at_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,a.getDate());
			pst.setString(2, a.getPlace());
			pst.setString(3, a.getTitle());
			pst.setString(4,a.getDesc());
			pst.setInt(5,a.getID());
			int flag = pst.executeUpdate();
			if (flag>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst);
		}
		return false;
	}

	@Override
	public Activity findById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Activity act = null;
		String sql = "select * from cst_activity where at_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Customer c = new CustomerDaoImpl().findById(rs.getInt(6));
				act = new Activity(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return act;
	}

}
