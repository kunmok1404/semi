package semi.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.BoardDao;
import semi.bean.OneDao;
@WebServlet(urlPatterns="/board/deleteOne.do")
public class DeleteOneServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			입력 : no
			int no = Integer.parseInt(req.getParameter("no"));
			
//			처리 : 
			OneDao bdao = new OneDao();
			bdao.delete(no);
			
//			출력 : list.do
			resp.sendRedirect("listOne.do");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}







