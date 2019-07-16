package semi.servlet.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.CartDao;
import semi.bean.CartDto;
import semi.bean.MemberDao;
import semi.bean.MemberDto;
import semi.bean.OdDelvAddrDao;
import semi.bean.OdDelvAddrDto;
import semi.bean.OrdersDao;
import semi.bean.OrdersDto;

@WebServlet(urlPatterns = { "/order/order.do" })
public class OrderServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = (String) req.getSession().getAttribute("id");
			OrdersDto odto = new OrdersDto();
			OdDelvAddrDto oddto = new OdDelvAddrDto();
			OdDelvAddrDao oddao = new OdDelvAddrDao();
			oddao.regist(oddto);

			odto.setMember_id(id);
			odto.setProduct_id(Integer.parseInt(req.getParameter("p_id")));
			odto.setStatus_cd("주문대기");
			odto.setPay_type_cd(req.getParameter("p_type_cd"));
			odto.setPay_status_cd(req.getParameter("p_st_cd"));
			odto.setPrice(Integer.parseInt(req.getParameter("price")));
			odto.setDelv_price(Integer.parseInt(req.getParameter("delv_price")));
			odto.setDis_price(Integer.parseInt(req.getParameter("dis_price")));
			odto.setPayback_rate(Integer.parseInt(req.getParameter("payback_rate")));
			odto.setField(Integer.parseInt(req.getParameter("field")));
			
			OrdersDao odao = new OrdersDao();
			odao.order(odto);

			resp.sendRedirect("order_content.do");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("order.jsp");
		dis.forward(req, resp);
		MemberDao mdao = new MemberDao();
//		MemberDto mdto = mdao.get(req.getSession("id"));
		
		CartDao cdao = new CartDao();
//		CartDto cdto = cdao.get(Integer.parseInt(req.getParameter("id")));
		
//		req.setAttribute("mdto", mdto);
//		req.setAttribute("cdto", cdto);
		
	}
}
