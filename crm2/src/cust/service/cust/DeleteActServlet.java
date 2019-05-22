package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.ActivityDaoImpl;
import cust.entity.Activity;

@WebServlet(value="/DeleteActServlet")
public class DeleteActServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			Activity a=new Activity();
			a.setID(id);
			if(new ActivityDaoImpl().del(a)){
				response.getWriter().print("<script>alert('É¾³ý³É¹¦£¡')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllActivitiesServlet?id="+cid+"'</script>");
			} else {
				response.getWriter().print("<script>alert('É¾³ýÊ§°Ü£¡')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllActivitiesServlet?id="+cid+"'</script>");
			}
		}
}
