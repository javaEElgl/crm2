package tcx.dao;



import java.util.ArrayList;
import java.util.List;

import tcx.pojo.Dict;
import tcx.pojo.Storage;

public interface StorageDao {
	//�ṩ��ҳ����
	public List<Storage> splitPage(List<Storage> list ,int begin,int end); 
    //�������п����Ϣ
    ArrayList<Storage> searchStorage();
    //���������ؿ����Ϣ
    ArrayList<Storage> searchStorageByCondition(String p_name,String p_storagename);
}
