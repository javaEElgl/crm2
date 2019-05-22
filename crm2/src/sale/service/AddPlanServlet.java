package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.PlanDaoImpl;
import sale.dao.impl.SaleDaoImpl;
import sale.entity.Plan;
import sale.entity.Sale;

@WebServlet(value="/AddPlanServlet")
public class AddPlanServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Sale sale = new SaleDaoImpl().findById(id);
			String date=request.getParameter("date");
			String todo = request.getParameter("todo");
			Plan plan=new Plan();
			plan.setDate(date);
			plan.setSale(sale);
			plan.setTodo(todo);
			if(new PlanDaoImpl().add(plan)){
				response.getWriter().print("<script>alert('计划成功！')</script>");
				response.getWriter().print("<script>window.location.href='MakePlanServlet?id="+id+"'</script>");
			}else{
				response.getWriter().print("<script>alert('计划失败！')</script>");
				response.getWriter().print("<script>window.location.href='MakePlanServlet?id='"+id+"'</script>");
			}
		}
}
