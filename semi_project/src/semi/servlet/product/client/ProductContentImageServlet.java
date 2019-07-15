package semi.servlet.product.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.bean.ProductImgDao;
import semi.bean.ProductImgDto;

@WebServlet(urlPatterns = "/product/product_content_image.do")
public class ProductContentImageServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		try {
			int product_id = Integer.parseInt(req.getParameter("id"));
			ProductImgDao idao = new ProductImgDao();
			ProductImgDto vdto = idao.getProductContentImage(product_id);
			resp.reset();
			resp.setHeader("Content-Type", "image/jpg; charset=UTF-8");	
			resp.setHeader("Content-Disposition", "attachment; filename="+vdto.getUpload_name());
			resp.setHeader("Content-Length", String.valueOf(vdto.getFile_size()));
			File target = new File("D:\\KH정보교육원\\중간프로젝트\\upload",vdto.getSave_name());
			InputStream in = new FileInputStream(target);
			OutputStream send = resp.getOutputStream();
				
			byte[] buffer = new byte[1024];
				
			while(true) {
				int size = in.read(buffer);
				if(size==-1) break;
				send.write(buffer,0,size);	
			}
			in.close();
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
