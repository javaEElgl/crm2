package tcx.dao;



import java.util.ArrayList;
import java.util.List;

import cust.entity.Customer;

import tcx.pojo.Dict;

public interface DictDao {
	//提供分页功能
	public List<Dict> splitPage(List<Dict> list ,int begin,int end); 
	//查询所有的Type类型
	public List<String> getType();
	
    //返回全部数据字典信息
    ArrayList<Dict> searchDict();

    //按条件返回全部数据字典信息
    ArrayList<Dict> searchDict(String d_type, String d_item, String d_value);

    //新建数据字典条目
    boolean addDict(String d_type, String d_item, String d_value, String p_isedit);

    //修改数据字典条目
    boolean updateDict(String d_type, String d_item, String d_value, String p_isedit, String id);

    //删除数据字典条目
    boolean delDict(int id);
}
