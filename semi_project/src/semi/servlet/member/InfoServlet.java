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

@WebServlet(urlPatterns="/member/info.do")
public class InfoServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		try {
		String id = (String)req.getSession().getAttribute("id");
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.get(id);
		
		req.setAttribute("mdto", mdto);
		
		RequestDispatcher dis = req.getRequestDispatcher("info.jsp");
		dis.forward(req, resp);
		
		} catch(Exception e ) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
