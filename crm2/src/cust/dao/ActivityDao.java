package cust.dao;

import java.util.List;

import cust.entity.Activity;
import cust.entity.Customer;


public interface ActivityDao {
		public List<Activity> find();   
		public List<Activity> find(Customer c);
		public boolean add(Activity a);
		public boolean del(Activity a);
		public boolean update(Activity a);
		
		public Activity findById(int id);
}
