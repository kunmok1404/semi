package semi.servlet.product.review;

import java.io.IOException;
import java.util.List;

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
import semi.bean.ReviewListDao;
import semi.bean.ReviewListDto;

@WebServlet(urlPatterns = "/product/review/review_list.do")
public class ReviewListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReviewListDto rldto = new ReviewListDto();
			ReviewListDao rldao = new ReviewListDao();

			String m_id = (String) req.getSession().getAttribute("id");

			List<ReviewListDto> list = rldao.list(m_id);

			req.setAttribute("rl_list", list);

			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(m_id);
			req.setAttribute("mdto", mdto);
			
			PointDao pdao = new PointDao();
			PointDto pdto = pdao.get(m_id);
			req.setAttribute("pdto", pdto);

			RequestDispatcher dis = req.getRequestDispatcher("review_list.jsp");
			dis.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}

	}
}
