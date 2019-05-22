package tcx.servlet.basd;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Customer;

import tcx.dao.impl.DictDaoImpl;
import tcx.pojo.Dict;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value="/DictServlet")
public class DictServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int page_index=1;
		if(request.getParameter("page_index")!=null){
			try{
				page_index=Integer.parseInt(request.getParameter("page_index"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//指定每页显示行数
		int row_num=0;
		HttpSession session = request.getSession();
		if(session.getAttribute("row_num")!=null){
			row_num=Integer.parseInt(session.getAttribute("row_num").toString());
		}else{
			//指定每页显示行数
			 row_num=5;					
		}
		//计算begin和end
		int begin=(page_index-1)*row_num+1;
		int end=page_index*row_num;
		String action=request.getParameter("action");
		if("some".equals(action)){	
			//查询指定的
			String type=request.getParameter("type");
			String item = request.getParameter("item");
			String value = request.getParameter("value");
			if("".equals(type)&&"".equals(item)&&"".equals(value)){
				response.sendRedirect("DictServlet");
				return ;
			}
			List<Dict> list = new DictDaoImpl().searchDict(type, item, value);
			//统计总行数
			int total=list.size();
			//计算页数
			int page_num=total%row_num==0?total/row_num:total/row_num+1;
			//当前页的上一页
			int pre=page_index==1?1:page_index-1;
			//当前页的下一页
			int next=page_index==page_num?page_num:page_index+1;
			list=new DictDaoImpl().splitPage(list, begin, end);
			request.setAttribute("list", list);
			request.setAttribute("page_index", page_index);
			request.setAttribute("page_num", page_num);
			request.setAttribute("row_num", row_num);
			request.setAttribute("pre", pre);
			request.setAttribute("next", next);
			request.setAttribute("total", total);
			request.getRequestDispatcher("/html/~basd/dict.jsp").forward(request, response);
		}else{
			List<Dict> list=new DictDaoImpl().searchDict();
			//统计总行数
			int total=list.size();
			//计算页数
			int page_num=total%row_num==0?total/row_num:total/row_num+1;
			//当前页的上一页
			int pre=page_index==1?1:page_index-1;
			//当前页的下一页
			int next=page_index==page_num?page_num:page_index+1;
			list=new DictDaoImpl().splitPage(list,begin, end);
			request.setAttribute("list", list);
			request.setAttribute("page_index", page_index);
			request.setAttribute("page_num", page_num);
			request.setAttribute("row_num", row_num);
			request.setAttribute("pre", pre);
			request.setAttribute("next", next);
			request.setAttribute("total", total);
			request.getRequestDispatcher("/html/~basd/dict.jsp").forward(request, response);
		}
    	
//        ArrayList<Dict> dict=new DictDaoImpl().searchDict();
//        request.setAttribute("dict",dict);
//        request.getRequestDispatcher("/html/~basd/dict.jsp").forward(request, response);
    }
}
