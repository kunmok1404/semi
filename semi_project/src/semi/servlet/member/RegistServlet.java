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

@WebServlet (urlPatterns = "/member/regist.do")
public class RegistServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		try {
			MemberDao dao = new MemberDao();
			MemberDto dto = new MemberDto();
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String[] birth = req.getParameterValues("birth");
			String births = birth[0]+birth[1]+birth[2];
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String zip_code = req.getParameter("zip_code");
			String basic_addr = req.getParameter("basic_addr");
			String detail_addr = req.getParameter("detail_addr");
			String question = req.getParameter("question");
			String answer = req.getParameter("answer");
			
			dto.setId(id);
			dto.setName(name);
			dto.setPwd(pwd);
			dto.setBirth(births);
			dto.setPhone(phone);
			dto.setEmail(email);
			dto.setDetailAddr(detail_addr);
			dto.setZipCode(zip_code);
			dto.setBasicAddr(basic_addr);
			dto.setQuestion(question);
			dto.setAnswer(answer);
			
			dao.regist(dto);
			RequestDispatcher dis = req.getRequestDispatcher("regist_result.jsp");
			dis.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("regist.jsp");
		dis.forward(req, resp);
	}

}
