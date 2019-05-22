package tcx.servlet.rept;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.LostDaoImpl;
import tcx.pojo.Lost;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(value = "/LostServlet")
public class LostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Lost> lostList=new LostDaoImpl().searchLost();
        request.setAttribute("lost",lostList);
        request.getRequestDispatcher("/html/~rept/lost.jsp").forward(request, response);
    }
}
