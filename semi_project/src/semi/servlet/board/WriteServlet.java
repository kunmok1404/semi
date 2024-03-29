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

//@WebServlet(urlPatterns="/board/write.do")
public class WriteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : head, title, content
			BoardDto bdto = new BoardDto();
			bdto.setHead(req.getParameter("head"));
			bdto.setTitle(req.getParameter("title"));
			bdto.setContent(req.getParameter("content"));
			
			
//			세션의 작성자 정보를 추가
			String id = (String)req.getSession().getAttribute("ok");
			bdto.setWriter(id);
			
//			처리 : 현재 추가한 글의 번호 
//			select board_seq.nextval from dual;
//			insert into board values(?, ?, ?, ?, ?, sysdate, 0);
			BoardDao bdao = new BoardDao();
			int no = bdao.write(bdto);
			
//			출력 : content.do?no=xxx
			resp.sendRedirect("content.do?no="+no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}








