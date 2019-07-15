package semi.servlet.product.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ProductDao;

@WebServlet(urlPatterns = "/admin/product/apply_product.do")
public class ApplyProductServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			ProductDao pdao = new ProductDao();
			pdao.applyProduct(no);
			RequestDispatcher dispatcher = req.getRequestDispatcher("product_list.do");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
