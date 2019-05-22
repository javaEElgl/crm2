package cust.service.lost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.LostDaoImpl;
import cust.entity.Lost;

@WebServlet(value="/SaveRelayServlet")
public class SaveRelayServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			String delay=request.getParameter("delay");
			Lost l=new Lost();
			l.setID(id);
			l.setDelay(delay);
			if (new LostDaoImpl().delay(l)) {
				response.getWriter().print("<script>alert('ÔÝ»ºÁ÷Ê§³É¹¦£¡')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllLostServlet1'</script>");
			} else {
				response.getWriter().print("<script>alert('ÔÝ»ºÁ÷Ê§Ê§°Ü£¡')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllLostServlet1'</script>");
			}
		}
}
