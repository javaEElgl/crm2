package auth.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.dao.impl.UserDaoImpl;
import auth.entity.User;

@WebServlet(value="/LoginServlet")
public class LoginServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user=new UserDaoImpl().login(username, password);
			if(user!=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.getWriter().print("<script>alert('欢迎光临!"+username+"')</script>");
				response.getWriter().print("<script>window.location.href='html/index.jsp'</script>");
			}else{
				response.getWriter().print("<script>alert('用户名或密码错误！')</script>");
				response.getWriter().print("<script>window.location.href='login.jsp'</script>");
			}
		}
}
