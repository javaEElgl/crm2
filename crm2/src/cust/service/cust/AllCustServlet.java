package cust.service.cust;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sale.dao.impl.SaleDaoImpl;
import sale.entity.Sale;

import basd.dao.impl.DictDaoImpl;
import basd.entity.Dict;

import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Customer;

@WebServlet(value="/AllCustServlet")
public class AllCustServlet extends HttpServlet{	
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
					String no=request.getParameter("no");
					String name = request.getParameter("cname");
					String region = request.getParameter("region");
					String manager= request.getParameter("manager");
					String level=request.getParameter("level");
					if("".equals(no)&&"".equals(name)&&"".equals(region)&&"".equals(manager)&&"".equals(level)){
						response.sendRedirect("AllCustServlet");
						return ;
					}
					Customer c=new Customer(no, name, region, manager, level);
					List<Customer> list = new CustomerDaoImpl().find(c);
					ArrayList<Integer> statusList = new CustomerDaoImpl().isLost(list);
					request.setAttribute("slist", statusList);
					Dict d1 = new Dict();
					d1.setD_type("�ͻ��ȼ�");
					List<Dict> gradeList = new DictDaoImpl().find(d1);
					Dict d3 = new Dict();
					d3.setD_type("����");
					List<Dict> areaList = new DictDaoImpl().find(d3);
					request.setAttribute("glist", gradeList);;
					request.setAttribute("alist", areaList);
					//ͳ��������
					int total=list.size();
					//����ҳ��
					int page_num=total%row_num==0?total/row_num:total/row_num+1;
					//��ǰҳ����һҳ
					int pre=page_index==1?1:page_index-1;
					//��ǰҳ����һҳ
					int next=page_index==page_num?page_num:page_index+1;
					list=new CustomerDaoImpl().splitPage(list, begin, end);
					request.setAttribute("list", list);
					request.setAttribute("page_index", page_index);
					request.setAttribute("page_num", page_num);
					request.setAttribute("row_num", row_num);
					request.setAttribute("pre", pre);
					request.setAttribute("next", next);
					request.setAttribute("total", total);
					request.getRequestDispatcher("html/~cust/cust/list.jsp").forward(request, response);
				}else{
					//��ѯ����
					List<Customer> list = new CustomerDaoImpl().find();
					//����Ҫ������пͻ��ȼ�
					//�Լ����еĵ���
					// ��ѯ�ͻ��ȼ�
					Dict d1 = new Dict();
					d1.setD_type("�ͻ��ȼ�");
					List<Dict> gradeList = new DictDaoImpl().find(d1);
					Dict d3 = new Dict();
					d3.setD_type("����");
					List<Dict> areaList = new DictDaoImpl().find(d3);
					request.setAttribute("glist", gradeList);;
					request.setAttribute("alist", areaList);
					//�ж����пͻ�����µ�ʱ���Ƿ񳬹�1����
					//��ȡ�ͻ����еĶ��������󶩵�ʱ���������ʱ�䳬��һ���£����ж���ʧ�����Ƿ��пͻ�����
					//���û����ô���Զ���ӵ���ʧ����,������һ��״̬��
					ArrayList<Integer> statusList = new CustomerDaoImpl().isLost(list);
					request.setAttribute("slist", statusList);
					
					//ͳ��������
					int total=list.size();
					//����ҳ��
					int page_num=total%row_num==0?total/row_num:total/row_num+1;
					//��ǰҳ����һҳ
					int pre=page_index==1?1:page_index-1;
					//��ǰҳ����һҳ
					int next=page_index==page_num?page_num:page_index+1;
					list=new CustomerDaoImpl().splitPage(list,begin, end);
					request.setAttribute("list", list);
					request.setAttribute("page_index", page_index);
					request.setAttribute("page_num", page_num);
					request.setAttribute("row_num", row_num);
					request.setAttribute("pre", pre);
					request.setAttribute("next", next);
					request.setAttribute("total", total);
					request.getRequestDispatcher("html/~cust/cust/list.jsp").forward(request, response);
				}
			
				
				
				
//					List<Customer> list = new CustomerDaoImpl().find();
//					request.setAttribute("list", list);
//					//����Ҫ������пͻ��ȼ�
//					//�Լ����еĵ���
//					// ��ѯ�ͻ��ȼ�
//					Dict d1 = new Dict();
//					d1.setD_type("�ͻ��ȼ�");
//					List<Dict> gradeList = new DictDaoImpl().find(d1);
//					Dict d3 = new Dict();
//					d3.setD_type("����");
//					List<Dict> areaList = new DictDaoImpl().find(d3);
//					request.setAttribute("glist", gradeList);;
//					request.setAttribute("alist", areaList);
//					//�ж����пͻ�����µ�ʱ���Ƿ񳬹�1����
//					//��ȡ�ͻ����еĶ��������󶩵�ʱ���������ʱ�䳬��һ���£����ж���ʧ�����Ƿ��пͻ�����
//					//���û����ô���Զ���ӵ���ʧ����,������һ��״̬��
//					ArrayList<Integer> statusList = new CustomerDaoImpl().isLost(list);
//					request.setAttribute("slist", statusList);
//					request.getRequestDispatcher("html/~cust/cust/list.jsp").forward(request, response);
			}
}
