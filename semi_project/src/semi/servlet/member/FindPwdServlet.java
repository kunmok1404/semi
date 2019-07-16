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

@WebServlet (urlPatterns="/member/find_pwd.do")
public class FindPwdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher dis = req.getRequestDispatcher("find_pwd.jsp");
			dis.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("utf-8");
			
			MemberDto dto = new MemberDto();
			
			String name = dto.getName();
			String id = dto.getId();
			String email = dto.getEmail();
			
			MemberDao dao = new MemberDao();
			
			if(dao.findPwd(dto)) {
				RequestDispatcher dis = req.getRequestDispatcher("find_pwd_result.jsp");
				dis.forward(req, resp);
			}
			else {
				RequestDispatcher dis = req.getRequestDispatcher("find_pwd.jsp?error");
				dis.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
