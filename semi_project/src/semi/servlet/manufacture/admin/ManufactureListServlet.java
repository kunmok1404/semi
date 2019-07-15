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
@WebServlet(urlPatterns = "/admin/manufacture/manufacture_list.do")
public class ManufactureListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			MnftDao mdao = new MnftDao();
			List<MnftDto> list = mdao.manufactureList();
			req.setAttribute("list", list);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("manufacture_list.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
