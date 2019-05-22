package cust.service.lost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;
import cust.dao.impl.LostDaoImpl;
import cust.entity.Customer;
import cust.entity.Lost;

@WebServlet(value="/RelayServlet1")
public class RelayServlet1 extends HttpServlet{
			@Override
			protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				String action=request.getParameter("action");
				if("after".equals(action)){
					int id = Integer.parseInt(request.getParameter("id"));
					Lost l = new LostDaoImpl().findById(id);
					if(l.getDelay()!=null){
						l.setDelay(l.getDelay().replace("-", "\n"));
					}					
					request.setAttribute("l", l);
					request.getRequestDispatcher("html/~cust/lost/relay.jsp").forward(request, response);
				}
				else{
					int id = Integer.parseInt(request.getParameter("id"));
					Customer c = new CustomerDaoImpl().findById(id);
					Lost l = new LostDaoImpl().findByCust(c);
					if(l.getDelay()!=null){
						l.setDelay(l.getDelay().replace("-", "\n"));
					}	
					request.setAttribute("l", l);
					//根据状态跳转不同的页面
					if(l.getStatus()==3){
						request.getRequestDispatcher("html/~cust/lost/detail.jsp").forward(request, response);
						return;
					}
					request.getRequestDispatcher("html/~cust/lost/relay.jsp").forward(request, response);
				}
			}
}
