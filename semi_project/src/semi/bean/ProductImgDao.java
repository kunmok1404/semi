package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductImgDao {

	static DataSource src;
	static {
	
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		}
		catch(Exception e) {
			System.err.println("DBCP ¿À·ù");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}

	public void insertImg(ProductImgDto idto) throws Exception{
		Connection conn = getConnection();
		String sql = "insert into product_image values(product_image_seq.nextval, ?, ?, ?, 1, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idto.getProduct_id());
		ps.setString(2, idto.getMain_yn());
		ps.setString(3, idto.getList_yn());
		ps.setString(4, idto.getUpload_name());
		ps.setString(5, idto.getSave_name());
		ps.setString(6, idto.getType());
		ps.setLong(7, idto.getFile_size());
		ps.execute();
		conn.close();
	}

	public void editImg(ProductImgDto idto) throws Exception{
		Connection conn = getConnection();
		String sql="update product_image set main_yn=?, list_yn=?, upload_name=?, save_name=?, type=?, file_size=? where product_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, idto.getMain_yn());
		ps.setString(2, idto.getList_yn());
		ps.setString(3, idto.getUpload_name());
		ps.setString(4, idto.getSave_name());
		ps.setString(5, idto.getType());
		ps.setLong(6, idto.getFile_size());
		ps.setInt(7, idto.getProduct_id());
		ps.execute();
		
		conn.close();
	}

	public ProductImgDto getProductImage(int p_id)throws Exception {
		Connection conn = getConnection();
		String sql = "select * from product_image where product_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p_id);
		ResultSet rs = ps.executeQuery();
		
		ProductImgDto vdto = null;
		
		if(rs.next()) {
			vdto= new ProductImgDto(rs);
		}
			
		conn.close();
		return vdto;
	}
	
	public ProductImgDto getProductList(int p_id)throws Exception {
		Connection conn = getConnection();
		String sql = "select * from product_image where product_id=? and list_yn='Y'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p_id);
		ResultSet rs = ps.executeQuery();
		
		ProductImgDto vdto = null;
		
		if(rs.next()) {
			vdto= new ProductImgDto(rs);
		}
			
		conn.close();
		return vdto;
	}

	public ProductImgDto getProductMainImage(int product_id)throws Exception {
		Connection conn = getConnection();
		String sql = "select * from product_image where product_id=? and main_yn='Y'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, product_id);
		ResultSet rs = ps.executeQuery();
		
		ProductImgDto vdto = null;
		
		if(rs.next()) {
			vdto= new ProductImgDto(rs);
		}
			
		conn.close();
		return vdto;
	}

	public ProductImgDto getProductContentImage(int product_id) throws Exception{
		Connection conn = getConnection();
		String sql = "select * from product_image where product_id=? and main_yn='N' and list_yn='N'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, product_id);
		ResultSet rs = ps.executeQuery();
		
		ProductImgDto vdto = null;
		
		if(rs.next()) {
			vdto= new ProductImgDto(rs);
		}
			
		conn.close();
		return vdto;
	}

}
