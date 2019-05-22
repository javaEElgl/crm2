package auth.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.UserDaoImpl;

@WebServlet(value="/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet{
			@Override
			protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
					String username = request.getParameter("username");
					//����ֵΪ������ڴ��û���
					if(new UserDaoImpl().findByName(username)){
						response.getWriter().print("no");
					}else{
						response.getWriter().print("yes");
					}
			}
}
