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
@WebServlet(value="/LevelBySelectServlet")
public class LevelBySelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int value= Integer.parseInt(request.getParameter("level"));
        if (value==1){
            ArrayList<Level> levelList=new LevelDaoImpl().searchLevel();
            request.setAttribute("level",levelList);
            request.getRequestDispatcher("/html/~rept/cons.jsp").forward(request, response);
        }else if (value==2){
            ArrayList<Level> levelList=new LevelDaoImpl().searchLevelByCredit();
            request.setAttribute("level",levelList);
            request.getRequestDispatcher("/html/~rept/cons.jsp").forward(request, response);
        }else if (value==3){
            ArrayList<Level> levelList=new LevelDaoImpl().searchLevelBySatisfy();
            request.setAttribute("level",levelList);
            request.getRequestDispatcher("/html/~rept/cons.jsp").forward(request, response);
        }
    }
}
