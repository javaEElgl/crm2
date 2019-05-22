package cust.dao;

import java.util.List;

import cust.entity.Customer;
import cust.entity.Linkman;


public interface LinkmanDao {
		public List<Linkman> find();   
		public List<Linkman> find(Customer c);
		public boolean add(Linkman l);
		public boolean del(Linkman l);
		public boolean update(Linkman l);
		public Linkman findById(int id);//通过id找到联系人对象
}
