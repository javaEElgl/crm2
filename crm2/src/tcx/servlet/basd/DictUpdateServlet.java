package tcx.servlet.basd;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

import tcx.dao.impl.DictDaoImpl;

import java.io.IOException;

@WebServlet(value = "/DictUpdateServlet")
public class DictUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_type = request.getParameter("type");
        String d_item = request.getParameter("item");
        String d_value = request.getParameter("value");
        String state = request.getParameter("isedit");
        String  id = request.getParameter("id");
        String p_isedit = null;
        if ("on".equals(state)) {
            p_isedit = "是";
        } else {
            p_isedit = "否";
        }
        boolean result = new DictDaoImpl().updateDict(d_type, d_item, d_value, p_isedit, id);
        if (result) {
            request.getRequestDispatcher("/DictServlet").forward(request, response);
            JOptionPane.showMessageDialog(null, "保存成功");
        } else {
            request.getRequestDispatcher("/DictServlet").forward(request, response);
            JOptionPane.showMessageDialog(null, "修改失败,返回上级");
        }
    }
}

