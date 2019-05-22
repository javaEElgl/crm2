package cust.dao;

import java.util.List;

import cust.entity.Orders;
import cust.entity.OrdersLine;


public interface OrdersLineDao {
		public List<OrdersLine> find();   
		public List<OrdersLine> find(Orders o);
		public boolean add(OrdersLine ol);
		public boolean del(OrdersLine ol);
		public boolean update(OrdersLine ol);
}
