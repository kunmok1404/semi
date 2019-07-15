package semi.servlet.product.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MemberDao;
import semi.bean.MemberDto;
import semi.bean.PointDao;
import semi.bean.PointDto;
import semi.bean.ReviewDao;
import semi.bean.ReviewDto;

@WebServlet(urlPatterns = "/product/review/review_edit.do")
public class ReviewEditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReviewDao rdao = new ReviewDao();
			ReviewDto rdto = new ReviewDto();

			String m_id = (String) req.getSession().getAttribute("id");

			rdto.setContent(req.getParameter("content"));
			rdto.setGrade(Integer.parseInt(req.getParameter("grade")));
			rdto.setMemberId(m_id);
			rdto.setProductId(Integer.parseInt(req.getParameter("product_id")));
			rdto.setTitle(req.getParameter("title"));

			rdao.edit(rdto);

			resp.sendRedirect("review_list.do");

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String id = (String) req.getSession().getAttribute("id");
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(id);
			req.setAttribute("mdto", mdto);
			PointDao pdao = new PointDao();
			PointDto pdto = pdao.get(id);
			req.setAttribute("pdto", pdto);
			
			
			ReviewDao rdao = new ReviewDao();
			ReviewDto rdto = rdao.get(Integer.parseInt(req.getParameter("r_id")));
			req.setAttribute("rdto", rdto);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		RequestDispatcher dis = req.getRequestDispatcher("review_write.jsp");
		dis.forward(req, resp);
	}
}
