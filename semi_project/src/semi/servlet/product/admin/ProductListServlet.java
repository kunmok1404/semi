package semi.servlet.product.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.PrdRecipeMnftViewDto;
import semi.bean.ProductDao;
import semi.bean.ProductDto;

@WebServlet(urlPatterns = "/admin/product/product_list.do")
public class ProductListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			ProductDao pdao = new ProductDao();
			List<PrdRecipeMnftViewDto> list = pdao.ProductList();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("product_list.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
