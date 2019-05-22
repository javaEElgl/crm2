package auth.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sale.entity.Sale;
import util.DBUtil;

import auth.dao.UserDao;
import auth.entity.Role;
import auth.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(String userName, String passWord) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_user where u_name=? and u_pwd=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, passWord);
			rs=pst.executeQuery();
			if(rs.next()){
				Role role = new RoleDaoImpl().find(rs.getInt(4));
				return new User(rs.getInt(1),rs.getString(2),rs.getString(3),role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return null;
	}

	@Override
	public List<User> splitPage( List<User> list,int begin, int end) {
		ArrayList<User> l=new ArrayList<User>();
		for(int i=begin;i<=end;i++){
			if(i>list.size()){
				return l;
			}
			l.add(list.get(i-1));
		}
		return l;
	}

	@Override
	public List<User> find() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_user ";
		ArrayList<User> list=new ArrayList<User>();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				User u=new User(rs.getInt(1),rs.getString(2));
				list.add(u);
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
	public List<User> find(User u) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_user where u_name=?";
		ArrayList<User> list=new ArrayList<User>();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getUserName());
			rs=pst.executeQuery();
			while (rs.next()){
				Role role = new RoleDaoImpl().find(rs.getInt(4));
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),role);
				list.add(user);
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
	public boolean add(User u) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="insert into sys_user values(seq_user_id.nextval,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getUserName());
			pst.setString(2, u.getPassWord());
			pst.setInt(3, u.getRole().getRoleId());
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
	public boolean del(User u) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="delete from sys_user where u_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, u.getUserId());
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
	public boolean update(User u) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="update sys_user set  u_name=?,u_pwd=?,u_role_id=? where u_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getUserName());
			pst.setString(2, u.getPassWord());
			pst.setInt(3, u.getRole().getRoleId());
			pst.setInt(4, u.getUserId());
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
	public User findById(int userId) {
		User u=null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_user where u_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, userId);
			rs=pst.executeQuery();
			if(rs.next()){
				Role role=new RoleDaoImpl().find(rs.getInt(4));
				u=new User(rs.getInt(1), rs.getString(2), rs.getString(3),role);
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return u;
	}

	@Override
	public boolean findByName(String username) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_user where u_name=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			rs=pst.executeQuery();
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

	@Override
	public List<User> findByType(String roleName) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<User> list=new ArrayList<User>();
		String sql="select u.* from sys_user u,sys_role r where u.u_role_id=r.role_id and r.role_name=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, roleName);
			rs=pst.executeQuery();
			while(rs.next()){
				Role role=new RoleDaoImpl().find(rs.getInt(4));
				User u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), role);
				list.add(u);
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
	public User searchByName(String name) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
		String sql="select * from sys_user where u_name=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			if(rs.next()){
				Role role=new RoleDaoImpl().find(rs.getInt(4));
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst,rs);
		}
		return user;
	}
			
}
