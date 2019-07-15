package semi.servlet.product.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ProductCatDao;

@WebServlet(urlPatterns = "/admin/product/delete_category.do")
public class DeleteCatSevlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			System.out.println(name);
			ProductCatDao cdao = new ProductCatDao();
			cdao.deleteCat(name);
			
			resp.setContentType("text/plain");
			resp.getWriter().print("Y");				
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
