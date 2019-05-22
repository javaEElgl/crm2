package cust.dao;

import java.util.List;

import cust.entity.Servicer;


public interface ServicerDao {
		public List<Servicer> splitPage(int offset,int pageSize); 
		public List<Servicer> find();   
		public List<Servicer> find(Servicer sv);
		public boolean add(Servicer sv);
		public boolean del(Servicer sv);
		public boolean update(Servicer sv);
		public List<Object[]> rept(int flag);
}
