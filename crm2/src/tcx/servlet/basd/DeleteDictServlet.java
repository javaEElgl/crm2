package tcx.servlet.basd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.DictDaoImpl;

@WebServlet(value="/DeleteDictServlet")
public class DeleteDictServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			if(new DictDaoImpl().delDict(id)){
				response.getWriter().print("<script>alert('É¾³ý³É¹¦£¡')</script>");
				response.getWriter().print("<script>window.location.href='DictServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('É¾³ýÊ§°Ü£¡')</script>");
				response.getWriter().print("<script>window.location.href='DictServlet'</script>");
			}
		}
}
