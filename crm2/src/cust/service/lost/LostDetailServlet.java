package cust.service.lost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.LostDaoImpl;
import cust.entity.Lost;

@WebServlet(value = "/LostDetailServlet")
public class LostDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Lost l = new LostDaoImpl().findById(id);
		if(l.getDelay()!=null){
			l.setDelay(l.getDelay().replace("-", "\n"));
		}	
		request.setAttribute("l", l);
		request.getRequestDispatcher("html/~cust/lost/detail.jsp").forward(
				request, response);
	}
}
