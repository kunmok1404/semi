package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductCatDao {

	static DataSource src;
	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		}
		catch(Exception e) {
			System.err.println("DBCP ï¿¿À·ù");
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}
	
	public void deleteCat(String name)throws Exception {
		Connection conn = getConnection();
		String sql = "delete product_category where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.execute();
		 
		conn.close();
	}

	public void updateCat(ProductCatDto cdto)throws Exception{
		Connection conn = getConnection();
		String sql = "update product_category set sort_seq=? where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cdto.getSort_seq());
		ps.setString(2, cdto.getName());
		int rs = ps.executeUpdate();
		if(rs==0) {
			registCat(cdto);
		}
		conn.close();
	}
	
	public void registCat(ProductCatDto cdto)throws Exception {
		Connection conn = getConnection();
		String sql = "insert into product_category values(product_categoty_seq.nextval, ?, 'Y', ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cdto.getName());
		ps.setInt(2, cdto.getSort_seq());
		ps.execute();
		
		conn.close();
	}
	
	public List<ProductCatDto> selectCat()throws Exception {
		Connection conn = getConnection();
		String sql = "select * from product_category order by sort_seq asc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<ProductCatDto> list = new ArrayList<>();
		while(rs.next()) {
			 ProductCatDto cdto = new ProductCatDto(rs);
			 list.add(cdto);
		}
		conn.close();
		return list;
	}
}
