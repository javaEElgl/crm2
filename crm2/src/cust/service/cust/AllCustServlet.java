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
					d1.setD_type("客户等级");
					List<Dict> gradeList = new DictDaoImpl().find(d1);
					Dict d3 = new Dict();
					d3.setD_type("地区");
					List<Dict> areaList = new DictDaoImpl().find(d3);
					request.setAttribute("glist", gradeList);;
					request.setAttribute("alist", areaList);
					//统计总行数
					int total=list.size();
					//计算页数
					int page_num=total%row_num==0?total/row_num:total/row_num+1;
					//当前页的上一页
					int pre=page_index==1?1:page_index-1;
					//当前页的下一页
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
					//查询所有
					List<Customer> list = new CustomerDaoImpl().find();
					//还需要查出所有客户等级
					//以及所有的地区
					// 查询客户等级
					Dict d1 = new Dict();
					d1.setD_type("客户等级");
					List<Dict> gradeList = new DictDaoImpl().find(d1);
					Dict d3 = new Dict();
					d3.setD_type("地区");
					List<Dict> areaList = new DictDaoImpl().find(d3);
					request.setAttribute("glist", gradeList);;
					request.setAttribute("alist", areaList);
					//判断所有客户最后下单时间是否超过1个月
					//获取客户所有的订单如果最后订单时间对于现在时间超过一个月，并判断流失表中是否有客户数据
					//如果没有那么就自动添加到流失表中,并返回一个状态码
					ArrayList<Integer> statusList = new CustomerDaoImpl().isLost(list);
					request.setAttribute("slist", statusList);
					
					//统计总行数
					int total=list.size();
					//计算页数
					int page_num=total%row_num==0?total/row_num:total/row_num+1;
					//当前页的上一页
					int pre=page_index==1?1:page_index-1;
					//当前页的下一页
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
//					//还需要查出所有客户等级
//					//以及所有的地区
//					// 查询客户等级
//					Dict d1 = new Dict();
//					d1.setD_type("客户等级");
//					List<Dict> gradeList = new DictDaoImpl().find(d1);
//					Dict d3 = new Dict();
//					d3.setD_type("地区");
//					List<Dict> areaList = new DictDaoImpl().find(d3);
//					request.setAttribute("glist", gradeList);;
//					request.setAttribute("alist", areaList);
//					//判断所有客户最后下单时间是否超过1个月
//					//获取客户所有的订单如果最后订单时间对于现在时间超过一个月，并判断流失表中是否有客户数据
//					//如果没有那么就自动添加到流失表中,并返回一个状态码
//					ArrayList<Integer> statusList = new CustomerDaoImpl().isLost(list);
//					request.setAttribute("slist", statusList);
//					request.getRequestDispatcher("html/~cust/cust/list.jsp").forward(request, response);
			}
}
