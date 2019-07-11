package semi.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.beans.MemberDao;
import semi.beans.MemberDto;

@WebServlet(urlPatterns="/member/check_pw.do")
public class CheckPwServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String id = (String) req.getSession().getAttribute("id");
		req.setAttribute("id", id);
		
		RequestDispatcher dis = req.getRequestDispatcher("check_pw.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		MemberDto mdto = new MemberDto();
		MemberDao mdao = new MemberDao();
		
		mdto.setId((String)req.getSession().getAttribute("id"));
		mdto.setPwd(req.getParameter("pwd"));
		
		try {
			if(mdao.check(mdto)) {
				resp.sendRedirect("edit_info.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
