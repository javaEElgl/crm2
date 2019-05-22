package sale.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sale.dao.SaleDao;
import sale.entity.Sale;
import util.DBUtil;

public class SaleDaoImpl implements SaleDao{

	@Override
	public List<Sale> splitPage(List<Sale> list,int begin, int end) {
		ArrayList<Sale> l=new ArrayList<Sale>();
		for(int i=begin;i<=end;i++){
			if(i>list.size()){
				return l;
			}
			l.add(list.get(i-1));
		}
		return l;
	}

	@Override
	public List<Sale> find() {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Sale> list=new ArrayList<Sale>();
		String sql="select * from sal_sale";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Sale sale=new Sale();
				sale.setId(rs.getInt(1));
				sale.setSource(rs.getString(2));
				sale.setName(rs.getString(3));
				sale.setContact(rs.getString(4));
				sale.setPhone(rs.getString(5));
				sale.setTitle(rs.getString(6));
				sale.setRate(rs.getString(7));
				sale.setDesc(rs.getString(8));
				sale.setCreateName(rs.getString(9));
				sale.setCreateTime(rs.getString(10));
				sale.setDueName(rs.getString(11));
				sale.setDueTime(rs.getString(12));
				sale.setStatus(rs.getInt(13));
				list.add(sale);
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
	public List<Sale> find(Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Sale> sales = new ArrayList<Sale>();
		String name=sale.getName();
		String title=sale.getTitle();
		String contact=sale.getContact();
		String sql;
		if (("").equals(name) && ("").equals(title)) {
			sql = "select * from sal_sale where s_contact=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, contact);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		} else if (("").equals(contact) && ("").equals(title)) {
			sql = "select  * from	 sal_sale where s_name=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		} else if (("").equals(name) && ("").equals(contact)) {
			sql = "select * from sal_sale where s_title=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, title);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		} else if (("").equals(name)) {
			sql = "select * from sal_sale where s_title=? and s_contact=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, title);
				pst.setString(2, contact);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		} else if (("").equals(title)) {
			sql = "select * from sal_sale where s_name=? and s_contact=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, contact);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		} else if (("").equals(contact)) {
			sql = "select * from sal_sale where s_name=? and s_title=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, title);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		} else {
			sql = "select * from sal_sale where s_name=? and s_title=? and s_contact=?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, title);
				pst.setString(3, contact);
				rs = pst.executeQuery();
				while (rs.next()) {
					Sale s=new Sale();
					s.setId(rs.getInt(1));
					s.setSource(rs.getString(2));
					s.setName(rs.getString(3));
					s.setContact(rs.getString(4));
					s.setPhone(rs.getString(5));
					s.setTitle(rs.getString(6));
					s.setRate(rs.getString(7));
					s.setDesc(rs.getString(8));
					s.setCreateName(rs.getString(9));
					s.setCreateTime(rs.getString(10));
					s.setDueName(rs.getString(11));
					s.setDueTime(rs.getString(12));
					s.setStatus(rs.getInt(13));
					sales.add(s);
				}
				return sales;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConn(conn, pst, rs);
			}
		}
		return null;
	}

	@Override
	public boolean add(Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql="insert into sal_sale values(seq_sale_id.nextval,?,?,?,?,?,?,?,?,?,null,null,1)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, sale.getSource());
			pst.setString(2, sale.getName());
			pst.setString(3, sale.getContact());
			pst.setString(4, sale.getPhone());
			pst.setString(5, sale.getTitle());
			pst.setString(6, sale.getRate());
			pst.setString(7, sale.getDesc());
			pst.setString(8, sale.getCreateName());
			pst.setString(9, sale.getCreateTime());
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
	public boolean del(Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql="delete from sal_sale where s_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, sale.getId());
			int flag=pst.executeUpdate();
			if(flag>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql="update sal_sale set s_source=?,s_name=?,s_contact=?,s_phone=?,s_title=?,s_rate=?,s_desc=? where s_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, sale.getSource());
			pst.setString(2, sale.getName());
			pst.setString(3, sale.getContact());
			pst.setString(4, sale.getPhone());
			pst.setString(5, sale.getTitle());
			pst.setString(6, sale.getRate());
			pst.setString(7, sale.getDesc());
			pst.setInt(8, sale.getId());
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
	public Sale findById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Sale sale=null;
		String sql="select * from sal_sale where s_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				sale=new Sale(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
						rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return sale;
	}

	@Override
	public boolean dispatch(Sale sale) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="update sal_sale set s_duename=? ,s_duetime=?,s_status=2 where s_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, sale.getDueName());
			pst.setString(2, sale.getDueTime());
			pst.setInt(3, sale.getId());
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
	public int count() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select count(*) from sal_sale";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return 0;
	}

	@Override
	public int status(Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select s_status from  sal_sale  where s_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, sale.getId());
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return 0;
	}

	@Override
	public boolean finish(Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="update sal_sale set s_status=? where s_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, sale.getStatus());
			pst.setInt(2, sale.getId());
			int flag=pst.executeUpdate();
			if(flag>0){
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
