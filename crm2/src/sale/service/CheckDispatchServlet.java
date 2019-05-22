package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;


@WebServlet(value="/CheckDispatchServlet")
public class CheckDispatchServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			Sale sale = new SaleDaoImpl().findById(id);
			if(sale.getDueName()!=null){
				response.getWriter().print("yes");
			}else{
				response.getWriter().print("no");
			}
		}
}
