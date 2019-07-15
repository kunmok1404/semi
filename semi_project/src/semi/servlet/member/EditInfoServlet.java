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

@WebServlet(urlPatterns="/member/edit_info.do")
public class EditInfoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		try {
		MemberDto mdto = new MemberDto();
		MemberDao mdao = new MemberDao();
		
		mdto.setPwd(req.getParameter("pwd"));
		mdto.setPhone(req.getParameter("phone"));
		mdto.setEmail(req.getParameter("email"));
		mdto.setZipCode(req.getParameter("zip_code"));
		mdto.setBasicAddr(req.getParameter("basic_addr"));
		mdto.setDetailAddr(req.getParameter("detail_addr"));
		mdto.setQuestion(req.getParameter("question"));
		mdto.setAnswer(req.getParameter("answer"));
		mdto.setId(req.getParameter("id"));
		
		mdao.edit(mdto);
		
		RequestDispatcher dis = req.getRequestDispatcher("edit_info.do");
		dis.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			String id = (String) req.getSession().getAttribute("id");
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get(id);
			req.setAttribute("mdto", mdto);
			RequestDispatcher dis = req.getRequestDispatcher("edit_info.jsp");
			dis.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
