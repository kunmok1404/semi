package semi.servlet.member;

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

@WebServlet(urlPatterns="/member/check_pw.do")
public class CheckPwServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			String id = (String) req.getSession().getAttribute("id");
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(id);
			req.setAttribute("mdto", mdto);
			PointDao pdao = new PointDao();
			PointDto pdto = pdao.get(id);
			req.setAttribute("pdto", pdto);
			
			RequestDispatcher dis = req.getRequestDispatcher("check_pw.jsp");
			dis.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		MemberDto mdto = new MemberDto();
		MemberDao mdao = new MemberDao();
		
		mdto.setId((String)req.getSession().getAttribute("id"));
		mdto.setPwd(req.getParameter("confirm_password"));
		
		try {
			if(mdao.check(mdto)) {
				resp.sendRedirect("edit_info.do");
			}
			else {
				String id = (String) req.getSession().getAttribute("id");
				MemberDao mdao2 = new MemberDao();
				MemberDto mdto2 = mdao2.get(id);
				req.setAttribute("mdto", mdto2);
				PointDao pdao = new PointDao();
				PointDto pdto = pdao.get(id);
				req.setAttribute("pdto", pdto);
				
				RequestDispatcher dis = req.getRequestDispatcher("check_pw.jsp?error");
				dis.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
