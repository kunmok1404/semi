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

@WebServlet (urlPatterns = "/member/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("utf-8");
			
			MemberDto dto = new MemberDto();
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			dto.setId(id);
			dto.setPwd(pwd);
			
			MemberDao dao = new MemberDao();
			boolean isLogin = dao.login(dto);
			if(isLogin) {
				resp.sendRedirect("");
			}
			else {
				//아이디 또는 비밀번호가 틀렸습니다 예정
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
		dis.forward(req,resp);
	}

}
