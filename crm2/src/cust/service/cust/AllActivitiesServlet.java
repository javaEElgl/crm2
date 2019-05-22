package cust.service.cust;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.ActivityDaoImpl;
import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Activity;
import cust.entity.Customer;

@WebServlet(value="/AllActivitiesServlet")
public class AllActivitiesServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Customer c = new CustomerDaoImpl().findById(id);
			List<Activity> list = new ActivityDaoImpl().find(c);
			request.setAttribute("list", list);
			request.setAttribute("c", c);
			request.getRequestDispatcher("html/~cust/cust/activities.jsp").forward(request, response);
		}
}
