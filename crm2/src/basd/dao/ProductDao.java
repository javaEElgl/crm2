package basd.dao;



import java.util.ArrayList;

import basd.entity.Product;

public interface ProductDao {
    //�������в�Ʒ��Ϣ
    ArrayList<Product> searchProduct();
    //���������ز�Ʒ��Ϣ
    ArrayList<Product> searchProductByCondition(String name,String type,String batch);
    //ͨ�������ҵ���Ʒ
    public Product findByName(String name);
}
