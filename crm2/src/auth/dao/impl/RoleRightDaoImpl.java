package auth.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import auth.dao.RoleRightDao;
import auth.entity.Right;
import auth.entity.Role_Right;

public class RoleRightDaoImpl implements RoleRightDao{

	@Override
	public List<Role_Right> find(int roleId) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Role_Right> list=new ArrayList<Role_Right>();
		String sql="select * from sys_role_right where rr_role_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, roleId);
			rs=pst.executeQuery();
			while(rs.next()){
				list.add(new Role_Right(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
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
	public boolean add(Role_Right rr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(Role_Right rr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Right findRight(int rightID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int roleId, String[] rights) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		try {
			String sql="delete  from sys_role_right where rr_role_id=?";
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, roleId);
			int flag=pst.executeUpdate();
			if(flag>0){
				boolean flag1=true;
				//找到该角色后，循环给他插入权限
				for(int i=0;i<rights.length;i++){
					String sql2="insert into sys_role_right values(seq_rr_id.nextval,?,?)";
					PreparedStatement pst2 = conn.prepareStatement(sql2);
					pst2.setInt(1,roleId);
					pst2.setInt(2, Integer.parseInt(rights[i]));
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
		}finally{
			DBUtil.closeConn(conn, pst);
		}
		return false;
	}

}
