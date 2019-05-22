package tcx.dao.impl;


import tcx.dao.ProductDao;
import tcx.pojo.Dict;
import tcx.pojo.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Product> splitPage(List<Product> list, int begin, int end) {
		ArrayList<Product> l = new ArrayList<Product>();
		for (int i = begin; i <= end; i++) {
			if (i > list.size()) {
				return l;
			}
			l.add(list.get(i - 1));
		}
		return l;
	}
}