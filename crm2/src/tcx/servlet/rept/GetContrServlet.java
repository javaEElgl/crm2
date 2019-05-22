package tcx.servlet.rept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import tcx.dao.impl.OrderDaoImpl;
import tcx.pojo.Order;


@WebServlet(value="/GetContrServlet")
public class GetContrServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			ArrayList<Order> order=new OrderDaoImpl().searchOrder();
	        String str = JSON.toJSON(order).toString();
	        response.getWriter().print(str);
		}
}
