package tcx.servlet.rept;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.OrderDaoImpl;
import tcx.pojo.Order;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/OrderListServlet")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> order=new OrderDaoImpl().searchOrder();
        request.setAttribute("order",order);
        request.getRequestDispatcher("/html/~rept/contr.jsp").forward(request, response);
    }
}