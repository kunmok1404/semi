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
			//����¡ �������� ��û������ �����ϸ� ó���� ��Ź
			PagingOne p = new PagingOne(req);
			p.calculate();
			System.out.println(p);
			
//			������ ÷��
			req.setAttribute("p", p);
			
//			������ �ڵ�
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





