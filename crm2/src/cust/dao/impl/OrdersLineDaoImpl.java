package cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import cust.dao.OrdersLineDao;
import cust.entity.Customer;
import cust.entity.Orders;
import cust.entity.OrdersLine;

public class OrdersLineDaoImpl implements OrdersLineDao{

	@Override
	public List<OrdersLine> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersLine> find(Orders o) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<OrdersLine> list = new ArrayList<OrdersLine>();
		String sql = "select * from orders_line where ol_or_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, o.getID());
			rs = pst.executeQuery();
			while (rs.next()) {
				OrdersLine ordersLine=new OrdersLine(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),rs.getString(5));
				list.add(ordersLine);
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
	public boolean add(OrdersLine ol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(OrdersLine ol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OrdersLine ol) {
		// TODO Auto-generated method stub
		return false;
	}

}
