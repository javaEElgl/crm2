package tcx.servlet.basd;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.DictDaoImpl;
import tcx.pojo.Dict;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(value="/DictByConditionServlet")
public class DictByConditionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_type=request.getParameter("type");
        String d_item=request.getParameter("item");
        String d_value=request.getParameter("value");
        ArrayList<Dict> dict=new DictDaoImpl().searchDict(d_type,d_item,d_value);
        request.setAttribute("dict",dict);
        request.getRequestDispatcher("/html/~basd/dict.jsp").forward(request,response);
    }
}
