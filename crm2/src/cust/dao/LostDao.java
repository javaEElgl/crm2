package cust.dao;

import java.util.List;

import cust.entity.Customer;
import cust.entity.Lost;


public interface LostDao {
		public List<Lost> splitPage(List<Lost> list ,int begin,int end);   //∑÷“≥≤È—Ø
		public List<Lost> find();   
		public List<Lost> find(Lost l);
		public boolean add(Lost l);
		public boolean del(Lost l);
		public boolean update(Lost l);
		public List<Lost> rept(String flag);
		
		public Lost findByCust(Customer c);
		public Lost findById(int id);
		public boolean delay(Lost l);
}
