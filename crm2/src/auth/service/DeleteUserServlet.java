package auth.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.UserDaoImpl;
import auth.entity.User;


@WebServlet(value="/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int  id = Integer.parseInt(request.getParameter("id"));
			User u=new User();
			u.setUserId(id);
			//删除此id对应的user对象
			if(new UserDaoImpl().del(u)){
				response.getWriter().print("<script>alert('删除成功！')</script>");
				response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('删除失败！')</script>");
				response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
			}
		}
}
