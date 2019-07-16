package semi.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.BoardDao;
import semi.bean.BoardDto;
import semi.bean.OneDao;
import semi.bean.OneDto;

//@WebServlet(urlPatterns="/board/write.do")
public class ServiceOneServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/service_one_write.jsp");
		/*
		 * OneDto bdto = new OneDto(); OneDao bdao = new OneDao();
		 * if(req.getParameter("no") != null) { int no =
		 * Integer.parseInt(req.getParameter("no")); try { bdto = bdao.get(no); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 * req.setAttribute("bdto", bdto);
		 */
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : head, title, content
			OneDto odto = new OneDto();
			odto.setHead(req.getParameter("head"));
			odto.setTitle(req.getParameter("title"));
			odto.setContent(req.getParameter("content"));
			

//			세션의 작성자 정보를 추가
			String id = (String)req.getSession().getAttribute("ok");
			odto.setWriter(id);
			
//			처리 : 현재 추가한 글의 번호 
//			select board_seq.nextval from dual;
//			insert into board values(?, ?, ?, ?, ?, sysdate, 0);
			OneDao odao = new OneDao();
			odao.write(odto);
			
//			출력 : content.do?no=xxx
			resp.sendRedirect("listOne.do");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}








