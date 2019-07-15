package semi.servlet.product.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.PrdRecipeMnftViewDto;
import semi.bean.ProductCatDao;
import semi.bean.ProductCatDto;
import semi.bean.ProductDao;

@WebServlet(urlPatterns = "/product/product_cat_list.do")
public class ProductCatListServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String p_cat = req.getParameter("product_category_name"); // 카테고리별 상품리스트
			ProductDao pdao = new ProductDao();
			List<PrdRecipeMnftViewDto> p_list = pdao.getCatPrdList(p_cat);
			req.setAttribute("p_list", p_list);
			req.setAttribute("cat", p_cat); // 클릭한 카테고리 첨부
			
			ProductCatDao cdao = new ProductCatDao(); // 카테고리 종류 가져오기
			List<ProductCatDto> list = cdao.selectCat();
			req.setAttribute("list", list);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("product_list.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
