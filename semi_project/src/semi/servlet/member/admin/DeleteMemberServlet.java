package semi.servlet.member.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MemberDao;
@WebServlet(urlPatterns = "/admin/member/delete_member.do")
public class DeleteMemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			MemberDao mdao = new MemberDao();
			mdao.delete(id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("member_list.do");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
