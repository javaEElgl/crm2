package sale.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;

@WebServlet(value="/FinishSaleServlet")
public class FinishSaleServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				String action=request.getParameter("action");
				int id = Integer.parseInt(request.getParameter("id"));
				if("success".equals(action)){
					Sale sale=new Sale();
					sale.setId(id);
					sale.setStatus(6);
					if(new SaleDaoImpl().finish(sale)){
						response.getWriter().print("<script>alert('开发成功！')</script>");
					}
					response.getWriter().print("<script>window.location.href='DevServlet'</script>");
				}
				if("fail".equals(action)){
					Sale sale=new Sale();
					sale.setId(id);
					sale.setStatus(5);
					if(new SaleDaoImpl().finish(sale)){
						response.getWriter().print("<script>alert('开发失败！')</script>");
					}
					response.getWriter().print("<script>window.location.href='DevServlet'</script>");
				}
		}
}
