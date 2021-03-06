package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.PlanDaoImpl;
import sale.entity.Plan;

@WebServlet(value="/SavePlanServlet")
public class SavePlanServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("sid"));
		int pid = Integer.parseInt(request.getParameter("id"));
		String todo=request.getParameter("todo");
		Plan plan=new Plan();
		plan.setId(pid);
		plan.setTodo(todo);
		//找到该计划并更改
		if(new PlanDaoImpl().update(plan)){
			response.getWriter().print("<script>alert('保存成功！')</script>");
			response.getWriter().print("<script>window.location.href='MakePlanServlet?id="+id+"'</script>");
		}else{
			response.getWriter().print("<script>alert('保存失败！')</script>");
			response.getWriter().print("<script>window.location.href='MakePlanServlet?id='"+id+"'</script>");
		}
	}
}
