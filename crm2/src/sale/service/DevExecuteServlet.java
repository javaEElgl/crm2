package sale.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.PlanDaoImpl;
import sale.dao.impl.SaleDaoImpl;
import sale.entity.Plan;
import sale.entity.Sale;

@WebServlet(value="/DevExecuteServlet")
public class DevExecuteServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Sale sale = new SaleDaoImpl().findById(id);
			List<Plan> plist = new PlanDaoImpl().find(sale);
			request.setAttribute("s", sale);
			request.setAttribute("plist", plist);
			request.getRequestDispatcher("html/~sale/dev_execute.jsp").forward(request, response);
		}
}
