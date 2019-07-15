package semi.servlet.product.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ProductDao;

@WebServlet(urlPatterns = "/admin/main.do")
public class IndexAdminServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ProductDao pdao = new ProductDao();
			int p_count = pdao.ProductCount(); // 총상품갯수
			int p_applyOk = pdao.applyOk();  // 승인된 숫자
			
			req.setAttribute("p_count", p_count);
			req.setAttribute("p_applyOk", p_applyOk);
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
