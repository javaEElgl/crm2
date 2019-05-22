package sale.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;


@WebServlet(value="/FindServlet")
public class FindServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String name = request.getParameter("customerName");
			String title = request.getParameter("state");
			String contact= request.getParameter("contactName");
			if("".equals(name)&&"".equals(title)&&"".equals(contact)){
				response.sendRedirect("ShowAllSaleServlet");
				return ;
			}
			Sale sale=new Sale(name, contact, title);
			List<Sale> list = new SaleDaoImpl().find(sale);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/html/~sale/list.jsp").forward(request, response);
		}
}
