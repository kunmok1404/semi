package semi.servlet.member.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MemberDao;
import semi.bean.MemberPointDto;
@WebServlet(urlPatterns = "/admin/member/member_list.do")
public class MemberListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberDao mdao = new MemberDao();
			List<MemberPointDto> mlist = mdao.memberPointlist();
			req.setAttribute("mlist", mlist);
			
			RequestDispatcher dispatcher= req.getRequestDispatcher("member_list.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
