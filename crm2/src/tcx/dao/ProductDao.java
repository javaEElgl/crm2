package tcx.dao;



import java.util.ArrayList;
import java.util.List;

import tcx.pojo.Dict;
import tcx.pojo.Product;

public interface ProductDao {
	//�ṩ��ҳ����
	public List<Product> splitPage(List<Product> list ,int begin,int end); 
    //�������в�Ʒ��Ϣ
    ArrayList<Product> searchProduct();
    //���������ز�Ʒ��Ϣ
    ArrayList<Product> searchProductByCondition(String name,String type,String batch);
}
