package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class CommentsDao {
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

	public Connection getConnection() throws Exception {
		return getConnection();
	}

	public void enter(CommentsDto dto) throws Exception {
		Connection con = getConnection();
		String sql = "insert into comments values(comments_seq.nextval, ?, ?, sysdate, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMemberId());
		ps.setString(2, dto.getContent());
		ps.setInt(3, dto.getReviewId());
		ps.execute();
		con.close();
	}

	public List<CommentsDto> list(int reviewId) throws Exception {
		Connection con = getConnection();
		String sql = "select * from comments where review_id=? order by id desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, reviewId);
		ResultSet rs = ps.executeQuery();
		List<CommentsDto> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new CommentsDto(rs));
		}
		con.close();
		return list;
	}

	public int getCount(int reviewId) throws Exception {
		Connection con = getConnection();
		String sql = "select count(*) from comments where review_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, reviewId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		con.close();
		return count;
	}

	public int delete(int id) throws Exception {
		Connection con = getConnection();
		String sql = "select origin from comments where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int reviewId = rs.getInt(1);
		ps.close();

		sql = "delete from comments where no=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		con.close();

		return reviewId;
	}

	public void edit(CommentsDto dto) throws Exception {
		Connection con = getConnection();
		String sql = "update comments set content=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getContent());
		ps.setInt(2, dto.getId());
		ps.execute();
		con.close();
	}
}
