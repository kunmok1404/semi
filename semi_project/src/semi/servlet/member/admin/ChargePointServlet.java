package semi.servlet.member.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.PointDao;
import semi.bean.PointDto;
@WebServlet(urlPatterns = "/admin/member/charge_point.do")
public class ChargePointServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String reason= req.getParameter("reason");
			int point = Integer.parseInt(req.getParameter("point"));
			String id = req.getParameter("id");
			int current_Point = Integer.parseInt(req.getParameter("current_Point"));
			System.out.println("reson:"+ reason);
			System.out.println("point:" + point);
			System.out.println("id:"+ id);
			
			PointDao pdao = new PointDao();
			PointDto pdto = new PointDto();
			pdto.setMemberId(id);
			pdto.setPoint(point);
			pdto.setReason(reason);
			pdto.setCurrentPoint(current_Point);
			if(point > 0) {
				pdto.setUseType("지급");
			} else if(point < 0) {
				pdto.setUseType("회수");
			}
			System.out.println("pdto:"+pdto);
			pdao.pointUse(pdto);
			RequestDispatcher dispatcher = req.getRequestDispatcher("member_list.do");
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
