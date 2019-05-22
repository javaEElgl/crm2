package filter.encode;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName="a",urlPatterns="/*")
public class EncodeFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request=(HttpServletRequest)req;
			HttpServletResponse response=(HttpServletResponse)resp;
			if(request.getMethod().equalsIgnoreCase("GET")){
				response.setContentType("text/html;charset=utf-8");
				EncodeRequest req1=new EncodeRequest(request);
				//此处放行掉包request
				chain.doFilter(req1, resp);
			}
			else if(request.getMethod().equalsIgnoreCase("POST")){
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				chain.doFilter(req, resp);
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
