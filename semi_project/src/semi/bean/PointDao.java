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

	// 적립, 취소, 환불, 구매
	public void pointUse(PointDto dto) throws Exception {
		Connection con = getConnection();

		String sql = "insert into point values(?, null, ?, ?, sysdate, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMemberId());
		ps.setString(2, dto.getUseType());
		ps.setInt(3, dto.getPoint());
		ps.setInt(4, dto.getCurrentPoint() + dto.getPoint());
		ps.setString(5, dto.getReason());

		ps.execute();

		con.close();
	}

	// 충전, 적립, 취소, 환불, 구매
	public void pointCharge(PointDto dto) throws Exception {
		Connection con = getConnection();

		String sql = "insert into point values((select id from member where id=?), '', ?, ?, sysdate, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMemberId());
		ps.setString(2, dto.getUseType());
		ps.setInt(3, dto.getPoint());
		ps.setInt(4, dto.getCurrentPoint() + dto.getPoint());
		ps.setString(5, dto.getReason());

		ps.execute();

		con.close();
	}
	
	public void pointRegist(String m_id) throws Exception {
		Connection con = getConnection();

		String sql = "insert into point values((select id from member where id=?), '', '적립', 1000, sysdate, 1000, '회원가입 축하 보너스')";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, m_id);
	
		ps.execute();

		con.close();
	}

	public PointDto get(String id) throws Exception {
		Connection con = getConnection();

		String sql = "select * from point where member_id=? order by use_date desc";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		PointDto dto = null;

		if (rs.next()) {
			dto = new PointDto(rs);
		}

		con.close();

		return dto;
	}

	public List<PointDto> list(String id) throws Exception {
		Connection con = getConnection();

		String sql = "select * from point where member_id=? order by use_date desc";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		List<PointDto> pList = new ArrayList<>();

		while (rs.next()) {
			pList.add(new PointDto(rs));
		}

		con.close();

		return pList;
	}

	// 포인트 관리
	public void pointManage(PointDto pdto) throws Exception{
		Connection conn = getConnection();
		String sql = "update point set current_point = current_point + ?, use_type=?, reason=? where member_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pdto.getPoint());
		ps.setString(2, pdto.getUseType());
		ps.setString(3, pdto.getReason());
		ps.setString(4, pdto.getMemberId());
		ps.executeUpdate();
		
		conn.close();
	}
}
