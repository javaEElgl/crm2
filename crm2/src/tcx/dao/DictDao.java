package tcx.dao;



import java.util.ArrayList;
import java.util.List;

import cust.entity.Customer;

import tcx.pojo.Dict;

public interface DictDao {
	//�ṩ��ҳ����
	public List<Dict> splitPage(List<Dict> list ,int begin,int end); 
	//��ѯ���е�Type����
	public List<String> getType();
	
    //����ȫ�������ֵ���Ϣ
    ArrayList<Dict> searchDict();

    //����������ȫ�������ֵ���Ϣ
    ArrayList<Dict> searchDict(String d_type, String d_item, String d_value);

    //�½������ֵ���Ŀ
    boolean addDict(String d_type, String d_item, String d_value, String p_isedit);

    //�޸������ֵ���Ŀ
    boolean updateDict(String d_type, String d_item, String d_value, String p_isedit, String id);

    //ɾ�������ֵ���Ŀ
    boolean delDict(int id);
}
