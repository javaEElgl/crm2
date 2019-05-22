package tcx.servlet.basd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import tcx.dao.impl.DictDaoImpl;



@WebServlet("/AjaxTypeServlet")
public class AjaxTypeServlet extends HttpServlet{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<String> list = new DictDaoImpl().getType();
			Object data=JSON.toJSON(list);
			response.getWriter().print(data);
//			String type=request.getParameter("type");
//			for (int i = 0; i < list.size(); i++) {
//				if(list.get(i).equals(type)){
//					response.getWriter().print("yes");
//					return;
//				}
//			}
//			response.getWriter().print("no");
		}
}
