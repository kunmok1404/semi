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

public class ReviewListDao {
	static DataSource src;
	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.err.println("DBCP 에러");
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		return src.getConnection();
	}
	
	public List<ReviewListDto> list(String m_id) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from product_review_list "
				+ "where 주문자=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, m_id);
		
		ResultSet rs = ps.executeQuery();
		
		List<ReviewListDto> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new ReviewListDto(rs));
		}
		
		con.close();
		
		return list;
	}
}
