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

@WebServlet(value="/DetailServlet")
public class DetailServlet  extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			//查询该Sale信息
			Sale sale = new SaleDaoImpl().findById(id);
			sale.setStatus(new SaleDaoImpl().status(sale));
			//查询该Sale所有的plan
			List<Plan> plist = new PlanDaoImpl().find(sale);
			sale.setPlan(plist);
			request.setAttribute("s", sale);
			request.getRequestDispatcher("html/~sale/dev_detail.jsp").forward(request, response);
		}
}
