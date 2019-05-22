package zxh.zxh.dao;

import util.DBUtil;
import zxh.zxh.util.Service;
import zxh.zxh.util.User;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
    //鎸夌姸鎬佸�鏌ユ壘鐩稿搴旀湇鍔�
    public int getAllService(int status) {
        Connection conn= DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int num=0;
        String sql="select * from cst_service where sv_status=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            rs=ps.executeQuery();
            while (rs.next()){
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return num;
    }
    //鏈嶅姟鍒嗛〉
    public List<Service> getService(int status,int begin,int end){
        Connection conn= DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from cst_service c where sv_status=?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setInt(2,begin);
            ps.setInt(3,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }
    //鎵惧埌鎵�湁瀹㈡埛缁忕悊
    public List<User> getAllManager() {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select u.* from sys_user u,sys_role r where u.u_role_id=r.role_id and r.role_name='客户经理'";
        List<User> users=new ArrayList<User>();
        User u=null;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                u=new User();
                u.setU_id(rs.getInt(1));
                u.setU_name(rs.getString(2));
                u.setU_pwd(rs.getString(3));
                u.setU_role_id(rs.getInt(4));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return users;
    }
    //鍒嗛厤澶勭悊
    public Boolean Dueto(int id, String manager,String newTime) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        int result=0;
        String sql="update cst_service set sv_dueto=? , sv_duedate=? ,sv_status=2 where sv_id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,manager);
            ps.setString(2,newTime);
            ps.setInt(3,id);
            result=ps.executeUpdate();
            if (result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        return false;
    }
    //鍒犻櫎鏈嶅姟
    public Boolean Delete(int id) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        int result=0;
        String sql="DELETE FROM cst_service WHERE sv_id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            result=ps.executeUpdate();
            if (result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        return false;
    }
    //鎸塈D鏌ユ壘鏈嶅姟
    public Service getServiceById(int id) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from cst_service where sv_id=?";
        Service service=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return service;
    }
    //鏈嶅姟澶勭悊
    public Boolean dealService(int id,String deal,String dealby,String dealdate){
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        int result=0;
        String sql="update cst_service set sv_deal=? , sv_dealby=? ,sv_dealdate=?,sv_status=3 where sv_id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,deal);
            ps.setString(2,dealby);
            ps.setString(3,dealdate);
            ps.setInt(4,id);
            result=ps.executeUpdate();
            if (result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        return false;
    }
    public Boolean feedService(int sv_id,String result,int satisfy){
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        int done=0;
        String sql="update cst_service set sv_result=? , sv_satisfy=? ,sv_status=4 where sv_id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,result);
            ps.setInt(2,satisfy);
            ps.setInt(3,sv_id);
            done=ps.executeUpdate();
            if (done>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,null);
        }
        return false;
    }
  //重新分配
  	public void dueToBack(int sv_id) {
  		// TODO Auto-generated method stub
  		Connection conn=DBUtil.getConn();
          PreparedStatement ps=null;
          String sql="update cst_service set sv_status=1,sv_dueto=null,sv_duedate=null,sv_deal=null,sv_dealby=null,sv_dealdate=null where sv_id=?";
          try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sv_id);
			int i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
  	}

    public List<Service> getSearchService(int status,String custname ,String title, String type, String time1, String time2,int begin,int end) {
        List<Service> list=null;
        if (begin==end&&end==0){
            if ("0".equals(type)){
                list=getSearchNumAllType(status,custname,title,time1,time2);
                if (custname.isEmpty()){
                    list=getSearchNumAllTypeTwo(status,title,time1,time2);
                    if (title.isEmpty()){
                        list=getSearchNumAllTypeThree(status,time1,time2);
                    }
                }else if (title.isEmpty()){
                    list=getSearchNumAllTypeFour(status,custname,time1,time2);
                }
            }else{
                list=getSearchNumAll(status,custname,title,type,time1,time2);
                if (custname.isEmpty()){
                    list=getSearchNumAllTwo(status,title,type,time1,time2);
                    if (title.isEmpty()){
                        list=getSearchNumAllThree(status,type,time1,time2);
                    }
                }else if (title.isEmpty()){
                    list=getSearchNumAllFour(status,custname,type,time1,time2);
                }
            }
        }else{
            if ("0".equals(type)){
                list=getServiceAllType(status,custname,title,time1,time2,begin,end);
                if (custname.isEmpty()){
                    list=getServiceAllTypeTwo(status,title,time1,time2,begin,end);
                    if (title.isEmpty()){
                        list=getServiceAllTypeThree(status,time1,time2,begin,end);
                    }
                }else if (title.isEmpty()){
                    list=getServiceAllTypeFour(status,custname,time1,time2,begin,end);
                }
            }else{
                list=getServiceAll(status,custname,title,type,time1,time2,begin,end);
                if (custname.isEmpty()){
                    list=getServiceAllTwo(status,title,type,time1,time2,begin,end);
                    if (title.isEmpty()){
                        list=getServiceAllThree(status,type,time1,time2,begin,end);
                    }
                }else if (title.isEmpty()){
                    list=getServiceAllFour(status,custname,type,time1,time2,begin,end);
                }
            }
        }
        return list;
    }

    private List<Service> getServiceAllFour(int status, String custname, String type, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_custname? and c.sv_type=? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,type);
            ps.setString(4,time1);
            ps.setString(5,time2);
            ps.setInt(6,begin);
            ps.setInt(7,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAllThree(int status, String type, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_type=? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,type);
            ps.setString(3,time1);
            ps.setString(4,time2);
            ps.setInt(5,begin);
            ps.setInt(6,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAllTwo(int status, String title, String type, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_title like ? and c.sv_type=? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,"%"+title+"%");
            ps.setString(3,type);
            ps.setString(4,time1);
            ps.setString(5,time2);
            ps.setInt(6,begin);
            ps.setInt(7,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAll(int status, String custname, String title, String type, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_custname=? and c.sv_title like ? and c.sv_type=? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,"%"+title+"%");
            ps.setString(4,type);
            ps.setString(5,time1);
            ps.setString(6,time2);
            ps.setInt(7,begin);
            ps.setInt(8,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAllTypeFour(int status, String custname, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.custname=? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,time1);
            ps.setString(4,time2);
            ps.setInt(5,begin);
            ps.setInt(6,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAllTypeThree(int status, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,time1);
            ps.setString(3,time2);
            ps.setInt(4,begin);
            ps.setInt(5,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAllTypeTwo(int status, String title, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_title like ? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,"%"+title+"%");
            ps.setString(3,time1);
            ps.setString(4,time2);
            ps.setInt(5,begin);
            ps.setInt(6,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getServiceAllType(int status, String custname, String title, String time1, String time2, int begin, int end) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from(select rownum rn,c.* from CST_SERVICE c where c.sv_status=? and c.sv_custname=? and c.sv_title like ? and c.sv_createdate Between ? and ?)Y where Y.rn>=? and Y.rn<=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,"%"+title+"%");
            ps.setString(4,time1);
            ps.setString(5,time2);
            ps.setInt(6,begin);
            ps.setInt(7,end);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                service.setSv_id(rs.getInt("sv_id"));
                service.setSv_type(rs.getString("sv_type"));
                service.setSv_title(rs.getString("sv_title"));
                service.setSv_custname(rs.getString("sv_custname"));
                service.setSv_status(rs.getInt("sv_status"));
                service.setSv_request(rs.getString("sv_request"));
                service.setSv_createby(rs.getString("sv_createby"));
                service.setSv_createdate(rs.getString("sv_createdate"));
                service.setSv_dueto(rs.getString("sv_dueto"));
                service.setSv_duedate(rs.getString("sv_duedate"));
                service.setSv_deal(rs.getString("sv_deal"));
                service.setSv_dealby(rs.getString("sv_dealby"));
                service.setSv_dealdate(rs.getString("sv_dealdate"));
                service.setSv_result(rs.getString("sv_result"));
                service.setSv_satisfy(rs.getInt("sv_satisfy"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAllFour(int status, String custname, String type, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_custname=? and sv_type=? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,type);
            ps.setString(4,time1);
            ps.setString(5,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAllThree(int status, String type, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_type=? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,type);
            ps.setString(3,time1);
            ps.setString(4,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAllTwo(int status, String title, String type, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_title like ? and sv_type=? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,"%"+title+"%");
            ps.setString(3,type);
            ps.setString(4,time1);
            ps.setString(5,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAll(int status, String custname, String title, String type, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_custname=? and sv_title like ? and sv_type=? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,"%"+title+"%");
            ps.setString(4,type);
            ps.setString(5,time1);
            ps.setString(6,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAllTypeFour(int status, String custname, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_custname=? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,time1);
            ps.setString(4,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAllTypeThree(int status, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,time1);
            ps.setString(3,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    private List<Service> getSearchNumAllTypeTwo(int status, String title, String time1, String time2) {
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_title like ? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,"%"+title+"%");
            ps.setString(3,time1);
            ps.setString(4,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }

    public List<Service> getSearchNumAllType(int status,String custname ,String title, String time1, String time2){
        Connection conn=DBUtil.getConn();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Service> list=new ArrayList<Service>();
        String sql="select * from CST_SERVICE where sv_status=? and sv_custname=? and sv_title like ? and sv_createdate Between ? and ?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setString(2,custname);
            ps.setString(3,"%"+title+"%");
            ps.setString(4,time1);
            ps.setString(5,time2);
            rs=ps.executeQuery();
            while (rs.next()){
                Service service=new Service();
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn,ps,rs);
        }
        return list;
    }
    
}