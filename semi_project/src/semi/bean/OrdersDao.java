package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class OrdersDao {
	static DataSource src;

	static {
		try {
			javax.naming.Context ctx = new javax.naming.InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("DBCP ¿¡·¯");
		}
	}

	public OrdersDao() {
	}

	public Connection getConnection() throws Exception {
		return src.getConnection();
	}

	public int getCount(String type, String keyword) throws Exception {
		boolean search = (type != null) && (keyword != null);
		if (search) {
			type = type.replace("+", "||");
		}
		Connection con = getConnection();

		String sql = "select count(*) from orders";
		if (search)
			sql = sql + " where " + type + " like '%'||?||'%'";
		PreparedStatement ps = con.prepareStatement(sql);
		if (search)
			ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);

		con.close();
		return count;
	}

	public List<OrdersDto> search(String type, String keyword, int start, int end) throws Exception {
		type = type.replace("+", "||");
		Connection con = getConnection();

		String sql = "select * from (select rownum rn, A.* from (select * from board where " + type
				+ " like '%'||?||'%' " + "order by when desc" + ") A" + ") where rn between ? and ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs = ps.executeQuery();

		List<OrdersDto> list = new ArrayList();

		while (rs.next()) {
			OrdersDto odto = new OrdersDto();
			odto.setData(rs);
			list.add(odto);
		}

		con.close();
		return list;
	}

	public List<OrdersDto> list(int start, int end) throws Exception {
		Connection con = getConnection();

		String sql = "select * from (select rownum rn, A.* from (select * from orders ) A ) where rn between ? and ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();

		List<OrdersDto> list = new ArrayList();

		while (rs.next()) {
			OrdersDto odto = new OrdersDto();
			odto.setData(rs);
			list.add(odto);
		}

		con.close();
		return list;
	}

	public OrdersDto get(int od_no) throws Exception {
		Connection con = getConnection();

		String sql = "select * from orders where od_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, od_no);
		ResultSet rs = ps.executeQuery();

		OrdersDto odto = null;
		if (rs.next()) {
			odto.setData(rs);
		}
		con.close();
		return odto;
	}

	public void order(OrdersDto odto) throws Exception {
		Connection con = getConnection();

		String sql = "insert into orders values(orders_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, '','', ?, ?,?,?,field_seq.nextval)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, odto.getMember_id());
		ps.setInt(2, odto.getCart_id());
		ps.setInt(3, odto.getProduct_id());
		ps.setString(4, odto.getStatus_cd());
		ps.setString(5, odto.getPay_type_cd());
		ps.setString(6, odto.getPay_status_cd());
		ps.setInt(7, odto.getPrice());
		ps.setInt(8, odto.getDelv_price());
		ps.setInt(9, odto.getDis_price());
		ps.setInt(10, odto.getPayback_rate());

		ps.execute();

		con.close();
	}
}
