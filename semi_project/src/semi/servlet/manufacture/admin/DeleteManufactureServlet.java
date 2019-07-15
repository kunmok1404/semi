package semi.servlet.manufacture.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MnftDao;
@WebServlet(urlPatterns = "/admin/manufacture/delete_manufacture.do")
public class DeleteManufactureServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			MnftDao mdao = new MnftDao();
			mdao.deleteManufacture(id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("manufacture_list.do");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
