package semi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PointDao {
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
	
	//충전, 적립, 취소, 환불, 구매
	public void pointUse(PointDto dto) throws Exception {
		Connection con = getConnection();

		String sql = "insert into point values(?, ?, ?, ?, sysdate, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMemberId());
		ps.setInt(2, dto.getOrdersId());
		ps.setString(3, dto.getUseType());
		ps.setInt(4, dto.getPoint());
		ps.setInt(5, dto.getCurretPoint() + dto.getPoint());
		ps.setString(6, dto.getReason());

		ps.execute();

		con.close();
	}
	
	public List<PointDto> get(String id) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from point where member_id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		List<PointDto> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new PointDto(rs));
		}
		
		con.close();
		
		return list;
	}
}
