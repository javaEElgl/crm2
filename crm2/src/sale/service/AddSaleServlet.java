package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;

@WebServlet(value="/AddSaleServlet")
public class AddSaleServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String source = request.getParameter("source");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String phone = request.getParameter("phone");
			String contact = request.getParameter("contact");
			String rate = request.getParameter("rate");
			String desc = request.getParameter("desc");
			String createName = request.getParameter("createName");
			String createTime = request.getParameter("createTime");
			Sale sale=new Sale(source, name, contact, phone, title, rate, desc, createName, createTime);
			if(new SaleDaoImpl().add(sale)){
				response.getWriter().print("<script>alert('插入成功！');</script>");
				response.getWriter().print("<script>window.location.href='ShowAllSaleServlet';</script>");
			}else{
				response.getWriter().print("<script>alert('插入失败！');</script>");
				response.getWriter().print("<script>window.location.href='/crm2/html/~sale/add.jsp';</script>");
			}
		}
}
