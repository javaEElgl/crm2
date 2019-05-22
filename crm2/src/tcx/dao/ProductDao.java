package tcx.dao;



import java.util.ArrayList;
import java.util.List;

import tcx.pojo.Dict;
import tcx.pojo.Product;

public interface ProductDao {
	//提供分页功能
	public List<Product> splitPage(List<Product> list ,int begin,int end); 
    //返回所有产品信息
    ArrayList<Product> searchProduct();
    //按条件返回产品信息
    ArrayList<Product> searchProductByCondition(String name,String type,String batch);
}
