package auth.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.RoleDaoImpl;
import auth.dao.impl.UserDaoImpl;
import auth.entity.Role;
import auth.entity.User;

@WebServlet(value="/AddUserServlet")
public class AddUserServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getParameter("action");
			if("before".equals(action)){
				List<Role> list = new RoleDaoImpl().find();
				request.setAttribute("list", list);
			request.getRequestDispatcher("html/~right/user_add.jsp").forward(request, response);
			}else{
				String username = request.getParameter("username");
				String pwd = request.getParameter("password");
				int  roleId = Integer.parseInt(request.getParameter("role"));
				//找到该角色
				Role role = new RoleDaoImpl().find(roleId);
				User u=new User();
				u.setUserName(username);
				u.setPassWord(pwd);
				u.setRole(role);
				if(new UserDaoImpl().add(u)){
					response.getWriter().print("<script>alert('创建成功！')</script>");
					response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
				}else{
					response.getWriter().print("<script>alert('创建失败！')</script>");
					response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
				}
			}
		}
}
