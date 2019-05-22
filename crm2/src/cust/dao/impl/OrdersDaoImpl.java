package cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import cust.dao.OrdersDao;
import cust.entity.Customer;
import cust.entity.Linkman;
import cust.entity.Orders;
import cust.entity.OrdersLine;

public class OrdersDaoImpl implements OrdersDao{
	
	@Override
	public List<Orders> splitPage(List<Orders> list, int begin, int end) {
		ArrayList<Orders> l = new ArrayList<Orders>();
		for (int i = begin; i <= end; i++) {
			if (i > list.size()) {
				return l;
			}
			l.add(list.get(i - 1));
		}
		return l;
	}
	@Override
	public List<Orders> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> find(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql = "select * from orders where or_cst_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getID());
			rs = pst.executeQuery();
			while (rs.next()) {
				Customer cust=new CustomerDaoImpl().findById(rs.getInt(6));
				Orders o = new Orders(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5),
						cust);
				list.add(o);
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
	public boolean add(Orders o,OrdersLine oLine) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "insert into orders values(seq_orders_id.nextval,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, o.getDate());
			pst.setString(2, o.getAddr());
			pst.setInt(3, o.getStatus());
			pst.setInt(4, o.getMoney());
			pst.setInt(5, o.getCustomer().getID());
			int flag = pst.executeUpdate();
			if(flag>0){
				//获取我们刚刚创建的order的id
				int id = new OrdersDaoImpl().getID();
				String sql1="insert into orders_line values(seq_ordersline_id.nextval,?,?,?,?,?)";
				PreparedStatement pst1 = conn.prepareStatement(sql1);
				pst1.setInt(1, oLine.getCount());
				pst1.setString(2,	oLine.getUnit());
				pst1.setInt(3, oLine.getPrice());
				pst1.setString(4, oLine.getProduct());
				pst1.setInt(5, id);
				int flag1 = pst1.executeUpdate();
				if(flag1>0){
					return true;
				}
				return false;
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
	public boolean del(Orders o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Orders o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object[]> rept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Orders> list = new ArrayList<Orders>();
		String sql = "select max(or_id) from orders";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
					return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst,rs);
		}
		return 0;
	}

	@Override
	public Orders findById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Orders o=null;
		String sql = "select * from orders where or_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
					Customer c=new CustomerDaoImpl().findById(rs.getInt(6));
					o=new Orders(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst,rs);
		}
		return o;
	}

	@Override
	public boolean findByCustId(int cid) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from orders where or_cst_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return false;
	}

	

}
