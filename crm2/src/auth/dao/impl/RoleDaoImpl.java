package auth.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import auth.dao.RoleDao;
import auth.entity.Right;
import auth.entity.Role;
import auth.entity.Role_Right;
import auth.entity.User;

public class RoleDaoImpl implements RoleDao{

	@Override
	public List<Role> splitPage(List<Role> list,int begin, int end) {
		ArrayList<Role> l=new ArrayList<Role>();
		for(int i=begin;i<=end;i++){
			if(i>list.size()){
				return l;
			}
			l.add(list.get(i-1));
		}
		return l;
	}

	@Override
	public Role find(int roleID) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_role where role_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, roleID);
			rs=pst.executeQuery();
			if(rs.next()){
				//查找权限列表
				ArrayList<Role_Right> list=(ArrayList<Role_Right>) new RoleRightDaoImpl().find(rs.getInt(1));
				return new Role(rs.getInt(1),rs.getString(2),list);
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
	public List<Role> find() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Role> list=new ArrayList<Role>();
		String sql="select * from sys_role";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Role r=new Role(rs.getInt(1),rs.getString(2));
				list.add(r);
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
	public List<Role> find(Role role) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from sys_role where role_name=?";
		ArrayList<Role> list=new ArrayList<Role>();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, role.getRoleName());
			rs=pst.executeQuery();
			while (rs.next()){
				ArrayList<Role_Right> rlist = (ArrayList<Role_Right>)new RoleRightDaoImpl().find(rs.getInt(1));
				Role r=new Role(rs.getInt(1), rs.getString(2), rlist);
				list.add(r);
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
	public boolean add(Role role,String []list) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="insert into sys_role values (seq_role_id.nextval,?)";
		try {
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql);
			pst.setString(1, role.getRoleName());
			int flag=pst.executeUpdate();
			if(flag>0){
				//插入成功后，找到该role，并给它赋予权限。因为角色名不重复，我们通过名字找到该对象
				String sql1="select * from sys_role where role_name =?";
				PreparedStatement pst1 = conn.prepareStatement(sql1);
				pst1.setString(1, role.getRoleName());
				ResultSet rs1 = pst1.executeQuery();
				int role_id=0;
				if(rs1.next()){
					role_id=rs1.getInt(1);
				}
				boolean flag1=true;
				//找到该角色后，循环给他插入权限
				for(int i=0;i<list.length;i++){
					String sql2="insert into sys_role_right values(seq_rr_id.nextval,?,?)";
					PreparedStatement pst2 = conn.prepareStatement(sql2);
					pst2.setInt(1,role_id);
					pst2.setInt(2, Integer.parseInt(list[i]));
					int flag2 = pst2.executeUpdate();
					//如果循环执行过程有不成功，则外面设置的flag1变为false
					if(flag2<=0){
						flag1=false;
					}
				}
				if(flag1){
					conn.commit();
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst);
		}
		return false;
	}

	@Override
	public boolean del(Role role) {
		//先要删除角色权限表，再删除角色表
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		String sql="delete from sys_role_right where rr_role_id=?";
		try {
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, role.getRoleId());
			int flag=pst.executeUpdate();
			if(flag>0){
				String sql1="delete from sys_role where role_id=?";
				PreparedStatement pst1 = conn.prepareStatement(sql1);
				pst1.setInt(1, role.getRoleId());
				int flag1=pst1.executeUpdate();
				if(flag1>0){
					conn.commit();
					return true;
				}
				conn.rollback();
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
	public boolean update(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(String roleName) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Role> list=new ArrayList<Role>();
		String sql="select * from sys_role where role_name=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, roleName);
			rs=pst.executeQuery();
			if(rs.next()){
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return true;
	}
		
}
