package cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sale.entity.Sale;
import util.DBUtil;

import cust.dao.CustomerDao;
import cust.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> splitPage(List<Customer> list, int begin, int end) {
		ArrayList<Customer> l = new ArrayList<Customer>();
		for (int i = begin; i <= end; i++) {
			if (i > list.size()) {
				return l;
			}
			l.add(list.get(i - 1));
		}
		return l;
	}

	@Override
	public List<Customer> find() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from  cst_customer";
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				list.add(c);
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
	public List<Customer> find(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Customer> list=new ArrayList<Customer>();
		String sql="";
		try {
		if("".equals(c.getName())&&"".equals(c.getManager())&&"".equals(c.getRegion())&&"".equals(c.getLevel())){
			sql="select * from cst_customer where cst_no=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getNo());
			rs=pst.executeQuery();
			while(rs.next()){
				Customer cust = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				list.add(cust);
			}
		}
		if("".equals(c.getNo())&&"".equals(c.getManager())&&"".equals(c.getRegion())&&"".equals(c.getLevel())){
			sql="select * from cst_customer where cst_name=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			rs=pst.executeQuery();
			while(rs.next()){
				Customer cust = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				list.add(cust);
			}
		}if("".equals(c.getName())&&"".equals(c.getNo())&&"".equals(c.getRegion())&&"".equals(c.getLevel())){
			sql="select * from cst_customer where cst_manager=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getManager());
			rs=pst.executeQuery();
			while(rs.next()){
				Customer cust = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				list.add(cust);
			}
		}if("".equals(c.getName())&&"".equals(c.getManager())&&"".equals(c.getNo())&&"".equals(c.getLevel())){
			sql="select * from cst_customer where cst_region=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getRegion());
			rs=pst.executeQuery();
			while(rs.next()){
				Customer cust = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				list.add(cust);
			}
		}if("".equals(c.getName())&&"".equals(c.getManager())&&"".equals(c.getRegion())&&"".equals(c.getNo())){
			sql="select * from cst_customer where cst_level=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getLevel());
			rs=pst.executeQuery();
			while(rs.next()){
				Customer cust = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				list.add(cust);
			}
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
	public boolean add(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into cst_customer values(seq_cust_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getNo());
			pst.setString(2, c.getName());
			pst.setString(3, c.getRegion());
			pst.setString(4, c.getManager());
			pst.setString(5, c.getLevel());
			pst.setString(6, c.getSatisfy());
			pst.setString(7, c.getCredit());
			pst.setString(8, c.getAddr());
			pst.setString(9, c.getZip());
			pst.setString(10, c.getTel());
			pst.setString(11, c.getFax());
			pst.setString(12, c.getWebsite());
			pst.setString(13, c.getLicenceID());
			pst.setString(14, c.getChieftain());
			pst.setString(15, c.getBankroll());
			pst.setString(16, c.getTurnover());
			pst.setString(17, c.getBank());
			pst.setString(18, c.getBankID());
			pst.setString(19, c.getLocalID());
			pst.setString(20, c.getNationalID());
			int flag = pst.executeUpdate();
			if (flag > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst,rs);
		}
		return false;
	}

	@Override
	public boolean del(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "delete  from  cst_customer where cst_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getID());
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
	public boolean update(Customer c) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "update   cst_customer set cst_name=? ,cst_region=?, cst_manager=? ," 
				+"cst_level=?,cst_satisfy=? ,cst_credit=?,"
				+ "cst_addr=? ,cst_zip=?,cst_tel=? ,cst_fax=?,"
				+ "cst_website=? ,cst_licenceid=?,cst_chieftain=? ,cst_bankroll=?,"
				+"cst_turnover=?,cst_bank=?,cst_bankid=?,cst_localid=?,cst_nationalid=?"
				+ "where cst_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, c.getName());
			pst.setString(2, c.getRegion());
			pst.setString(3, c.getManager());
			pst.setString(4, c.getLevel());
			pst.setString(5, c.getSatisfy());
			pst.setString(6, c.getCredit());
			pst.setString(7, c.getAddr());
			pst.setString(8, c.getZip());
			pst.setString(9, c.getTel());
			pst.setString(10, c.getFax());
			pst.setString(11, c.getWebsite());
			pst.setString(12, c.getLicenceID());
			pst.setString(13, c.getChieftain());
			pst.setString(14, c.getBankroll());
			pst.setString(15, c.getTurnover());
			pst.setString(16, c.getBank());
			pst.setString(17, c.getBankID());
			pst.setString(18, c.getLocalID());
			pst.setString(19, c.getNationalID());
			pst.setInt(20, c.getID());
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
	public List<Object[]> rept(String flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetMaxNo() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select max(to_number(substr(cst_no,8))) from cst_customer";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer findById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Customer c = null;
		String sql = "select * from cst_customer where cst_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),
						rs.getString(18), rs.getString(19), rs.getString(20),
						rs.getString(21), rs.getInt(22));
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return c;
	}

	@Override
	public ArrayList<Integer> isLost(List<Customer> clist) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			for (int i = 0; i < clist.size(); i++) {
				Customer c = clist.get(i);
				String lastdate = null;
				String sql = "select to_char(max(to_date(or_date,'yyyy-mm-dd')),'yyyy-mm-dd') from  orders  where or_cst_id=? group by or_cst_id";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, c.getID());
				rs = pst.executeQuery();
				if (rs.next()) {
					// 判断是否大于一个月
					lastdate = rs.getString(1);
					String sql1 = "select floor(months_between(sysdate,to_date(?,'yyyy/mm/dd'))) from dual";
					PreparedStatement pst1 = conn.prepareStatement(sql1);
					pst1.setString(1, lastdate);
					ResultSet rs1 = pst1.executeQuery();
					if (rs1.next()) {
						int month = rs1.getInt(1);
						if (month >= 1) {
							// 说明达到流失标准，查看流失表中有没有此用户
							String sql2 = "select * from cst_lost where lost_customer=?";
							PreparedStatement pst2 = conn
									.prepareStatement(sql2);
							pst2.setString(1, c.getName());
							ResultSet rs2 = pst2.executeQuery();
							if (rs2.next()) {
								// 客户流失表中已经有了，那就无需插入
								list.add(1);
								continue;
							} else {
								String sql3 = "insert into cst_lost values(seq_lost_id.nextval,?,?,?,null,null,null,1)";
								PreparedStatement pst3 = conn
										.prepareStatement(sql3);
								pst3.setString(1, c.getName());
								pst3.setString(2, c.getManager());
								pst3.setString(3, lastdate);
								int flag = pst3.executeUpdate();
								if (flag > 0) {
									list.add(1);
									continue;
								}
							}
						}
					}
				}
				list.add(0);
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
	public boolean findByName(String name) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "select * from cst_customer where cst_name=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
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

}
