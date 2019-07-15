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

@WebServlet (urlPatterns ="/member/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			
			MemberDto dto = new MemberDto();
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			dto.setId(id);
			dto.setPwd(pwd);
			
			System.out.println(dto);
			MemberDao dao = new MemberDao();
			boolean isLogin = dao.login(dto);
			if(isLogin) {
				req.getSession().setAttribute("id", id);
				
				dao.loginDtUpdate(id);
				resp.sendRedirect(req.getContextPath());				
			}
			else {
				RequestDispatcher dis = req.getRequestDispatcher("login.jsp?error");
				dis.forward(req, resp);
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
