package util;
import java.sql.*;
import java.util.*;


public class DBUtil {
	public static Connection getConn(){
		 Connection conn=null;
		//∑¥…‰º”‘ÿ«˝∂Ø
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			conn=DriverManager.getConnection(url, "scott", "tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(Connection conn,PreparedStatement stmt,ResultSet rs) {
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeConn(Connection conn,PreparedStatement stmt) {
		closeConn(conn, stmt,null);
	}
}
