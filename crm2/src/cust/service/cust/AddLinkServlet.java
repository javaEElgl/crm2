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

@WebServlet(value = "/AddLinkServlet")
public class AddLinkServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("before".equals(action)) {
				int id=Integer.parseInt(request.getParameter("id"));
				request.setAttribute("id", id);
				request.getRequestDispatcher("html/~cust/cust/linkman_add.jsp").forward(request, response);
		} else {
			int id=Integer.parseInt(request.getParameter("id"));
			Customer c=new CustomerDaoImpl().findById(id);
			String linkname = request.getParameter("linkname");
			String sex = request.getParameter("sex");
			String position = request.getParameter("position");
			String tel = request.getParameter("tel");
			String phone = request.getParameter("phone");
			String memo = request.getParameter("memo");
			Linkman l = new Linkman(linkname, sex, position, tel, phone, memo,c);
			if (new LinkManDaoImpl().add(l)) {
				response.getWriter().print("<script>alert('创建成功！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllLinkServlet?id="+id+"'</script>");
			} else {
				response.getWriter().print("<script>alert('创建失败！')</script>");
				response.getWriter()
						.print("<script>window.location.href='AllLinkServlet?id="+id+"'</script>");
			}
		}

	}
}
