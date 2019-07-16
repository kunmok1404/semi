package semi.servlet.cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semi.bean.CartDao;
import semi.bean.CartDto;

@javax.servlet.annotation.WebServlet(urlPatterns={"/cart/cart_regist.do"})
public class CartRegistSerlvet extends HttpServlet
{
  public CartRegistSerlvet() {}
  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/product/product_content.do");
    dispatcher.forward(req, resp);
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
  {
    try
    {
      CartDto cdto = new CartDto();
      cdto.setCart_no(Integer.parseInt(req.getParameter("cartno")));
      cdto.setPrd_no(Integer.parseInt(req.getParameter("prdno")));
      



      String id = (String)req.getSession().getAttribute("id");
      cdto.setLogin_id(id);
      

      CartDao cdao = new CartDao();
      cdao.regist(cdto);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      resp.sendError(500);
    }
  }
}