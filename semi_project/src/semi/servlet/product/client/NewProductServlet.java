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

@WebServlet(urlPatterns = "/product/new_product.do")
public class NewProductServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			ProductDao pdao = new ProductDao();
			List<PrdRecipeMnftViewDto> p_list = pdao.newProductList();	// 전체 상품정보리스트 
			req.setAttribute("p_list", p_list);
			
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
