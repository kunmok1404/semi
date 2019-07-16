package semi.servlet.cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semi.bean.CartDao;

@WebServlet(urlPatterns={"/cart/cart_delete.do"})
public class CartDeleteServlet extends HttpServlet
{
  public CartDeleteServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException
  {
    try
    {
      int no = Integer.parseInt(req.getParameter("cartno"));
      

      CartDao cdao = new CartDao();
      cdao.delete(no);
      

      resp.sendRedirect("cart.do");
    } catch (Exception e) {
      e.printStackTrace();
      resp.sendError(500);
    }
  }
}