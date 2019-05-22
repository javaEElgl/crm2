package cust.service.cust;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basd.dao.impl.ProductDaoImpl;
import basd.entity.Product;

import cust.dao.impl.CustomerDaoImpl;
import cust.dao.impl.LinkManDaoImpl;
import cust.dao.impl.OrdersDaoImpl;
import cust.entity.Customer;
import cust.entity.Linkman;
import cust.entity.Orders;
import cust.entity.OrdersLine;

@WebServlet(value="/AddOrderServlet")
public class AddOrderServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("before".equals(action)) {
				int id=Integer.parseInt(request.getParameter("id"));
				Customer c=new CustomerDaoImpl().findById(id);
				request.setAttribute("c", c);
				//查询所有的产品
				ArrayList<Product> list = new ProductDaoImpl().searchProduct();
				request.setAttribute("list", list);
				request.getRequestDispatcher("html/~cust/cust/orders_add.jsp").forward(request, response);
		} else {
			//获取客户
			int id=Integer.parseInt(request.getParameter("id"));
			Customer c=new CustomerDaoImpl().findById(id);
			//获取订单
			String date = request.getParameter("date");
			int status = Integer.parseInt(request.getParameter("status"));
			String addr = request.getParameter("addr");
			int money = Integer.parseInt(request.getParameter("money"));
			Orders o=new Orders(date,addr,status,money,c);
			//插入订单的时候同时传递订单明细过去
			int count = Integer.parseInt(request.getParameter("count"));
			String unit = request.getParameter("unit");
			int price = Integer.parseInt(request.getParameter("price"));
			String product = request.getParameter("product");
			OrdersLine oLine=new OrdersLine(count, unit, price, product);
			if (new OrdersDaoImpl().add(o,oLine)) {
				response.getWriter().print("<script>alert('创建成功！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllOrdersServlet?id="+id+"'</script>");
			} else {
				response.getWriter().print("<script>alert('创建失败！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllOrdersServlet?id="+id+"'</script>");
			}
		}

	}
}
