package basd.dao;



import java.util.ArrayList;

import basd.entity.Product;

public interface ProductDao {
    //返回所有产品信息
    ArrayList<Product> searchProduct();
    //按条件返回产品信息
    ArrayList<Product> searchProductByCondition(String name,String type,String batch);
    //通过名字找到产品
    public Product findByName(String name);
}
