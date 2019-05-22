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

@WebServlet(value="/OrderListByConditionServlet")
public class OrderListByConditionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("customerName");
        String year=request.getParameter("orderYear");
        if (name.equals("")){
        if (year.equals("all")) {
            request.getRequestDispatcher("/OrderListServlet").forward(request, response);
        }else{
            ArrayList<Order> order = new OrderDaoImpl().searchOrder(year);
            request.setAttribute("order",order);
            request.getRequestDispatcher("/html/~rept/contr.jsp").forward(request, response);
        }
        }else{
            if (year.equals("all")) {
                ArrayList<Order> order = new OrderDaoImpl().searchOrder(name,year);
                request.setAttribute("order",order);
                request.getRequestDispatcher("/html/~rept/contr.jsp").forward(request, response);
            }else{
                ArrayList<Order> order = new OrderDaoImpl().searchOrder(name,year);
                request.setAttribute("order",order);
                request.getRequestDispatcher("/html/~rept/contr.jsp").forward(request, response);
            }
        }
    }
}
