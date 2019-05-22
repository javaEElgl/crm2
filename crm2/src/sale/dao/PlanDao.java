package sale.dao;

import java.util.List;

import sale.entity.Plan;
import sale.entity.Sale;



public interface PlanDao {
	public List<Plan> find();   				//��ѯ����
	public List<Plan> find(Sale s);   			//����Sale��Ų�ƻ�		
	public boolean add(Plan plan);				//���
	public boolean del(Plan plan);				//ɾ��
	public boolean update(Plan plan);           //�޸�
	public boolean execute(Plan plan ,Sale sale); //ִ�мƻ�
}
