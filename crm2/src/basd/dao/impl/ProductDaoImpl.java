package basd.dao.impl;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basd.dao.ProductDao;
import basd.entity.Product;

public class ProductDaoImpl implements ProductDao {
    @Override
    public ArrayList<Product> searchProduct() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT";
        ArrayList<Product> productList = new ArrayList<Product>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setP_id(rs.getInt(1));
                product.setP_name(rs.getString(2));
                product.setP_type(rs.getString(3));
                product.setP_batch(rs.getString(4));
                product.setP_unit(rs.getString(5));
                product.setP_price(rs.getString(6));
                product.setP_memo(rs.getString(7));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return productList;
    }

    @Override
    public ArrayList<Product> searchProductByCondition(String name, String type, String batch) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = null;
        ArrayList<Product> productList = null;
        try {
            if (name.equals("")) {
                if (type.equals("")) {
                    if (batch.equals("")) {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT";
                        pst = conn.prepareStatement(sql);
                    }else {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_batch=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,batch);
                    }
                } else {
                    if (batch.equals("")) {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_type=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,type);
                    }else {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_type=? and p_batch=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,type);
                        pst.setString(2,batch);
                    }
                }
            }else {
                if (type.equals("")) {
                    if (batch.equals("")) {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_name=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,name);
                    }else {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_name=? and p_batch=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,name);
                        pst.setString(2,batch);
                    }
                } else {
                    if (batch.equals("")) {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_name=? and p_type=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,name);
                        pst.setString(2,type);
                    }else {
                        sql="select p_id,p_name,p_type,p_batch,p_unit,p_price,p_memo from BASD_PRODUCT where p_name=? and p_type=? and p_batch=?";
                        pst = conn.prepareStatement(sql);
                        pst.setString(1,name);
                        pst.setString(2,type);
                        pst.setString(3,batch);
                    }
                }
            }
            productList=new ArrayList<Product>();
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setP_id(rs.getInt(1));
                product.setP_name(rs.getString(2));
                product.setP_type(rs.getString(3));
                product.setP_batch(rs.getString(4));
                product.setP_unit(rs.getString(5));
                product.setP_price(rs.getString(6));
                product.setP_memo(rs.getString(7));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn, pst, rs);
        }
        return productList;
    }

	@Override
	public Product findByName(String name) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Product p=null;
		String sql="select * from basd_product where p_name=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			if(rs.next()){
				p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						String.valueOf(rs.getInt(6)), rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn, pst, rs);
		}
		return p;
	}
}