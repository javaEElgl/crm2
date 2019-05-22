package sale.dao;

import java.util.List;

import sale.entity.Sale;

public interface SaleDao {
	public List<Sale> splitPage(List<Sale> list,int begin,int end);   //分页查询
	public List<Sale> find();   		        //查询所有
	public List<Sale> find(Sale sale);   		//根据指定信息查询
	public boolean add(Sale sale);				//添加
	public boolean del(Sale sale);				//删除
	public boolean update(Sale sale);           //修改
	
	public Sale findById(int id);//根据id查询指定的Sale
	public boolean dispatch(Sale sale); //指派任务
	public int count();//统计记录行数
	public int status(Sale sale);//查看任务状态
	public boolean finish(Sale sale);//任务开发结束
}
