package semi.servlet.manufacture.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MnftDao;
import semi.bean.MnftDto;
@WebServlet(urlPatterns = "/admin/manufacture/manufacture_content.do")
public class ManufactureContentServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			int no = Integer.parseInt(req.getParameter("id"));
			MnftDao mdao = new MnftDao();
			MnftDto mdto = mdao.manufactureContent(no);
			req.setAttribute("mdto", mdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("manufacture_content.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
