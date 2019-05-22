package auth.dao;

import java.util.List;

import auth.entity.Role;


public interface RoleDao {
	public List<Role> splitPage(List<Role> list,int begin,int end);   //分页查询
	public Role find(int roleID); 
	public List<Role> find();  //查询所有
	public List<Role> find(Role role);  
	public boolean add(Role role,String []list);	 //增加角色 
	public boolean del(Role role);   //删除角色
	public boolean update(Role role); //修改角色
	
	public boolean check(String roleName);
	//public int findByName(String roleName); //根据角色的名字找到角色的id
 	
}
