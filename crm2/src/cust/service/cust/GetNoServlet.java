package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;

@WebServlet(value="/GetNoServlet")
public class GetNoServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				int maxNo = new CustomerDaoImpl().GetMaxNo()+1;
				response.getWriter().print(maxNo);
		}
}
