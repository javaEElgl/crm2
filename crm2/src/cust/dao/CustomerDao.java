package cust.dao;

import java.util.ArrayList;
import java.util.List;

import cust.entity.Customer;


public interface CustomerDao {
		public List<Customer> splitPage(List<Customer> list ,int begin,int end); 
		public List<Customer> find();   
		public List<Customer> find(Customer c);
		public boolean add(Customer c);
		public boolean del(Customer c);
		public boolean update(Customer c);
		public List<Object[]> rept(String flag);
		
		public int GetMaxNo();
		public Customer findById(int id);
		public ArrayList<Integer> isLost(List<Customer> clist);//1Î´Á÷Ê§£¬2Á÷Ê§
		
		public boolean findByName(String name);
}
