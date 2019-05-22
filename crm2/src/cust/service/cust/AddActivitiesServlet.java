package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.ActivityDaoImpl;
import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Activity;
import cust.entity.Customer;

@WebServlet(value = "/AddActivitiesServlet")
public class AddActivitiesServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if("before".equals(action)){
			int id = Integer.parseInt(req.getParameter("id"));
			Customer c=new CustomerDaoImpl().findById(id);
			req.setAttribute("c", c);
			req.getRequestDispatcher("html/~cust/cust/activities_add.jsp").forward(req, response);
		}else{
			int id = Integer.parseInt(req.getParameter("id"));
			Customer c=new CustomerDaoImpl().findById(id);
			String date = req.getParameter("date");
			String place = req.getParameter("place");
			String title = req.getParameter("title");
			String desc = req.getParameter("desc");
			Activity a=new Activity(date, place, title, desc, c);
			if(new ActivityDaoImpl().add(a)){
				response.getWriter().print("<script>alert('创建成功！')</script>");
				response.getWriter().print("<script>window.location.href='AllActivitiesServlet?id="+id+"'</script>");
			}else{
				response.getWriter().print("<script>alert('创建失败！')</script>");
				response.getWriter().print("<script>window.location.href='AllActivitiesServlet?id="+id+"'</script>");
			}
		}
	}
}
