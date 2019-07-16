package semi.servlet.order;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import semi.bean.OrdersDao;
import semi.bean.OrdersDto;



@WebServlet(urlPatterns={"/order/order_content.do"})
public class OrderContentServlet
  extends HttpServlet
{
  public OrderContentServlet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    try
    {
      int od_no = Integer.parseInt(req.getParameter("orderno"));
      OrdersDao odao = new OrdersDao();
      
      OrdersDto odto = odao.get(od_no);
      

      String login_id = (String)req.getSession().getAttribute("id");
      boolean my = odto.getMember_id().equals(login_id);
      


      req.setAttribute("odto", odto);
      req.setAttribute("my", Boolean.valueOf(my));
      


      RequestDispatcher dispatcher = 
        req.getRequestDispatcher("content.jsp");
      dispatcher.forward(req, resp);
    }
    catch (Exception e) {
      e.printStackTrace();
      resp.sendError(500);
    }
  }
}