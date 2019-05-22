package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;


@WebServlet(value="/EditSaleServlet")
public class EditSaleServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				String action = request.getParameter("action");
				if("before".equals(action)){
					int id =Integer.parseInt(request.getParameter("id"));
					Sale s=new SaleDaoImpl().findById(id);
					request.setAttribute("s", s);
					request.getRequestDispatcher("/html/~sale/edit.jsp").forward(request, response);
					return ;
				}
				if("edit".equals(action)){
					int id=Integer.parseInt(request.getParameter("id"));
					String name = request.getParameter("name");
					String rate = request.getParameter("rate");
					String contact = request.getParameter("contact");
					String phone = request.getParameter("phone");
					String title = request.getParameter("title");
					String desc = request.getParameter("desc");
					String source = request.getParameter("source");
					Sale sale=new Sale(id,source, name, contact, phone, title, rate, desc);
					if(new SaleDaoImpl().update(sale)){
						response.getWriter().print("<script>alert('更新成功！');</script>");
					}else{
						response.getWriter().print("<script>alert('更新失败！');</script>");
					}
					response.getWriter().print("<script>window.location.href='ShowAllSaleServlet';</script>");
				}
		}
}
