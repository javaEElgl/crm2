package basd.dao;



import java.util.ArrayList;

import basd.entity.Dict;

public interface DictDao {
    //返回全部数据字典信息
    ArrayList<Dict> searchDict();

    //按条件返回全部数据字典信息
    ArrayList<Dict> searchDict(String d_type, String d_item, String d_value);

    //新建数据字典条目
    boolean addDict(String d_type, String d_item, String d_value, String p_isedit);

    //修改数据字典条目
    boolean updateDict(String d_type, String d_item, String d_value, String p_isedit, String id);
    
    //通过字典类型找到所有
    ArrayList<Dict> find(Dict d);

}
