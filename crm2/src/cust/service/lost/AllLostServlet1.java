package cust.service.lost;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;

import cust.dao.impl.LostDaoImpl;
import cust.entity.Lost;

@WebServlet(value="/AllLostServlet1")
public class AllLostServlet1 extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			int page_index=1;
			if(request.getParameter("page_index")!=null){
				try{
					page_index=Integer.parseInt(request.getParameter("page_index"));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			//ָ��ÿҳ��ʾ����
			int row_num=0;
			HttpSession session = request.getSession();
			if(session.getAttribute("row_num")!=null){
				row_num=Integer.parseInt(session.getAttribute("row_num").toString());
			}else{
				//ָ��ÿҳ��ʾ����
				 row_num=5;					
			}
			//����begin��end
			int begin=(page_index-1)*row_num+1;
			int end=page_index*row_num;
			String action=request.getParameter("action");
			if("some".equals(action)){	
				//��ѯָ����
				String name = request.getParameter("custname");
				String manager = request.getParameter("manager");
				String status= request.getParameter("status");
				if("".equals(name)&&"".equals(manager)&&"all".equals(status)){
					response.sendRedirect("AllLostServlet1");
					return ;
				}
				Lost lost=new Lost();
				lost.setCustomer(name);
				lost.setManager(manager);
				if(!"all".equals(status)){
					lost.setStatus(Integer.parseInt(status));					
				}
				List<Lost> list=new LostDaoImpl().find(lost);
				//ͳ��������
				int total=list.size();
				//����ҳ��
				int page_num=total%row_num==0?total/row_num:total/row_num+1;
				//��ǰҳ����һҳ
				int pre=page_index==1?1:page_index-1;
				//��ǰҳ����һҳ
				int next=page_index==page_num?page_num:page_index+1;
				list=new LostDaoImpl().splitPage(list, begin, end);
				request.setAttribute("list", list);
				request.setAttribute("page_index", page_index);
				request.setAttribute("page_num", page_num);
				request.setAttribute("row_num", row_num);
				request.setAttribute("pre", pre);
				request.setAttribute("next", next);
				request.setAttribute("total", total);
				request.getRequestDispatcher("html/~cust/lost/list.jsp").forward(request, response);
			}else{
				//��ѯ����
				List<Lost> list = new LostDaoImpl().find();
				//ͳ��������
				int total=list.size();
				//����ҳ��
				int page_num=total%row_num==0?total/row_num:total/row_num+1;
				//��ǰҳ����һҳ
				int pre=page_index==1?1:page_index-1;
				//��ǰҳ����һҳ
				int next=page_index==page_num?page_num:page_index+1;
				list=new LostDaoImpl().splitPage(list,begin, end);
				request.setAttribute("list", list);
				request.setAttribute("page_index", page_index);
				request.setAttribute("page_num", page_num);
				request.setAttribute("row_num", row_num);
				request.setAttribute("pre", pre);
				request.setAttribute("next", next);
				request.setAttribute("total", total);
				request.getRequestDispatcher("html/~cust/lost/list.jsp").forward(request, response);
			}
//			List<Lost> list = new LostDaoImpl().find();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("html/~cust/lost/list.jsp").forward(request, response);
		}
}
