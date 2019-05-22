package filter.encode;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author lgl
 *��������������ȫվ�������⣬��Ϊget����û��setParamter����
 *������Ҫǿ��getParamter��Ȼ�����request
 *
 *�˴�ʹ��װ����ģʽ
 */
public class EncodeRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public EncodeRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value = super.getParameter(name);
		if(value==null){
			return null;
		}
		try {
			value=new String(value.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return value;
	}
}
