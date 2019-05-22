package cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import cust.dao.LinkmanDao;
import cust.entity.Customer;
import cust.entity.Linkman;

public class LinkManDaoImpl implements LinkmanDao {

	@Override
	public List<Linkman> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linkman> find(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Linkman> list = new ArrayList<Linkman>();
		String sql = "select * from cst_linkman where lk_cst_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getID());
			rs = pst.executeQuery();
			while (rs.next()) {
				Linkman l = new Linkman(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				list.add(l);
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
	public boolean add(Linkman l) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "insert into cst_linkman values(seq_linkman_id.nextval,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, l.getName());
			pst.setString(2, l.getSex());
			pst.setString(3, l.getPostion());
			pst.setString(4, l.getTel());
			pst.setString(5, l.getPhone());
			pst.setString(6, l.getMemo());
			pst.setInt(7, l.getCustomer().getID());
			int flag = pst.executeUpdate();
			if (flag > 0) {
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
	public boolean del(Linkman l) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "delete from cst_linkman where lk_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, l.getID());
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
	public boolean update(Linkman l) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "update cst_linkman set lk_name=?,lk_sex=?,lk_postion=?,lk_tel=?,lk_phone=?,lk_memo=? where lk_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, l.getName());
			pst.setString(2, l.getSex());
			pst.setString(3, l.getPostion());
			pst.setString(4, l.getTel());
			pst.setString(5, l.getPhone());
			pst.setString(6, l.getMemo());
			pst.setInt(7, l.getID());
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
	public Linkman findById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Linkman linkman = null;
		String sql = "select * from cst_linkman where lk_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Customer c = new CustomerDaoImpl().findById(rs.getInt(8));
				linkman = new Linkman(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return linkman;
	}

}
