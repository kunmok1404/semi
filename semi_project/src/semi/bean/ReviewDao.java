package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReviewDao {
	static DataSource src;
	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.err.println("DBCP ����");
			e.printStackTrace();
		}
	}  

	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
	
	public void write(ReviewDto rdto) throws Exception{
		Connection con = getConnection();
		String sql = "insert into product_review values(review_seq.nextval,?, ?, ?, ?, ?, sysdate, '')";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, rdto.getProductId());
		ps.setString(2, rdto.getMemberId());
		ps.setString(3, rdto.getTitle());
		ps.setString(4, rdto.getContent());
		ps.setInt(5, rdto.getGrade());
		ps.setString(6, rdto.getDateCreated());
		ps.setString(7, rdto.getDateUpdate());
		
		ps.execute();
		
		con.close();
	}
	
	public ReviewDto get(int r_id) throws Exception{
		Connection con = getConnection();
		String sql = "select * from product_review where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, r_id);
		
		ResultSet rs = ps.executeQuery();
		
		ReviewDto rdto = null;
		
		if(rs.next()) {
			rdto = new ReviewDto(rs);
		}
		
		con.close();
		
		return rdto;
	}
	
	public void delete(int id) throws Exception{
		Connection con = getConnection();
		String sql = "delete product_review where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ps.execute();
		
		con.close();
	}
	
	public void edit(ReviewDto rdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update product_review set title=?, content=?, grade=?, date_upadate=sysdate "
				+ "where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, rdto.getTitle());
		ps.setString(2, rdto.getContent());
		ps.setInt(3, rdto.getGrade());
		ps.setInt(4, rdto.getId());
		
		ps.execute();
		
		con.close();
	}
}