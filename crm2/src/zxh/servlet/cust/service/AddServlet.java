package zxh.servlet.cust.service;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zxh.zxh.dao.AddDao;
import zxh.zxh.util.Service;

import java.io.IOException;
import java.sql.Date;

@WebServlet(value="/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("serviceType");
        String title = req.getParameter("title");
        String custname = req.getParameter("custname");
        int status=1;
        String request = req.getParameter("request");
        String createby = req.getParameter("createby");
        String createdate = req.getParameter("createdate");
        AddDao addDao=new AddDao();
        Service service =addDao.addService(type,title,custname,status,request,createby,createdate);
        if (service!=null){
            resp.getWriter().println("<script>alert('新建成功')</script>");
        }else{
            resp.getWriter().println("<script>alert('新建失败')</script>");
        }
        resp.getWriter().println("<script>window.location.href='html/~cust/service/add.jsp'</script>");
    }
}
