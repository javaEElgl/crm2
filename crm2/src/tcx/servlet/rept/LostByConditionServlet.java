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
@WebServlet(value="/LostByConditionServlet")
public class LostByConditionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lstCustName = request.getParameter("item.lstCustName");
        String lstCustManagerName = request.getParameter("item.lstCustManagerName");
        ArrayList<Lost> lost = new LostDaoImpl().searchLost(lstCustName, lstCustManagerName);
        request.setAttribute("lost", lost);
        request.getRequestDispatcher("/html/~rept/lost.jsp").forward(request, response);
    }
}
