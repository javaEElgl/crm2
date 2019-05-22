package cust.service.lost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.LostDaoImpl;
import cust.entity.Lost;

@WebServlet(value = "/ConfirmLostServlet1")
public class ConfirmLostServlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("before".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Lost l = new LostDaoImpl().findById(id);
			if(l.getDelay()!=null){
				l.setDelay(l.getDelay().replace("-", "\n"));
			}	
			request.setAttribute("l", l);
			request.getRequestDispatcher("html/~cust/lost/confirm.jsp")
					.forward(request, response);
			return;
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			String lostdate = request.getParameter("lostdate");
			String reason=request.getParameter("reason");
			Lost l = new Lost();
			l.setLostdate(lostdate);
			l.setID(id);
			l.setReason(reason);
			if (new LostDaoImpl().update(l)) {
				response.getWriter().print("<script>alert('流失成功！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllLostServlet1'</script>");
			} else {
				response.getWriter().print("<script>alert('流失失败！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllLostServlet1'</script>");
			}
		}
	}
}
