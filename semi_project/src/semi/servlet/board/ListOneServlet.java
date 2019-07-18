package semi.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.util.PagingOne;
@WebServlet(urlPatterns="/board/listOne.do")
public class ListOneServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//페이징 도구에게 요청정보를 전달하며 처리를 부탁
			PagingOne p = new PagingOne(req);
			p.calculate();
			System.out.println(p);
			
//			데이터 첨부
			req.setAttribute("p", p);
			
//			포워딩 코드
			RequestDispatcher dispatcher = 
										req.getRequestDispatcher("listOne.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}





