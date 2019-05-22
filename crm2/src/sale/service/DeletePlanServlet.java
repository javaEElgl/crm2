package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.PlanDaoImpl;
import sale.entity.Plan;

@WebServlet(value="/DeletePlanServlet")
public class DeletePlanServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("sid"));
			int pid = Integer.parseInt(request.getParameter("id"));
			Plan plan=new Plan();
			plan.setId(pid);
			//找打该计划并删除
			if(new PlanDaoImpl().del(plan)){
				response.getWriter().print("<script>alert('删除成功！')</script>");
				response.getWriter().print("<script>window.location.href='MakePlanServlet?id="+id+"'</script>");
			}else{
				response.getWriter().print("<script>alert('删除失败！')</script>");
				response.getWriter().print("<script>window.location.href='MakePlanServlet?id='"+id+"'</script>");
			}
		}
}
