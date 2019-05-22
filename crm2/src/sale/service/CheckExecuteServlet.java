package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;

import cust.dao.impl.CustomerDaoImpl;

import auth.entity.User;

@WebServlet(value="/CheckExecuteServlet")
public class CheckExecuteServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			Sale sale = new SaleDaoImpl().findById(id);
			String name=sale.getDueName();
			if(user.getUserName().equals(name)){
				response.getWriter().print("yes");
			}else{
				response.getWriter().print("no");
			}
		}
}
