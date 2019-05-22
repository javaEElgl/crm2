package sale.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sale.dao.PlanDao;
import sale.entity.Plan;
import sale.entity.Sale;
import util.DBUtil;

public class PlanDaoImpl implements PlanDao {

	@Override
	public List<Plan> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plan> find(Sale s) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Plan> plist = new ArrayList<Plan>();
		String sql = "select * from sal_plan where p_s_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s.getId());
			rs = pst.executeQuery();
			while (rs.next()) {
				Plan p = new Plan(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						new SaleDaoImpl().findById(rs.getInt(5)));
				plist.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pst, rs);
		}
		return plist;
	}

	@Override
	public boolean add(Plan plan) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		try {
			conn.setAutoCommit(false);
			String sql = "insert into sal_plan values(seq_plan_id.nextval,?,?,null,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, plan.getDate());
			pst.setString(2, plan.getTodo());
			pst.setInt(3, plan.getSale().getId());
			int flag = pst.executeUpdate();
			if (flag > 0) {
				//查看Sale的状态如果为2改变为3
				int status = new SaleDaoImpl().status(plan.getSale());
				if(status==2){
				// 改变Sale的状态
				PreparedStatement pst2 = null;
				String sql2 = "update sal_sale set s_status=3 where s_id=?";
				pst2 = conn.prepareStatement(sql2);
				pst2.setInt(1, plan.getSale().getId());
				int flag2 = pst2.executeUpdate();
				if (flag2 > 0) {
					conn.commit();
					return true;
				}else{
					conn.rollback();
					return false;
				}
				}
				conn.commit();
				return true;
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
		} finally {
			DBUtil.closeConn(conn, pst);
		}
		return false;
	}

	@Override
	public boolean del(Plan plan) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "delete from   sal_plan where p_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, plan.getId());
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
	public boolean update(Plan plan) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "update   sal_plan set p_todo=? where p_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, plan.getTodo());
			pst.setInt(2, plan.getId());
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
	public boolean execute(Plan plan, Sale sale) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst = null;
		String sql = "update   sal_plan set p_result=? where p_id=?";
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql);
			pst.setString(1, plan.getResult());
			pst.setInt(2, plan.getId());
			int flag = pst.executeUpdate();
			if (flag > 0) {
				//更改Sale的状态
				String sql1="update sal_sale set s_status=4 where s_id=?";
				PreparedStatement pst1 = conn.prepareStatement(sql1);
				pst1.setInt(1, sale.getId());
				int flag1=pst1.executeUpdate();
				if(flag1>0){
					conn.commit();
					return true;
				}else{
					conn.rollback();
					return false;
				}
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
