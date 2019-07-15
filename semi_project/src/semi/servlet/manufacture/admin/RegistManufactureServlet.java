package semi.servlet.manufacture.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.MnftDao;
import semi.bean.MnftDto;
@WebServlet(urlPatterns = "/admin/manufacture/regist_manufacture.do")
public class RegistManufactureServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("regist_manufacture.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 공급사 등록
			req.setCharacterEncoding("UTF-8");
			String name = req.getParameter("name");
			String type = req.getParameter("type");
			String business_no = req.getParameter("business_no");
			String ceo_name = req.getParameter("ceo_name");
			String ceo_phone = req.getParameter("ceo_phone");
			String manager_name = req.getParameter("manager_name");
			String manager_phone = req.getParameter("manager_phone");
			
			MnftDao mdao = new MnftDao();
			MnftDto mdto = new MnftDto();
			mdto.setName(name);
			mdto.setType(type);
			mdto.setBusiness_no(business_no);
			mdto.setCeo_name(ceo_name);
			mdto.setCeo_phone(ceo_phone);
			mdto.setManager_name(manager_name);
			mdto.setManager_phone(manager_phone);
			mdao.registManufacture(mdto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("manufacture_list.do");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
