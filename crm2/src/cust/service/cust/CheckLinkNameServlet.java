package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.UserDaoImpl;
import auth.entity.User;

@WebServlet(value="/CheckLinkNameServlet")
public class CheckLinkNameServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String name=request.getParameter("name");
			User user = new UserDaoImpl().searchByName(name);
			//根据我们得到的user对象来返回信息
			String str="";
			if(user!=null){
				str+="yes-";
				str+=user.getRole().getRoleName();
			}else{
				str+="no";
			}
			response.getWriter().print(str);
		}
}
