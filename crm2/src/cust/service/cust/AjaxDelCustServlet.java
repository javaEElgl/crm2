package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.OrdersDaoImpl;

import tcx.dao.impl.OrderDaoImpl;

@WebServlet("/AjaxDelCustServlet")
public class AjaxDelCustServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				int id=Integer.parseInt(request.getParameter("id"));
				if(new OrdersDaoImpl().findByCustId(id)){
					response.getWriter().print("no");
				}else{
					response.getWriter().print("yes");
				}
		}
}
