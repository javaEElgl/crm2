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

@WebServlet(value="/EditUserServlet")
public class EditUserServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getParameter("action");
			if("before".equals(action)){
				int id = Integer.parseInt(request.getParameter("id"));
				User user = new UserDaoImpl().findById(id);
				request.setAttribute("user", user);
				List<Role> rlist = new RoleDaoImpl().find();
				request.setAttribute("rlist", rlist);
				request.getRequestDispatcher("html/~right/user_edit.jsp").forward(request, response);
			}else{
				int id = Integer.parseInt(request.getParameter("id"));
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				int roleId = Integer.parseInt(request.getParameter("role"));
				User u=new User();
				u.setUserId(id);
				u.setUserName(username);
				u.setPassWord(password);
				Role role=new RoleDaoImpl().find(roleId);
				u.setRole(role);
				if(new UserDaoImpl().update(u)){
					response.getWriter().print("<script>alert('更新成功！')</script>");
					response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
				}else{
					response.getWriter().print("<script>alert('更新失败！')</script>");
					response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
				}
			}
		}
}
