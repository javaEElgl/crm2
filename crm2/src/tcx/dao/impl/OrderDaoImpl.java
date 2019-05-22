package tcx.dao.impl;

import tcx.dao.OrderDao;
import tcx.pojo.Order;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {
	@Override
	public ArrayList<Order> searchOrder() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select c.cst_id,c.cst_name,sum(o.or_money) from cst_customer c,orders o where c.cst_id=o.or_cst_id group by c.cst_id,c.cst_name ";
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOr_id(rs.getInt(1));
				order.setCst_name(rs.getString(2));
				order.setOr_money(rs.getInt(3));
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return orderList;
	}

	@Override
	public ArrayList<Order> searchOrder(String year) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select c.cst_id,c.cst_name,sum(o.or_money) from cst_customer c,orders o where c.cst_id=o.or_cst_id and substr(o.or_date,0,4)=? group by c.cst_id,c.cst_name";
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOr_id(rs.getInt(1));
				order.setCst_name(rs.getString(2));
				order.setOr_money(rs.getInt(3));
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return orderList;
	}

	@Override
	public ArrayList<Order> searchOrder(String name, String year) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		if ("all".equals(year)) {
			String sql = "select c.cst_id,c.cst_name,sum(o.or_money) from cst_customer c,orders o where c.cst_id=o.or_cst_id and c.cst_name=?  group by c.cst_id,c.cst_name";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				rs = pst.executeQuery();
				while (rs.next()) {
					Order order = new Order();
					order.setOr_id(rs.getInt(1));
					order.setCst_name(rs.getString(2));
					order.setOr_money(rs.getInt(3));
					orderList.add(order);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConn(conn, pst, rs);
			}
		}
		else {
			String sql = "select c.cst_id,c.cst_name,sum(o.or_money) from cst_customer c,orders o where c.cst_id=o.or_cst_id and c.cst_name=? and substr(o.or_date,0,4)=? group by c.cst_id,c.cst_name";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, year);
				rs = pst.executeQuery();
				while (rs.next()) {
					Order order = new Order();
					order.setOr_id(rs.getInt(1));
					order.setCst_name(rs.getString(2));
					order.setOr_money(rs.getInt(3));
					orderList.add(order);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConn(conn, pst, rs);
			}
		}
		return orderList;
	}
}
