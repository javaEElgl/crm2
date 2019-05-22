package auth.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.RoleDaoImpl;
import auth.dao.impl.RoleRightDaoImpl;
import auth.entity.Role;
import auth.entity.Role_Right;

@WebServlet(value="/EditRightServlet")
public class EditRightServlet extends HttpServlet{
			@Override
			protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
					String action =request.getParameter("action");
					if("before".equals(action)){
						int  id = Integer.parseInt(request.getParameter("id"));
						Role role = new RoleDaoImpl().find(id);
						ArrayList<Role_Right> role_right = role.getRole_right();
						String right="";
						for(int i=1;i<=18;i++){
							for(int j=0;j<role_right.size();j++){
								if(role_right.get(j).getRightId()==i){
									right+="yes-";
									break;
								}
								if(j==role_right.size()-1){
									right+="no-";
								}
							}
						}
						request.setAttribute("r", role);
						request.setAttribute("right", right);
						request.getRequestDispatcher("html/~right/role_edit.jsp").forward(request, response);
					}else{
						int id=Integer.parseInt(request.getParameter("id"));
						String roleName = request.getParameter("roleName");
						String[] rights = request.getParameterValues("rightCode");
						if(new RoleRightDaoImpl().update(id,rights)){
							response.getWriter().print("<script>alert('更新成功！')</script>");
							response.getWriter().print("<script>window.location.href='AllRoleServlet'</script>");
						}else{
							response.getWriter().print("<script>alert('更新失败！')</script>");
							response.getWriter().print("<script>window.location.href='AllRoleServlet'</script>");
						}
						
					}
					
			}
}
