package home.servlet.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.util.Paging;
@WebServlet(urlPatterns="/board/list.do")
public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//����¡ �������� ��û������ �����ϸ� ó���� ��Ź
			Paging p = new Paging(req);
			p.calculate();
			
//			������ ÷��
			req.setAttribute("p", p);
			
//			������ �ڵ�
			RequestDispatcher dispatcher = 
										req.getRequestDispatcher("list.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}





