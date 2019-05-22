package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Customer;

@WebServlet(value="/DeleteCustServlet")
public class DeleteCustServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				int id=Integer.parseInt(request.getParameter("id"));
				Customer c=new Customer();
				c.setID(id);
				if(new CustomerDaoImpl().del(c)){
					response.getWriter().print("<script>alert('É¾³ý³É¹¦£¡')</script>");
					response.getWriter()
							.print("<script>window.location.href='AllCustServlet</script>");
				} else {
					response.getWriter().print("<script>alert('É¾³ýÊ§°Ü£¡')</script>");
					response.getWriter()
							.print("<script>window.location.href='AllCustServlet'</script>");
				}
		}
}
