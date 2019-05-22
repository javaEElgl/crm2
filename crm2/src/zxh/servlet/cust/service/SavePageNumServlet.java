package zxh.servlet.cust.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SavePageNumServlet")
public class SavePageNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String row_num=request.getParameter("row_num");
        HttpSession session=request.getSession();
        if ("1".equals(id)){
            session.setAttribute("row_num",row_num);
            System.out.println(row_num);
            request.getRequestDispatcher("LoadServlet?action=Onload&status=1").forward(request,response);
        }
        if ("2".equals(id)){
            session.setAttribute("row_num",row_num);
            System.out.println(row_num);
            request.getRequestDispatcher("LoadServlet?action=dealBy&status=2").forward(request,response);
        }
        if ("3".equals(id)){
            session.setAttribute("row_num",row_num);
            System.out.println(row_num);
            request.getRequestDispatcher("LoadServlet?action=feedBack&status=3").forward(request,response);
        }
        if ("4".equals(id)){
            session.setAttribute("row_num",row_num);
            System.out.println(row_num);
            request.getRequestDispatcher("LoadServlet?action=arch&status=4").forward(request,response);
        }
    }
}
