package cust.service.cust;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;
import cust.dao.impl.LinkManDaoImpl;
import cust.entity.Customer;
import cust.entity.Linkman;

@WebServlet(value="/AllLinkServlet")
public class AllLinkServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer c=new Customer();
		c.setID(id);
		List<Linkman> list = new LinkManDaoImpl().find(c);
		request.setAttribute("list", list);
		Customer cust=new CustomerDaoImpl().findById(id);
		request.setAttribute("c", cust);
		request.getRequestDispatcher("html/~cust/cust/linkman.jsp").forward(request, response);
		}
}
