package semi.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/order/order_status.do"})
public class OrderStatusServlet
  extends HttpServlet
{
  public OrderStatusServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {}
}