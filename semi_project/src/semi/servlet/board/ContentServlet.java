package semi.servlet.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.BoardDao;
import semi.bean.BoardDto;
import semi.bean.CommentsDao;
import semi.bean.CommentsDto;
import semi.util.Paging;

@WebServlet(urlPatterns="/board/content.do")
public class ContentServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			���
//			�� �������� ���� �����ֱ� ���� �ݵ�� ��ȣ(no)�� �ʿ��մϴ�.
//			�Ķ���Ϳ��� �Ѿ���� ��ȣ�� �޾Ƽ� �ҷ������� ó��
//			�ҷ������� ��ȸ�� ���� ó��
			int no = Integer.parseInt(req.getParameter("no"));
			BoardDao bdao = new BoardDao();
			
//			if(���������� �ƴϸ鼭 ó������ ��){
			bdao.read(no);
//			}
			
			BoardDto bdto = bdao.get(no);  
			
//			�ڵ��߰� : ���� ���� �ۼ��ڰ� �������� Ȯ���ϴ� �ڵ�
			String id = (String)req.getSession().getAttribute("ok");
			boolean my = bdto.getWriter().equals(id);
			
//			�� ���� ��� ����� �ҷ����� �ڵ�
			CommentsDao cdao = new CommentsDao();
			List<CommentsDto> list = cdao.get(no); 
			
//			List�� �ҷ����� ���� ���
			Paging p = new Paging(req);
			p.calculate();
			
//			������ ÷��
			req.setAttribute("p", p);
			req.setAttribute("bdto", bdto);
			req.setAttribute("my", my);
			req.setAttribute("list", list);
			
//			������
			RequestDispatcher dispatcher = 
							req.getRequestDispatcher("content.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}



