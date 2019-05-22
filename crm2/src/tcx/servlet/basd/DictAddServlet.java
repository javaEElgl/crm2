package tcx.servlet.basd;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import tcx.dao.impl.DictDaoImpl;

import java.io.IOException;

@WebServlet(value = "/DictAddServlet")
public class DictAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_type = request.getParameter("type");
        String d_item = request.getParameter("item");
        String d_value = request.getParameter("value");
        String state = request.getParameter("isedit");
        String p_isedit = null;
        if ("on".equals(state)) {
            p_isedit = "��";
        } else {
            p_isedit = "��";
        }
        if (d_type.equals("") || d_item.equals("") || d_value.equals("") || p_isedit.equals("")) {
            request.getRequestDispatcher("/html/~basd/dict_add.jsp").forward(request,response);
            JOptionPane.showMessageDialog(null, "��������ⲻ��Ϊ�գ�����������");
        } else {
            boolean result = new DictDaoImpl().addDict(d_type, d_item, d_value, p_isedit);
            if (result) {
                request.getRequestDispatcher("/DictServlet").forward(request, response);
                JOptionPane.showMessageDialog(null, "����ɹ�");
            } else {
                request.getRequestDispatcher("/html/~basd/dict_add.jsp").forward(request,response);
                JOptionPane.showMessageDialog(null, "�½�ʧ��,����������");
            }
        }
    }
}
