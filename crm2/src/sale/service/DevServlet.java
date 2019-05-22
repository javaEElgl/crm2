package sale.service;

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

@WebServlet(value="/DevServlet")
public class DevServlet extends HttpServlet{
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
				String name = request.getParameter("name");
				String title = request.getParameter("title");
				String contact= request.getParameter("contact");
				if("".equals(name)&&"".equals(title)&&"".equals(contact)){
					response.sendRedirect("DevServlet");
					return ;
				}
				Sale sale=new Sale(name, contact, title);
				List<Sale> list = new SaleDaoImpl().find(sale);
				//ͳ��������
				int total=list.size();
				//����ҳ��
				int page_num=total%row_num==0?total/row_num:total/row_num+1;
				//��ǰҳ����һҳ
				int pre=page_index==1?1:page_index-1;
				//��ǰҳ����һҳ
				int next=page_index==page_num?page_num:page_index+1;
				list=new SaleDaoImpl().splitPage(list, begin, end);
				request.setAttribute("list", list);
				request.setAttribute("page_index", page_index);
				request.setAttribute("page_num", page_num);
				request.setAttribute("row_num", row_num);
				request.setAttribute("pre", pre);
				request.setAttribute("next", next);
				request.setAttribute("total", total);
				request.setAttribute("action", action);
				request.setAttribute("name", name);
				request.setAttribute("title", title);
				request.setAttribute("contact",contact);
				request.getRequestDispatcher("html/~sale/dev.jsp").forward(request, response);
			}else{
				//��ѯ����
				List<Sale> list = new SaleDaoImpl().find();
				//ͳ��������
				int total=list.size();
				//����ҳ��
				int page_num=total%row_num==0?total/row_num:total/row_num+1;
				//��ǰҳ����һҳ
				int pre=page_index==1?1:page_index-1;
				//��ǰҳ����һҳ
				int next=page_index==page_num?page_num:page_index+1;
				list=new SaleDaoImpl().splitPage(list,begin, end);
				request.setAttribute("list", list);
				request.setAttribute("page_index", page_index);
				request.setAttribute("page_num", page_num);
				request.setAttribute("row_num", row_num);
				request.setAttribute("pre", pre);
				request.setAttribute("next", next);
				request.setAttribute("total", total);
				request.getRequestDispatcher("html/~sale/dev.jsp").forward(request, response);
			}
		
//			List<Sale> list = new SaleDaoImpl().find();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("html/~sale/dev.jsp").forward(request, response);
		}
}
