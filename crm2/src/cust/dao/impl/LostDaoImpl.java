package cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DBUtil;

import cust.dao.LostDao;
import cust.entity.Customer;
import cust.entity.Lost;
import cust.entity.Orders;

public class LostDaoImpl implements LostDao {

	@Override
	public List<Lost> splitPage(List<Lost> list, int begin, int end) {
		ArrayList<Lost> l = new ArrayList<Lost>();
		for (int i = begin; i <= end; i++) {
			if (i > list.size()) {
				return l;
			}
			l.add(list.get(i - 1));
		}
		return l;
	}

	@Override
	public List<Lost> find() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Lost> list = new ArrayList<Lost>();
		String sql = "select * from cst_lost";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Lost lost = new Lost(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(lost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return list;
	}

	@Override
	public List<Lost> find(Lost l) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Lost> list = new ArrayList<Lost>();
		String customer = l.getCustomer();
		String manager = l.getManager();
		int status = l.getStatus();
		String sql = "";
		try {
			if ("".equals(manager) && status == 0) {
				sql = "select * from cst_lost where lost_customer=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, customer);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
			if ("".equals(customer) && status == 0) {
				sql = "select * from cst_lost where lost_manager=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, manager);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
			if ("".equals(manager) && "".equals(customer)) {
				sql = "select * from cst_lost where lost_status=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, status);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
			if (status == 0) {
				sql = "select * from cst_lost where lost_customer=? and lost_manager=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, customer);
				pst.setString(2, manager);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
			if ("".equals(customer) ) {
				sql = "select * from cst_lost where lost_manager=? and lost_status=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, manager);
				pst.setInt(2, status);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
			if ("".equals(manager) ) {
				sql = "select * from cst_lost where lost_customer=? and lost_status=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, customer);
				pst.setInt(2, status);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
			if (!("".equals(customer)&&"".equals(manager)&&status == 0)) {
				sql = "select * from cst_lost where lost_customer=? and lost_manager=? and lost_status=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, customer);
				pst.setString(2, manager);
				pst.setInt(3, status);
				rs = pst.executeQuery();
				while (rs.next()) {
					Lost lost = new Lost(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8));
					list.add(lost);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return list;
	}

	@Override
	public boolean add(Lost l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(Lost l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Lost l) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "update cst_lost set lost_lostdate=? ,lost_reason=? ,lost_status=3 where lost_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, l.getLostdate());
			pst.setString(2, l.getReason());
			pst.setInt(3, l.getID());
			int flag = pst.executeUpdate();
			if (flag > 0) {
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
	public List<Lost> rept(String flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lost findByCust(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Lost l = null;
		String sql = "select * from cst_lost where lost_customer=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			rs = pst.executeQuery();
			while (rs.next()) {
				l = new Lost(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return l;
	}

	@Override
	public Lost findById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Lost lost = null;
		String sql = "select * from cst_lost where lost_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				lost = new Lost(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return lost;
	}

	@Override
	public boolean delay(Lost l) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		// 先查询之前的暂缓措施
		String sql = "select  lost_delay from cst_lost where lost_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, l.getID());
			rs = pst.executeQuery();
			if (rs.next()) {
				String delay = rs.getString(1);
				if (delay == null) {
					sql = "update cst_lost set lost_delay=?, lost_status=2 where lost_id=?";
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy/MM/dd hh:mm:ss");
					delay = sdf.format(new Date()) + ":" + l.getDelay();
					pst = conn.prepareStatement(sql);
					pst.setString(1, delay);
					pst.setInt(2, l.getID());
					int flag = pst.executeUpdate();
					if (flag > 0) {
						return true;
					}
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy/MM/dd hh:mm:ss");
					delay += "-" + sdf.format(new Date()) + ":" + l.getDelay();
					sql = "update cst_lost set lost_delay=? , lost_status=2 where lost_id=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, delay);
					pst.setInt(2, l.getID());
					int flag = pst.executeUpdate();
					if (flag > 0) {
						return true;
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return false;
	}

}
