package auth.dao;

import java.util.List;

import auth.entity.Right;
import auth.entity.Role_Right;


public interface RoleRightDao {
	 public List<Role_Right> find(int roleId);   //���ݽ�ɫID��ѯ��Ӧ������Ȩ��ID
	 public boolean add(Role_Right rr);			 //���ӽ�ɫȨ��	
	 public boolean del(Role_Right rr);			//ɾ����ɫȨ��
	 public Right findRight(int rightID);    //����Ȩ��ID��ȡ��ӦȨ��
	 
	 public boolean update(int roleId,String [] rights);
}
