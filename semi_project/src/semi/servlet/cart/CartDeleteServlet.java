package semi.servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.beans.CartDao;

@WebServlet(urlPatterns="/cart/cart_delete.do")
public class CartDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//�Է�
			int prd_no = Integer.parseInt(req.getParameter("no"));
			
			//ó��
			CartDao cdao = new CartDao();
			int cart_no = (prd_no);
			
			//���
			resp.sendRedirect("cart_list.do?no"+cart_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
