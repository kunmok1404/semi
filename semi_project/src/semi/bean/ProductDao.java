package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDao {

	static DataSource src;
	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		}
		catch(Exception e) {
			System.err.println("DBCP 오류");
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}
	
	public int registProduct(ProductDto rdto) throws Exception{
		Connection conn = getConnection();
		
		String sql="select product_image_seq.nextval from dual";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int p_id = rs.getInt("nextval");
		ps.close();
	
		sql = "insert into product values(?, ? , 1, ? , ? , ?, "
				+ "? , ? , ? , ? , ? , ? , ? , '승인대기', sysdate, 'N', '판매중지' , 1 , ? , 'N' , 10000, sysdate, 0,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, p_id);
		ps.setString(2, rdto.getProduct_category_name());
		ps.setInt(3, rdto.getManufacture_id());
		ps.setString(4, rdto.getName());
		ps.setString(5, rdto.getTitle());
		ps.setString(6, rdto.getContent());
		ps.setString(7, rdto.getP_size());
		ps.setString(8, rdto.getUnit());
		ps.setInt(9, rdto.getApply_price());
		ps.setInt(10, rdto.getOrigin_price());
		ps.setInt(11, rdto.getDis_rate());
		ps.setInt(12, rdto.getStock());
		ps.setInt(13, rdto.getBsc_delv_price());
		ps.setString(14, rdto.getSale_yn());
		ps.setString(15, rdto.getNew_yn());
		ps.execute();
		conn.close();
		
		return p_id;
	}

		public List<PrdRecipeMnftViewDto> ProductList() throws Exception{
			Connection conn = getConnection();
			String sql = "select * from prd_recipe_mnft";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<PrdRecipeMnftViewDto> list = new ArrayList<PrdRecipeMnftViewDto>();
			while(rs.next()) {
				PrdRecipeMnftViewDto rdto = new PrdRecipeMnftViewDto(rs);
				list.add(rdto);
			}
			conn.close();
			return list;
		}
	
	public List<PrdRecipeMnftViewDto> applyProductList() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from prd_recipe_mnft where apply_status='승인완료' and sale_status='판매중'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PrdRecipeMnftViewDto> list = new ArrayList<PrdRecipeMnftViewDto>();
		while(rs.next()) {
			PrdRecipeMnftViewDto rdto = new PrdRecipeMnftViewDto(rs);
			list.add(rdto);
		}
		conn.close();
		return list;
	}
	
	public PrdRecipeMnftViewDto selectProduct(int p_id) throws Exception{
		Connection conn = getConnection();
		String sql = "select * from prd_recipe_mnft where p_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p_id);
		ResultSet rs = ps.executeQuery();
		PrdRecipeMnftViewDto vdto = null; 
		if(rs.next()) {
			vdto = new PrdRecipeMnftViewDto(rs);
		}
		conn.close();
		return vdto;
	}

	public void updateProduct(ProductDto rdto)throws Exception {
		Connection conn = getConnection();
		String sql = "update product set product_category_name=?, name=?, title=?, p_size=?, unit=?, "
				+ "apply_price=?, origin_price=?, dis_rate=?, bsc_delv_price=?, "
				+ "stock=?, content=?, sale_status=? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, rdto.getProduct_category_name());
		ps.setString(2, rdto.getName());
		ps.setString(3, rdto.getTitle());
		ps.setString(4, rdto.getP_size());
		ps.setString(5, rdto.getUnit());
		ps.setInt(6, rdto.getApply_price());
		ps.setInt(7, rdto.getOrigin_price());
		ps.setInt(8, rdto.getDis_rate());
		ps.setInt(9, rdto.getBsc_delv_price());
		ps.setInt(10, rdto.getStock());
		ps.setString(11, rdto.getContent());
		ps.setString(12, rdto.getSale_status());
		ps.setInt(13, rdto.getId());
		
		ps.execute();
		
		conn.close();
	}

	public void deleteProduct(int no) throws Exception {
		Connection conn = getConnection();
		String sql = "delete product where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		conn.close();
	}

	public void applyProduct(int no) throws Exception{
		Connection conn = getConnection();
		String sql = "update product set apply_status=? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "승인완료");
		ps.setInt(2, no);
		ps.execute();
		
		conn.close();
	}

	public int ProductCount() throws Exception{
		Connection conn = getConnection();
		String sql = "select count(id) as count from product";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt("count");
		conn.close();
		
		return count;
	}

	public int applyOk()throws Exception{
		Connection conn = getConnection();
		String sql = "select count(apply_status) as applyOk from product where apply_status='승인완료'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int applyOk = rs.getInt("applyOk");
		conn.close();
		
		return applyOk;
	}

	public List<ProductDto> getNoList() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from product";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ProductDto> Nolist = new ArrayList<ProductDto>();
		while(rs.next()) {
			ProductDto pdto = new ProductDto(rs);
			Nolist.add(pdto);
		}
		conn.close();
		return Nolist;
	}

	public List<PrdRecipeMnftViewDto> getCatPrdList(String p_cat) throws Exception{
		Connection conn = getConnection();
		String sql="select * from prd_recipe_mnft where product_category_name=? and apply_status='승인완료' and sale_status='판매중'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p_cat);
		ResultSet rs = ps.executeQuery();
		
		List<PrdRecipeMnftViewDto> p_list = new ArrayList<PrdRecipeMnftViewDto>();
		while(rs.next()) {
			PrdRecipeMnftViewDto vdto = new PrdRecipeMnftViewDto(rs);
			p_list.add(vdto);
		} 
		conn.close();
		return p_list;
	}

	public List<PrdRecipeMnftViewDto> newProductList() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from prd_recipe_mnft where apply_status='승인완료' and sale_status='판매중' order by regist_date desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PrdRecipeMnftViewDto> list = new ArrayList<PrdRecipeMnftViewDto>();
		while(rs.next()) {
			PrdRecipeMnftViewDto rdto = new PrdRecipeMnftViewDto(rs);
			list.add(rdto);
		}
		conn.close();
		return list;
	}

	public List<PrdRecipeMnftViewDto> bestProductList() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from prd_recipe_mnft where apply_status='승인완료' and sale_status='판매중' order by sale_total desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PrdRecipeMnftViewDto> list = new ArrayList<PrdRecipeMnftViewDto>();
		while(rs.next()) {
			PrdRecipeMnftViewDto rdto = new PrdRecipeMnftViewDto(rs);
			list.add(rdto);
		}
		conn.close();
		return list;
	}

	public List<PrdRecipeMnftViewDto> saleProductList()throws Exception{
		Connection conn = getConnection();
		String sql = "select * from prd_recipe_mnft where apply_status='승인완료' and sale_status='판매중' order by dis_rate desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<PrdRecipeMnftViewDto> list = new ArrayList<PrdRecipeMnftViewDto>();
		while(rs.next()) {
			PrdRecipeMnftViewDto rdto = new PrdRecipeMnftViewDto(rs);
			list.add(rdto);
		}
		conn.close();
		return list;
	}
}
