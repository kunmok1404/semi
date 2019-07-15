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
@WebServlet(urlPatterns = "/admin/manufacture/update_manufacture.do")
public class UpdateManufactureServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String type = req.getParameter("type");
			String business_no = req.getParameter("business_no");
			String ceo_name = req.getParameter("ceo_name");
			String ceo_phone = req.getParameter("ceo_phone");
			String manager_name = req.getParameter("manager_name");
			String manager_phone = req.getParameter("manager_phone");
			String contract_status = req.getParameter("contract_status");
			
			MnftDao mdao = new MnftDao();
			MnftDto mdto = new MnftDto();
			mdto.setName(name);
			mdto.setType(type);
			mdto.setBusiness_no(business_no);
			mdto.setCeo_name(ceo_name);
			mdto.setCeo_phone(ceo_phone);
			mdto.setManager_name(manager_name);
			mdto.setManager_phone(manager_phone);
			mdto.setContract_status(contract_status);
			
			mdao.updateManufacture(mdto, id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("manufacture_list.do");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
