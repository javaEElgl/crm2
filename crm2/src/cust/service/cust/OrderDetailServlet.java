package cust.service.cust;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.OrdersDaoImpl;
import cust.dao.impl.OrdersLineDaoImpl;
import cust.entity.Orders;
import cust.entity.OrdersLine;

@WebServlet(value="/OrderDetailServlet")
public class OrderDetailServlet  extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				int  id = Integer.parseInt(request.getParameter("id"));
				//查询此订单
				Orders o = new OrdersDaoImpl().findById(id);
				//查询此订单下的订单项 
				List<OrdersLine> list = new OrdersLineDaoImpl().find(o);
				request.setAttribute("o", o);
				System.out.println(o);
				request.setAttribute("list", list);
				request.getRequestDispatcher("html/~cust/cust/orders_detail.jsp").forward(request, response);
		}
}
