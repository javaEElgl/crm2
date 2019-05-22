package zxh.servlet.cust.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cust.dao.impl.CustomerDaoImpl;
import cust.entity.Customer;

@WebServlet("/AjaxServlet1")
public class AjaxServlet1 extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<Customer> list = new CustomerDaoImpl().find();
			String data = JSON.toJSON(list).toString();
			response.getWriter().print(data);
		}
}
