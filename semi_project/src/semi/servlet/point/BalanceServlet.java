package semi.servlet.point;

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

@WebServlet(urlPatterns = "/point/balance.do")
public class BalanceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String m_id = (String) req.getSession().getAttribute("id");
			PointDao pdao = new PointDao();
			PointDto pdto = pdao.get(m_id);

			req.setAttribute("pdto", pdto);

			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(m_id);

			req.setAttribute("mdto", mdto);
			
			List<PointDto> pList = pdao.list(m_id);
			req.setAttribute("pList", pList);

			RequestDispatcher dis = req.getRequestDispatcher("balance.jsp");
			dis.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
