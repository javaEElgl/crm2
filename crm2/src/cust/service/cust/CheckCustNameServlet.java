package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;

@WebServlet(value="/CheckCustNameServlet")
public class CheckCustNameServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String name=request.getParameter("name");
			if(new CustomerDaoImpl().findByName(name)){
				response.getWriter().print("no");
			}else{
				response.getWriter().print("yes");
			}
		}
}
