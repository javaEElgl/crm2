package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basd.dao.impl.ProductDaoImpl;
import basd.entity.Product;

@WebServlet(value="/AllProductServlet")
public class AllProductServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String name = request.getParameter("name");
			Product product = new ProductDaoImpl().findByName(name);
			String unit = product.getP_unit();
			String price = product.getP_price();
			response.getWriter().print(unit+"-"+price);
		}
}
