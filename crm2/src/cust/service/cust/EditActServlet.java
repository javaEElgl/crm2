package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.ActivityDaoImpl;
import cust.dao.impl.CustomerDaoImpl;
import cust.dao.impl.LinkManDaoImpl;
import cust.entity.Activity;
import cust.entity.Customer;
import cust.entity.Linkman;

@WebServlet(value="/EditActServlet")
public class EditActServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if("before".equals(action)){
			int cid = Integer.parseInt(request.getParameter("cid"));
			int id = Integer.parseInt(request.getParameter("id"));
			Activity a=new ActivityDaoImpl().findById(id);
			Customer c = new CustomerDaoImpl().findById(cid);
			request.setAttribute("a", a);
			request.setAttribute("c", c);
			request.getRequestDispatcher("html/~cust/cust/activites_edit.jsp").forward(request, response);
		}else{
			//这是交往的id
			int id=Integer.parseInt(request.getParameter("id"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			String date = request.getParameter("date");
			String place = request.getParameter("place");
			String title = request.getParameter("title");
			String desc = request.getParameter("desc");
			Activity a=new Activity(id,date, place, title, desc);
			if (new ActivityDaoImpl().update(a)) {
				response.getWriter().print("<script>alert('更新成功！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllActivitiesServlet?id="+cid+"'</script>");
			} else {
				response.getWriter().print("<script>alert('更新失败！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllActivitiesServlet?id="+cid+"'</script>");
			}
		}
	}
}
