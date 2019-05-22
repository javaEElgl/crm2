package zxh.zxh.dao;

import util.DBUtil;
import zxh.zxh.util.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(String u_name,String u_pwd){
        Connection conn= DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from sys_user where u_name=? and u_pwd=?";
        User u=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,u_name);
            ps.setString(2,u_pwd);
            rs=ps.executeQuery();
            while (rs.next()){
                u=new User();
                u.setU_id(rs.getInt("u_id"));
                u.setU_name(rs.getString("u_name"));
                u.setU_pwd(rs.getString("u_pwd"));
                u.setU_role_id(rs.getInt("u_role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return u;
    }
}
