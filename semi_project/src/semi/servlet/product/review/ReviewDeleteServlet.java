package semi.servlet.product.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ReviewDao;

@WebServlet(urlPatterns = "/product/review/review_delete.do")
public class ReviewDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReviewDao rdao = new ReviewDao();
			rdao.delete(Integer.parseInt(req.getParameter("r_id")));
			
			resp.sendRedirect("review_list.do");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
