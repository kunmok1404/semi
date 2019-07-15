package semi.servlet.order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.util.OrderPaging;

@WebServlet(urlPatterns={"/order/order_list.do"})
public class OrderListServlet extends HttpServlet
{
  public OrderListServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException
  {
    try
    {
      OrderPaging p = new OrderPaging(req);
      p.calculate();
      

      req.setAttribute("o_p", p);
      

      RequestDispatcher dispatcher = 
        req.getRequestDispatcher("order.jsp");
      dispatcher.forward(req, resp);
    }
    catch (Exception e) {
      e.printStackTrace();
      resp.sendError(500);
    }
  }
}