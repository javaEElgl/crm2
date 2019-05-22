package auth.dao;
import java.util.List;

import auth.entity.User;



public interface UserDao {
	public User login(String userName,String passWord);     		//��½����
	public List<User> splitPage(List<User>list,int begin,int end);   //��ҳ��ѯ
	public List<User> find();                						//��ѯ����
	public List<User> find(User u);   	//ģ����ѯ
	public boolean add(User u);      	//���
	public boolean del(User u);      	//ɾ��
	public boolean update(User u);   	//�޸�
	
	public User findById(int userId); //����id�ҵ�User����
	public boolean findByName(String username);//����û����Ƿ����
	public User searchByName(String name);//���������ҵ��û�
	public List<User> findByType(String roleName);//���ݽ�ɫ�������û�
}
