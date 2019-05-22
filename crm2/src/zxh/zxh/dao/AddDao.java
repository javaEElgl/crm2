package zxh.zxh.dao;


import util.DBUtil;
import zxh.zxh.util.Customer;
import zxh.zxh.util.Service;
import zxh.zxh.util.User;


import java.sql.*;

public class AddDao {
    public Service addService(String type, String title, String custname,int status ,String request, String createby, String createdate) {
        Connection conn = DBUtil.getConn();
        String sql1 = "select * from cst_customer where cst_name=?";
        String sql2 = "select * from sys_user where U_NAME=?";
        String sql3 = "insert into CST_SERVICE values(seq_service_id.nextval,?,?,?,?,?,?,?,null,null,null,null,null,null,0)";
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Customer customer = null;
        User u = null;
        Service service = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        try {
            ps = conn.prepareStatement(sql1);
            ps.setString(1, custname);
            rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setCst_name(rs.getString("cst_name"));
                ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, createby);
                rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    u = new User();
                    u.setU_id(rs2.getInt("u_id"));
                    u.setU_name(rs2.getString("u_name"));
                    u.setU_pwd(rs2.getString("u_pwd"));
                    u.setU_role_id(rs2.getInt("u_role_id"));
                    ps3 = conn.prepareStatement(sql3);
                    ps3.setString(1, type);
                    ps3.setString(2, title);
                    ps3.setString(3, customer.getCst_name());
                    ps3.setInt(4,status);
                    ps3.setString(5, request);
                    ps3.setString(6, u.getU_name());
                    ps3.setString(7, createdate);
                    int result = ps3.executeUpdate();
                    if (result > 0) {
                        service = new Service();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, ps, rs);
            DBUtil.closeConn(null, ps2, rs2);
            DBUtil.closeConn(null, ps3, null);
        }
        return service;
    }
}
