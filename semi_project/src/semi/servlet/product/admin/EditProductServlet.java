package semi.servlet.product.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.bean.MnftDao;
import semi.bean.MnftDto;
import semi.bean.PrdRecipeMnftViewDto;
import semi.bean.ProductDao;
import semi.bean.ProductDto;
import semi.bean.ProductImgDao;
import semi.bean.ProductImgDto;

@WebServlet(urlPatterns = "/admin/product/product_content.do")
public class EditProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int p_id = Integer.parseInt(req.getParameter("p_id"));
			ProductDao pdao = new ProductDao();
			List<PrdRecipeMnftViewDto> list = pdao.ProductList();
			PrdRecipeMnftViewDto vdto = pdao.selectProduct(p_id);
			MnftDao mdao = new MnftDao();
			List<MnftDto> mlist = mdao.manufactureNameList();
			req.setAttribute("vdto", vdto); 
			req.setAttribute("list", list);	
			req.setAttribute("mlist", mlist); 
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("product_content.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String path="D:\\KH정보교육원\\중간프로젝트\\upload";
			int max = 30 * 1024 * 1024; 
			String enc = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequest = new MultipartRequest(req, path, max, enc, policy);
			
			String category = mRequest.getParameter("category");
			String name = mRequest.getParameter("name");
			String title = mRequest.getParameter("title");
			String content = mRequest.getParameter("content");
			int p_id = Integer.parseInt(mRequest.getParameter("p_id"));
			String size = mRequest.getParameter("size");
			String unit = mRequest.getParameter("unit");
			int apply_price = Integer.parseInt(mRequest.getParameter("apply_price"));
			int origin_price = Integer.parseInt(mRequest.getParameter("origin_price"));
			int dis_rate = Integer.parseInt(mRequest.getParameter("dis_rate"));
			int delv_price = Integer.parseInt(mRequest.getParameter("delv_price"));
			int stock = Integer.parseInt(mRequest.getParameter("stock"));
			String sale_status = mRequest.getParameter("sale_status");
			
			ProductDto rdto = new ProductDto();
			rdto.setProduct_category_name(category);
			rdto.setName(name);
			rdto.setTitle(title);
			rdto.setContent(content);
			rdto.setP_size(size);
			rdto.setUnit(unit);
			rdto.setApply_price(apply_price);
			rdto.setOrigin_price(origin_price);
			rdto.setDis_rate(dis_rate);
			rdto.setBsc_delv_price(delv_price);
			rdto.setStock(stock);
			rdto.setId(p_id);
			rdto.setSale_status(sale_status);
			
			ProductDao rdao = new ProductDao();
			rdao.updateProduct(rdto);
			
			File f_main = mRequest.getFile("f_main");
			File f_list = mRequest.getFile("f_list");
			File f_content = mRequest.getFile("f_content");
			
			if(f_main != null) {
				ProductImgDto idto = new ProductImgDto();
				idto.setProduct_id(p_id);
				idto.setMain_yn("Y");
				idto.setList_yn("N");
				idto.setUpload_name(mRequest.getOriginalFileName("f_main"));
				idto.setSave_name(mRequest.getFilesystemName("f_main"));
				idto.setType(mRequest.getContentType("f_main"));
				idto.setFile_size(f_main.length());
				ProductImgDao idao = new ProductImgDao();
				idao.editImg(idto);
			}
			
			if(f_list != null) {
				ProductImgDto idto = new ProductImgDto();
				idto.setProduct_id(p_id);
				idto.setMain_yn("N");
				idto.setList_yn("Y");
				idto.setUpload_name(mRequest.getOriginalFileName("f_list"));
				idto.setSave_name(mRequest.getFilesystemName("f_list"));
				idto.setType(mRequest.getContentType("f_list"));
				idto.setFile_size(f_list.length());
				ProductImgDao idao = new ProductImgDao();
				idao.editImg(idto);
			}
			
			if(f_content != null) {
				ProductImgDto idto = new ProductImgDto();
				idto.setProduct_id(p_id);
				idto.setMain_yn("N");
				idto.setList_yn("N");
				idto.setUpload_name(mRequest.getOriginalFileName("f_content"));
				idto.setSave_name(mRequest.getFilesystemName("f_content"));
				idto.setType(mRequest.getContentType("f_content"));
				idto.setFile_size(f_content.length());
				ProductImgDao idao = new ProductImgDao();
				idao.editImg(idto);
			}
			
			resp.sendRedirect("product_list.do");
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
