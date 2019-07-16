package semi.servlet.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MemberDao;
import semi.bean.MemberDto;
import semi.bean.ProductDao;

@WebServlet(urlPatterns = "/admin/main.do")
public class IndexAdminServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("????????????");
		try {
			ProductDao pdao = new ProductDao();
			int p_count = pdao.ProductCount(); // Ï¥ùÏÉÅ?íàÍ∞??àò
			int p_applyOk = pdao.applyOk();  // ?äπ?ù∏?êú ?à´?ûê
			
			req.setAttribute("p_count", p_count);
			req.setAttribute("p_applyOk", p_applyOk);
			
			
			MemberDao mdao = new MemberDao();
			MemberDto mdto = mdao.get((String)req.getSession().getAttribute("id"));
			
			
			req.setAttribute("mdto", mdto);
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("main.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
