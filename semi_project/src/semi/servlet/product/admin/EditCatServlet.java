package semi.servlet.product.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ProductCatDao;
import semi.bean.ProductCatDto;

@WebServlet(urlPatterns = "/admin/product/edit_category.do")
public class EditCatServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			ProductCatDto cdto = new ProductCatDto();
			ProductCatDao cdao = new ProductCatDao();
			Map<String, String[]> map = req.getParameterMap();

			for(String key : map.keySet() ) {
				String[] val = map.get(key);
				//System.out.println(key + " , " + Arrays.toString(val));
				cdto.setName(key);
				cdto.setSort_seq(Integer.parseInt(val[0]));
				cdao.updateCat(cdto);
			}
			
			resp.setContentType("text/plain");
			resp.getWriter().print("Y");
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
