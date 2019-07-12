package semi.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.beans.MemberDao;
import semi.beans.MemberDto;

@WebServlet(urlPatterns = "/member/find_id.do")
public class FindIdServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");

			MemberDto dto = new MemberDto();

			String name = req.getParameter("name");
			String email = req.getParameter("email");

			dto.setName(name);
			dto.setEmail(email);

			MemberDao dao = new MemberDao();

			String id = dao.findid(dto);

			if (id != null) {
				RequestDispatcher dis = req.getRequestDispatcher("find_id_result.jsp");
				dis.forward(req, resp);
			}
			else {
				RequestDispatcher dis = req.getRequestDispatcher("find_id.jsp?error");
				dis.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("find_id.jsp");
		dis.forward(req, resp);
	}

}
