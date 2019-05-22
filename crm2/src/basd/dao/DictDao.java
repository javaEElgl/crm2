package basd.dao;



import java.util.ArrayList;

import basd.entity.Dict;

public interface DictDao {
    //����ȫ�������ֵ���Ϣ
    ArrayList<Dict> searchDict();

    //����������ȫ�������ֵ���Ϣ
    ArrayList<Dict> searchDict(String d_type, String d_item, String d_value);

    //�½������ֵ���Ŀ
    boolean addDict(String d_type, String d_item, String d_value, String p_isedit);

    //�޸������ֵ���Ŀ
    boolean updateDict(String d_type, String d_item, String d_value, String p_isedit, String id);
    
    //ͨ���ֵ������ҵ�����
    ArrayList<Dict> find(Dict d);

}
