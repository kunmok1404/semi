package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentsDao {

	static DataSource src;
	static {
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		}
		catch(Exception e) {
			System.err.println("DBCP ����");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}

//	��� ���
	public void insert(CommentsDto cdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "insert into comments values("
				+ "comments_seq.nextval, ?, ?, sysdate, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getWriter());
		ps.setString(2, cdto.getContent());
		ps.setInt(3, cdto.getOrigin());
		ps.execute();
		
		con.close();
	}
	
//	��� ���
	public List<CommentsDto> get(int origin) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from comments "
								+ "where origin=? order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, origin);
		ResultSet rs = ps.executeQuery();
		
		List<CommentsDto> list = new ArrayList<>();
		while(rs.next()) {
			CommentsDto cdto = new CommentsDto(rs);
			list.add(cdto);
		}
		
		con.close();
		
		return list;
	}

//	2���� ������� ���� �� �����۹�ȣ�� ��ȯ�ϵ��� ����
//	[1] no�� �ش��ϴ� ����� �����۹�ȣ�� ���ض�
//	[2] no�� �ش��ϴ� ����� �����ض�
	public int delete(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "select origin from comments where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		rs.next();//100%
		int origin = rs.getInt("origin");
		ps.close();
		
		sql = "delete comments where no=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
		return origin;
	}
	public void edit(CommentsDto cdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update comments set content=? where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getContent());
		ps.setInt(2, cdto.getNo());
		ps.execute();
		
		con.close();
	}
	
}

