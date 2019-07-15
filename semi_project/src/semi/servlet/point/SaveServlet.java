package semi.servlet.point;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/point/save.do")
public class SaveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher dis = req.getRequestDispatcher("charge.jsp");
//		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			req.setCharacterEncoding("utf-8");
//			resp.setCharacterEncoding("utf-8");
//			
//			PointDto pdto = new PointDto();
//			PointDao pdao = new PointDao();
//			
//			pdto.setMemberId((String)req.getSession().getAttribute("id"));
//			pdto.setUseType("Àû¸³");
//			pdto.setPoint(Integer.parseInt(req.getParameter("point")));
//			
//			pdao.pointUse(pdto);
//			
//			resp.sendRedirect("balance.do");
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			resp.sendError(500);
//		}
	}
}
