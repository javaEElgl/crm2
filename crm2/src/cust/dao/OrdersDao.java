package cust.dao;

import java.util.List;

import cust.entity.Customer;
import cust.entity.Orders;
import cust.entity.OrdersLine;


public interface OrdersDao {
		public List<Orders> splitPage(List<Orders> list ,int begin,int end); 
		public List<Orders> find();   
		public List<Orders> find(Customer c);
		public boolean add(Orders o,OrdersLine oLine);
		public boolean del(Orders o);
		public boolean update(Orders o);
		public List<Object[]> rept();
		
		public Orders findById(int id);
		public int getID();
		public boolean findByCustId(int cid);//查看指定客户是否下了订单
}
