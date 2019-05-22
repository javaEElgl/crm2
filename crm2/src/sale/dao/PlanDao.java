package sale.dao;

import java.util.List;

import sale.entity.Plan;
import sale.entity.Sale;



public interface PlanDao {
	public List<Plan> find();   				//查询所有
	public List<Plan> find(Sale s);   			//根据Sale编号查计划		
	public boolean add(Plan plan);				//添加
	public boolean del(Plan plan);				//删除
	public boolean update(Plan plan);           //修改
	public boolean execute(Plan plan ,Sale sale); //执行计划
}
