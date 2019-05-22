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

@WebServlet(value="/ExecuteServlet")
public class ExecuteServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				int id=Integer.parseInt(request.getParameter("id"));
				String result = request.getParameter("result");
				String todo = request.getParameter("todo");
				int  sid = Integer.parseInt(request.getParameter("sid"));
				Plan plan=new Plan();
				plan.setId(id);
				plan.setResult(result);
				plan.setTodo(todo);
				Sale sale=new SaleDaoImpl().findById(sid);
				if(new PlanDaoImpl().execute(plan, sale)){
					response.getWriter().print("<script>alert('执行成功！')</script>");
				}else {
					response.getWriter().print("<script>alert('执行失败！')</script>");
				}
				response.getWriter().print("<script>window.location.href='DevExecuteServlet?id="+sid+"'</script>");
		}
}
