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
			//ɾ����id��Ӧ��user����
			if(new UserDaoImpl().del(u)){
				response.getWriter().print("<script>alert('ɾ���ɹ���')</script>");
				response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('ɾ��ʧ�ܣ�')</script>");
				response.getWriter().print("<script>window.location.href='AllUserServlet'</script>");
			}
		}
}
