package semi.servlet.cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semi.util.CartPaging;

@WebServlet(urlPatterns={"/cart/cart_list.do"})
public class CartListServlet extends HttpServlet
{
  public CartListServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException
  {
    try
    {
      CartPaging p = new CartPaging();
      p.calculate();
      


      req.setAttribute("c_p", p);
      

      RequestDispatcher dispatcher = 
        req.getRequestDispatcher("order.do");
      dispatcher.forward(req, resp);
    }
    catch (Exception e) {
      e.printStackTrace();
      resp.sendError(500);
    }
  }
}