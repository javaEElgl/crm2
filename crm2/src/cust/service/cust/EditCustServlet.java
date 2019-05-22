package cust.service.cust;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.dao.impl.UserDaoImpl;
import auth.entity.User;
import basd.dao.impl.DictDaoImpl;
import basd.entity.Dict;

import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Customer;

@WebServlet(value = "/EditCustServlet")
public class EditCustServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("before".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			// 通过id找到客户
			Customer cust = new CustomerDaoImpl().findById(id);
			request.setAttribute("c", cust);
			// 查询客户等级
			Dict d1 = new Dict();
			d1.setD_type("客户等级");
			List<Dict> gradeList = new DictDaoImpl().find(d1);
			Dict d2 = new Dict();
			d2.setD_type("地区");
			List<Dict> areaList = new DictDaoImpl().find(d2);
			//查询所有的客户经理
			List<User> userList = new UserDaoImpl().findByType("客户经理");
			request.setAttribute("glist", gradeList);
			request.setAttribute("ulist", userList);
			request.setAttribute("alist", areaList);
			request.getRequestDispatcher("html/~cust/cust/edit.jsp").forward(request, response);
		}else{
			int id = Integer.parseInt(request.getParameter("id"));
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
			Customer c=new Customer(id,custname, region, manager, level, satisfy, credit, addr, zip, tel, fax, website, licenceid, chieftain, bankroll, turnover, bank, bankid, loaclid, nationalid);
			if(new CustomerDaoImpl().update(c)){
				response.getWriter().print("<script>alert('更新成功！')</script>");
				response.getWriter().print("<script>window.location.href='AllCustServlet'</script>");
			}else{
				response.getWriter().print("<script>alert('更新失败！')</script>");
				response.getWriter().print("<script>window.location.href='AllCustServlet'</script>");
			}
		}
	}
}
