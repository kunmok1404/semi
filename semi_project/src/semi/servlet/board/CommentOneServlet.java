package semi.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.BoardDao;
import semi.bean.BoardDto;
import semi.bean.OneDao;
import semi.bean.OneDto;

@WebServlet(urlPatterns="/board/commentsOne.do")
public class CommentOneServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : head, title, content
			OneDto bdto = new OneDto();
			String id = (String)req.getSession().getAttribute("ok");
			bdto.setServiceNo(Integer.parseInt(req.getParameter("serviceNo")));
			bdto.setServiceContent(req.getParameter("serviceContent"));
			bdto.setAnswerMen(id);
			
			OneDao bdao = new OneDao();
			bdao.editComment(bdto);
			
//			출력 : content.do?no=xxx
			resp.sendRedirect("contentOne.do?no="+bdto.getServiceNo());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}








