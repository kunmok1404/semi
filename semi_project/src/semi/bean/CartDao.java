package semi.bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDao {
	static DataSource src;

	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("DBCP ¿¡·¯");
		}
	}

	public CartDao() {
	}

	public Connection getConnection() throws Exception {
		return src.getConnection();
	}

	public void regist(CartDto cdto) throws Exception {
		Connection con = getConnection();
		String sql = "insert into cart value(cart_seq.nextval,?,?,1)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getLogin_id());
		ps.setInt(2, cdto.getPrd_no());
		ps.execute();
		con.close();
	}

	public void delete(int no) throws Exception {
		Connection con = getConnection();

		String sql = "delete cart where cart_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();

		con.close();
	}

	public List<CartDto> list(int start, int end) throws Exception {
		Connection con = getConnection();

		String sql = "select * from (select rownum rn, A.* from (select * from cart) A) where rn between ? and ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<CartDto> list = new java.util.ArrayList();

		while (rs.next()) {
			CartDto cdto = new CartDto();
			cdto.setData(rs);
			list.add(cdto);
		}

		con.close();
		return list;
	}

	public CartDto get(int id) throws Exception {
		Connection con = getConnection();

		String sql = "select * from cart where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		CartDto cdto = null;
		if (rs.next()) {
			cdto.setData(rs);
		}
		con.close();
		return cdto;
	}
}
