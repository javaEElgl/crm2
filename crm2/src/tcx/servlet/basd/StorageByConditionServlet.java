package tcx.servlet.basd;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.StorageDaoImpl;
import tcx.pojo.Storage;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(value = "/StorageByConditionServlet")
public class StorageByConditionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_name=request.getParameter("product");
        String p_storagename=request.getParameter("storagename");
        ArrayList<Storage> storage=new StorageDaoImpl().searchStorageByCondition(p_name,p_storagename);
        request.setAttribute("storage",storage);
        request.getRequestDispatcher("/html/~basd/storage.jsp").forward(request,response);
    }
}
