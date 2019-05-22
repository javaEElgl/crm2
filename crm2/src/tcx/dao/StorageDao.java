package tcx.dao;



import java.util.ArrayList;
import java.util.List;

import tcx.pojo.Dict;
import tcx.pojo.Storage;

public interface StorageDao {
	//提供分页功能
	public List<Storage> splitPage(List<Storage> list ,int begin,int end); 
    //返回所有库存信息
    ArrayList<Storage> searchStorage();
    //按条件返回库存信息
    ArrayList<Storage> searchStorageByCondition(String p_name,String p_storagename);
}
