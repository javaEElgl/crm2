package auth.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.RoleDaoImpl;
import auth.entity.Role;

@WebServlet(value="/DeleteRoleServlet")
public class DeleteRoleServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Role role=new Role();
			role.setRoleId(id);
			if(new RoleDaoImpl().del(role)){
				response.getWriter().print("<script>alert('É¾³ý³É¹¦£¡')</script>");
				response.getWriter().print("<script>window.location.href='AllRoleServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('É¾³ýÊ§°Ü£¡')</script>");
				response.getWriter().print("<script>window.location.href='AllRoleServlet'</script>");
			}
		}
}
