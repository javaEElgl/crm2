package auth.dao;

import java.util.List;

import auth.entity.Right;
import auth.entity.Role_Right;


public interface RoleRightDao {
	 public List<Role_Right> find(int roleId);   //根据角色ID查询对应的所有权限ID
	 public boolean add(Role_Right rr);			 //增加角色权限	
	 public boolean del(Role_Right rr);			//删除角色权限
	 public Right findRight(int rightID);    //根据权限ID获取对应权限
	 
	 public boolean update(int roleId,String [] rights);
}
