package auth.dao;
import java.util.List;

import auth.entity.User;



public interface UserDao {
	public User login(String userName,String passWord);     		//登陆方法
	public List<User> splitPage(List<User>list,int begin,int end);   //分页查询
	public List<User> find();                						//查询所有
	public List<User> find(User u);   	//模糊查询
	public boolean add(User u);      	//添加
	public boolean del(User u);      	//删除
	public boolean update(User u);   	//修改
	
	public User findById(int userId); //根据id找到User对象
	public boolean findByName(String username);//检查用户名是否存在
	public User searchByName(String name);//根据名字找到用户
	public List<User> findByType(String roleName);//根据角色名查找用户
}
