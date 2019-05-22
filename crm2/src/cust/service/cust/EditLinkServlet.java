package cust.service.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;
import cust.dao.impl.LinkManDaoImpl;
import cust.entity.Customer;
import cust.entity.Linkman;

@WebServlet(value="/EditLinkServlet")
public class EditLinkServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action=request.getParameter("action");
			if("before".equals(action)){
				int cid = Integer.parseInt(request.getParameter("cid"));
				int id = Integer.parseInt(request.getParameter("id"));
				Linkman l=new LinkManDaoImpl().findById(id);
				Customer c = new CustomerDaoImpl().findById(cid);
				request.setAttribute("l", l);
				request.setAttribute("c", c);
				request.getRequestDispatcher("html/~cust/cust/linkman_edit.jsp").forward(request, response);
			}else{
				//这是联系人的id
				int id=Integer.parseInt(request.getParameter("id"));
				int cid=Integer.parseInt(request.getParameter("cid"));
				String linkname = request.getParameter("linkname");
				String sex = request.getParameter("sex");
				String position = request.getParameter("position");
				String tel = request.getParameter("tel");
				String phone = request.getParameter("phone");
				String memo = request.getParameter("memo");
				Linkman l = new Linkman(id,linkname, sex, position, tel, phone, memo);
				if (new LinkManDaoImpl().update(l)) {
					response.getWriter().print("<script>alert('更新成功！')</script>");
					response.getWriter()
							.print("<script>window.location.href='AllLinkServlet?id="+cid+"'</script>");
				} else {
					response.getWriter().print("<script>alert('更新失败！')</script>");
					response.getWriter()
							.print("<script>window.location.href='AllLinkServlet?id="+cid+"'</script>");
				}
			}
		}
}
