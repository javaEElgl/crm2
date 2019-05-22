package auth.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.RoleDaoImpl;

@WebServlet(value="/CheckRoleNameServlet")
public class CheckRoleNameServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String roleName = request.getParameter("rolename");
			boolean flag = new RoleDaoImpl().check(roleName);
			response.getWriter().print(flag);
		}
}
