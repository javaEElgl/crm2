package tcx.servlet.rept;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.ServiceDaoImpl;
import tcx.pojo.Service;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Service> serviceList=new ServiceDaoImpl().searchService();
        request.setAttribute("service",serviceList);
        request.getRequestDispatcher("/html/~rept/ser.jsp").forward(request, response);
    }
}
