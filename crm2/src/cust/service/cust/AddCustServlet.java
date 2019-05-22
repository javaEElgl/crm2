package cust.service.cust;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Customer;

import auth.dao.impl.UserDaoImpl;
import auth.entity.User;
import basd.dao.impl.DictDaoImpl;
import basd.entity.Dict;

@WebServlet(value = "/AddCustServlet")
public class AddCustServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("before".equals(action)) {
			// 查询客户等级
			Dict d1 = new Dict();
			d1.setD_type("客户等级");
			List<Dict> gradeList = new DictDaoImpl().find(d1);
			Dict d3 = new Dict();
			d3.setD_type("地区");
			List<Dict> areaList = new DictDaoImpl().find(d3);
			//查询所有的客户经理
			List<User> userList = new UserDaoImpl().findByType("客户经理");
			request.setAttribute("glist", gradeList);
			request.setAttribute("ulist", userList);
			request.setAttribute("alist", areaList);
			request.getRequestDispatcher("html/~cust/cust/add.jsp").forward(request, response);
		}else{
			String custno = request.getParameter("custno");
			String custname = request.getParameter("custname");
			String region = request.getParameter("region");
			String manager = request.getParameter("manager");
			String level = request.getParameter("level");
			String satisfy = request.getParameter("satisfy");
			String credit = request.getParameter("credit");
			String addr = request.getParameter("addr");
			String zip = request.getParameter("zip");
			String tel = request.getParameter("tel");
			String fax = request.getParameter("fax");
			String website = request.getParameter("website");
			String licenceid = request.getParameter("licenceid");
			String chieftain = request.getParameter("chieftain");
			String bankroll = request.getParameter("bankroll");
			String turnover = request.getParameter("turnover");
			String bank = request.getParameter("bank");
			String bankid = request.getParameter("bankid");
			String loaclid = request.getParameter("loaclid");
			String nationalid = request.getParameter("nationalid");
			Customer c=new Customer(custno, custname, region, manager, level, satisfy, credit, addr, zip, tel, fax, website, licenceid, chieftain, bankroll, turnover, bank, bankid, loaclid, nationalid);
			if(new CustomerDaoImpl().add(c)){
				response.getWriter().print("<script>alert('创建成功！')</script>");
				response.getWriter().print("<script>window.location.href='AllCustServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('创建失败！')</script>");
				response.getWriter().print("<script>window.location.href='AllCustServlet'</script>");
			}
		}
	}
}
