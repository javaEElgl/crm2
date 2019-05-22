package auth.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import auth.entity.Role;
import auth.entity.Role_Right;
import auth.entity.User;

@WebServlet(value="/FindRoleRightServlet")
public class FindRoleRightServlet extends HttpServlet{
			@Override
			protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				//��ȥ��ȡsession��ȡ��¼ʱ�󶨵Ķ���
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("user");
				//��ȡ�����¼���û��е�Ȩ��
				Role role=new Role();
				try{
				 role = user.getRole();
				}catch (Exception e) {
					return;
				}
				ArrayList<Role_Right> list = role.getRole_right();
				//����һ���µ�����
				boolean [] data=new boolean[18];
				for(Role_Right r:list){
					data[r.getRightId()-1]=true;
				}
				StringBuffer str=new StringBuffer();
				for(int i=0;i<data.length-1;i++){
					str.append(data[i]+"-");
				}
				str.append(data[data.length-1]);
				response.getWriter().print(str);
			}
}
