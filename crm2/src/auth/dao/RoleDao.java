package auth.dao;

import java.util.List;

import auth.entity.Role;


public interface RoleDao {
	public List<Role> splitPage(List<Role> list,int begin,int end);   //��ҳ��ѯ
	public Role find(int roleID); 
	public List<Role> find();  //��ѯ����
	public List<Role> find(Role role);  
	public boolean add(Role role,String []list);	 //���ӽ�ɫ 
	public boolean del(Role role);   //ɾ����ɫ
	public boolean update(Role role); //�޸Ľ�ɫ
	
	public boolean check(String roleName);
	//public int findByName(String roleName); //���ݽ�ɫ�������ҵ���ɫ��id
 	
}
