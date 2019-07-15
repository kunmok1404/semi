package semi.servlet.product.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import semi.bean.ProductImgDao;
import semi.bean.ProductImgDto;

@WebServlet(urlPatterns = "/product/product_content.do")
public class ProductContentServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			//상품상세첨부
			int p_id = Integer.parseInt(req.getParameter("p_id"));
			ProductDao pdao = new ProductDao();
			PrdRecipeMnftViewDto pdto = pdao.selectProduct(p_id);
			req.setAttribute("pdto", pdto); 
			
			// 카테고리 종류 가져오기
			ProductCatDao cdao = new ProductCatDao(); 
			List<ProductCatDto> list = cdao.selectCat();
			req.setAttribute("list", list);
			
			// 이미지 정보 조회
//			ProductImgDao idao = new ProductImgDao(); 
//			ProductImgDto vdto = idao.getProductList(p_id);
//			resp.reset();
//			resp.setHeader("Content-Type", "image/jpeg; charset=UTF-8");	
//			resp.setHeader("Content-Disposition", "attachment; filename="+vdto.getUpload_name());
//			resp.setHeader("Content-Length", String.valueOf(vdto.getFile_size()));
//			File target = new File("D:\\KH정보교육원\\중간프로젝트\\upload",vdto.getSave_name());
//			InputStream in = new FileInputStream(target);
//			OutputStream send = resp.getOutputStream();
//				
//				byte[] buffer = new byte[1024];
//				
//				while(true) {
//					int size = in.read(buffer);
//					if(size==-1) break;
//					send.write(buffer,0,size);
//				}
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("product_content.jsp");
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
