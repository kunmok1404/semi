package semi.servlet.point;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.PointDao;
import semi.bean.PointDto;

@WebServlet(urlPatterns="/point/cancel.do")
public class CancelServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");        
			resp.setCharacterEncoding("utf-8");
			
			PointDto pdto = new PointDto();
			PointDao pdao = new PointDao();
			
			pdto.setMemberId((String)req.getSession().getAttribute("id"));
			pdto.setOrdersId(Integer.parseInt(req.getParameter("orders_id")));
			pdto.setUseType("���");
			pdto.setPoint(Integer.parseInt(req.getParameter("point")));
			
			pdao.pointUse(pdto);
			
			resp.sendRedirect("order_list.do");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
