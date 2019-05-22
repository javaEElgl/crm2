package auth.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.RoleDaoImpl;
import auth.entity.Role;
import auth.entity.Role_Right;

@WebServlet(value="/AddRoleServlet")
public class AddRoleServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//��ȡ���ύ������
			String roleName = request.getParameter("rolename");
			String[] list = request.getParameterValues("rightCode");
			Role role=new Role();
			role.setRoleName(roleName);
			if(new RoleDaoImpl().add(role,list)){
				response.getWriter().print("<script>alert('�����ɹ���')</script>");
				response.getWriter().print("<script>window.location.href='AllRoleServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('����ʧ�ܣ�')</script>");
				response.getWriter().print("<script>window.location.href='AllRoleServlet'</script>");
			}
		}
}
