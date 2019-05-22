package tcx.servlet.rept;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.LevelDaoImpl;
import tcx.pojo.Level;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(value="/LevelServlet")
public class LevelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Level> levelList=new LevelDaoImpl().searchLevel();
        request.setAttribute("level",levelList);
        request.getRequestDispatcher("/html/~rept/cons.jsp").forward(request, response);
    }
}
