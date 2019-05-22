package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;


@WebServlet(value="/DeleteSaleServlet")
public class DeleteSaleServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id =Integer.parseInt(request.getParameter("id"));
			Sale sale=new Sale();
			sale.setId(id);
			if(new SaleDaoImpl().del(sale)){
				response.getWriter().print("<script>alert('É¾³ý³É¹¦£¡');</script>");
			}else{
				response.getWriter().print("<script>alert('É¾³ýÊ§°Ü£¡');</script>");
			}
			response.getWriter().print("<script>window.location.href='ShowAllSaleServlet';</script>");
		}
}
