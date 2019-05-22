package sale.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.UserDaoImpl;
import auth.entity.User;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;


@WebServlet(value="/DispatchServlet")
public class DispatchServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getParameter("action");
			if("before".equals(action)){
				int id =Integer.parseInt(request.getParameter("id"));
				Sale s=new SaleDaoImpl().findById(id);
				List<User> ulist = new UserDaoImpl().find();
				request.setAttribute("s", s);
				request.setAttribute("ulist", ulist);
				request.getRequestDispatcher("/html/~sale/dispatch.jsp").forward(request, response);
				return ;
			}
			if("dispatch".equals(action)){
				int id=Integer.parseInt(request.getParameter("sId"));
				String dueName = request.getParameter("dueName");
				String dueTime = request.getParameter("dueTime");
				Sale sale=new Sale();
				sale.setId(id);
				sale.setDueName(dueName);
				sale.setDueTime(dueTime);
				if(new SaleDaoImpl().dispatch(sale)){
					response.getWriter().print("<script>alert('指派成功！');</script>");
				}else{
					response.getWriter().print("<script>alert('指派失败！');</script>");
				}
				response.getWriter().print("<script>window.location.href='ShowAllSaleServlet';</script>");
			}
		}
}
