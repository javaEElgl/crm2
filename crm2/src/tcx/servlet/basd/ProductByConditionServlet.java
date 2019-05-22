package tcx.servlet.basd;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcx.dao.impl.ProductDaoImpl;
import tcx.pojo.Product;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(value = "/ProductByConditionServlet")
public class ProductByConditionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String batch=request.getParameter("batch");
        ArrayList<Product> product=new ProductDaoImpl().searchProductByCondition(name,type,batch);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/html/~basd/product.jsp").forward(request,response);
    }
}
