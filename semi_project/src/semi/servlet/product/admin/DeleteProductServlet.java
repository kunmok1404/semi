package semi.servlet.product.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ProductDao;
import semi.bean.ProductImgDao;
import semi.bean.ProductImgDto;

@WebServlet(urlPatterns = "/admin/product/delete_product.do")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int p_id = Integer.parseInt(req.getParameter("p_id"));
			
			ProductImgDao idao = new ProductImgDao(); 
			ProductImgDto vdto = idao.getProductImage(p_id);
			System.out.println(p_id);
			System.out.println(vdto);
			File target = new File("D:\\KH정보교육원\\중간프로젝트\\upload",vdto.getSave_name()); 
			target.delete(); 
			
			ProductDao pdao = new ProductDao(); 
			pdao.deleteProduct(p_id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("product_list.do");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
