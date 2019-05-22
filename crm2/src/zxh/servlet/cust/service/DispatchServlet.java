package zxh.servlet.cust.service;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zxh.zxh.dao.ServiceDao;
import zxh.zxh.util.Service;
import zxh.zxh.util.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/LoadServlet")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        String search=req.getParameter("search");
        String custname=req.getParameter("custname");
        String title=req.getParameter("title");
        String type=req.getParameter("type");
        String time1=req.getParameter("time1");
        String time2=req.getParameter("time2");
        HttpSession session=req.getSession();
        ServiceDao dao=new ServiceDao();
        //获得时间
        Date now=new Date();
        int Year=now.getYear()+1900;
        session.setAttribute("year",Year);
        //分页
        String page=req.getParameter("index");
        int status= 1;
        int row_num=10;
        int index=1;
        try {
            index = Integer.parseInt(page);
        }catch (Exception e){
        }
        try {
            status= Integer.parseInt(req.getParameter("status"));
        }catch (Exception e){
        }
        try {
            row_num = Integer.parseInt(String.valueOf(session.getAttribute("row_num")));
        }catch (Exception e){
        }
        int all_num=0;
        if("search".equals(search)){
            all_num=dao.getSearchService(status,custname,title,type,time1,time2,0,0).size();
        }else {
            all_num=dao.getAllService(status);
        }
        int page_num=all_num%row_num==0?all_num/row_num:all_num/row_num+1;
        int begin=(index-1)*row_num+1;
        int end=index*row_num;
        int pre=index==1?1:index-1;
        int next=index==page_num?page_num:index+1;
        session.setAttribute("row",row_num);
        session.setAttribute("all_num",all_num);
        session.setAttribute("page_num",page_num);
        session.setAttribute("pre",pre);
        session.setAttribute("next",next);
        session.setAttribute("index",index);
        /*
        加载页面 服务分配
         */
        if ("Onload".equals(action)){
            List<Service> services=null;
            if ("search".equals(search)){
                services=dao.getSearchService(1,custname,title,type,time1,time2,begin,end);
            }else{
                services =dao.getService(1,begin,end);
            }
            List<User> users=dao.getAllManager();
            session.setAttribute("slist",services);
            session.setAttribute("ulist",users);
            if (services.size()<1) {
                resp.getWriter().println("<script>alert('暂无服务')</script>");
            }
            req.getRequestDispatcher("html/~cust/service/dispatch.jsp").forward(req,resp);
            return;
        }
        //分配
        if("Dueto".equals(action)){
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newTime=sdf.format(date);
            String sv_id=req.getParameter("sv_id");
            String manager=req.getParameter("manager");
            int id= Integer.parseInt(sv_id);
            Boolean result=dao.Dueto(id,manager,newTime);
            if (result){
                resp.getWriter().println("<script>alert('分配成功')</script>");
            }else{
                resp.getWriter().println("<script>alert('分配失败')</script>");
            }
            resp.getWriter().println("<script>window.location.href='LoadServlet?action=Onload'</script>");
            return;
        }
        //删除
        if ("DeleteSv".equals(action)){
            String sid=req.getParameter("sv_id");
            int id= Integer.parseInt(sid);
            Boolean result=dao.Delete(id);
            if (result){
                resp.getWriter().println("<script>alert('删除成功')</script>");
            }else{
                resp.getWriter().println("<script>alert('删除失败')</script>");
            }
            resp.getWriter().println("<script>window.location.href='LoadServlet?action=Onload'</script>");
            return;
        }
        /*
        处理服务
         */
        if ("dealBy".equals(action)){
            List<Service> dlist=null;
            if ("search".equals(search)){
                dlist=dao.getSearchService(2,custname,title,type,time1,time2,begin,end);
            }else{
                dlist =dao.getService(2,begin,end);
            }
            session.setAttribute("dlist",dlist);
            req.getRequestDispatcher("html/~cust/service/deal.jsp").forward(req,resp);
            return;
        }
        //处理细节
        if ("dealDetail".equals(action)){
            String str=req.getParameter("sv_id");
            int id= Integer.parseInt(str);
            Service service=dao.getServiceById(id);
            session.setAttribute("ddService",service);
            req.getRequestDispatcher("html/~cust/service/deal_detail.jsp").forward(req,resp);
            return;
        }
        //保存服务处理
        if ("dealService".equals(action)){
            String deal=req.getParameter("deal");
            String dealby=req.getParameter("dealby");
            String dealdate=req.getParameter("dealdate");
            String id= req.getParameter("sv_id");
            int sv_id= Integer.parseInt(id);
            boolean result=dao.dealService(sv_id,deal,dealby,dealdate);
            req.getRequestDispatcher("LoadServlet?action=dealBy").forward(req,resp);
            return;
        }
        /*
        服务反馈
         */
        if ("feedBack".equals(action)){
            List<Service> flist=null;
            if ("search".equals(search)){
                flist=dao.getSearchService(3,custname,title,type,time1,time2,begin,end);
            }else{
                flist =dao.getService(3,begin,end);
            }
            session.setAttribute("flist",flist);
            req.getRequestDispatcher("html/~cust/service/feedback.jsp").forward(req,resp);
            return;
        }
        //反馈细节
        if ("feedBackDetail".equals(action)){
            String str=req.getParameter("sv_id");
            int id= Integer.parseInt(str);
            Service service=dao.getServiceById(id);
            session.setAttribute("fbService",service);
            req.getRequestDispatcher("html/~cust/service/feedback_detail.jsp").forward(req,resp);
            return;
        }
        //保存反馈
        if ("feedBackService".equals(action)){
            String id=req.getParameter("sv_id");
            int sv_id= Integer.parseInt(id);
            String result=req.getParameter("result");
            String option=req.getParameter("satisfy");
            int satisfy= Integer.parseInt(option);
            //当满意度少于三星的时候，重新分配服务
            if(satisfy>3){
            	dao.dueToBack(sv_id);
            }else{
            	boolean done=dao.feedService(sv_id,result,satisfy);
            }
            req.getRequestDispatcher("LoadServlet?action=feedBack").forward(req,resp);
            return;
        }
        /*
        服务归档
         */
        if ("arch".equals(action)){
            List<Service> alist=null;
            if ("search".equals(search)){
                alist=dao.getSearchService(status,custname,title,type,time1,time2,begin,end);
            }else{
                alist =dao.getService(4,begin,end);
            }
            session.setAttribute("alist",alist);
            req.getRequestDispatcher("html/~cust/service/arch.jsp").forward(req,resp);
            return;
        }
        //归档细节
        if ("detail".equals(action)){
            String id=req.getParameter("sv_id");
            int sv_id= Integer.parseInt(id);
            Service service=dao.getServiceById(sv_id);
            session.setAttribute("detailService",service);
            req.getRequestDispatcher("html/~cust/service/detail.jsp").forward(req,resp);
            return;
        }
}
}
