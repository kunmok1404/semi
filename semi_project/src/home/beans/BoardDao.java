package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao {

//	������ ���� ���(���� ������ ����)
//	public Connection getConnection() throws Exception{
//		Class.forName("oracle.jdbc.OracleDriver");
//		return DriverManager.getConnection(
//				"jdbc:oracle:thin:@localhost:1521:xe", "home", "home");
//	}
	
//	������ ���� ���(DBCP���, �̸� ����� �ΰ� ��Ż�ϴ� ���)
//	 - context.xml�� �ִ� Resource ������ �˾ƾ߸� ��Ż�� ����
//	 - static Ű���带 �ٿ��� ��� DAO �ν��Ͻ��� �������� ����
//	static DataSource src = context.xml�� �ִ� resource ����;
	static DataSource src;
	static {
//		src�� �ʱ�ȭ�Ϸ��� �ڵ尡 �����ϹǷ� ���� �ʱ�ȭ ������ ���
//		[1] ���ϰ� �ڿ��� ã�� �� �ִ� Ž�� ��ü ����
//		[2] Ž�� ��ü�� �̿��Ͽ� jdbc/oracle �̸��� ���� �ڿ� ������ src�� ����
		
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
	
//	��� �޼ҵ�
	public List<BoardDto> list(int start, int end) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from ("
								+ "select rownum rn, A.* from ("
									//������ SQL ���
									+ "select * from board "
									+ "connect by prior no=parent "
									+ "start with parent is null "
									+ "order siblings by team desc, no asc"
								+ ") A"
							+ ") where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> list = new ArrayList<>();
		
		while(rs.next()) {
			BoardDto bdto = new BoardDto();
			//���� ���� �����͸� bdto�� ����
			bdto.setData(rs);
			list.add(bdto);
		}
		
		con.close();
		return list;
	}
	
//	�׸� ����
	public BoardDto get(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from board where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		BoardDto bdto;
		if(rs.next()) {
			bdto = new BoardDto();
			bdto.setData(rs);
		}
		else {
			bdto = null;
		}
		
		con.close();
		return bdto;
	}

//	��� : ���� ����ְ� ��ȣ ��ȯ
	public int write(BoardDto bdto) throws Exception{
		Connection con = getConnection();
		
//		[1] ���� �� �Խñ��� ��ȣ�� ���� ���Ѵ�
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();//���� �����ͷ� �̵�(������ 1��)
		int no = rs.getInt("nextval");
//		int no = rs.getInt(1);
		ps.close();
		
//		[2] ����� ���� �θ���� team ��ȣ�� �̸� ���Ѵ�
		int team;
		if(bdto.getParent() == 0) {//����
			team = no;
		}
		else {//���
			sql = "select team from board where no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bdto.getParent());
			rs = ps.executeQuery();
			rs.next();
			team = rs.getInt("team");
			ps.close();
		}
		
		
//		[3] 1������ ���� ��ȣ�� �̿��Ͽ� �Խñ��� �߰��Ѵ�
		sql = "insert into board values("
				+ "?, ?, ?, ?, ?, sysdate, 0, ?, "
				//nvl(�׸�, ��) : �׸��� null�� �� ������ ġȯ
				//nvl(depth, 0) : depth�� null�̸� 0���� �ٲټ���
				+ "(select nvl(depth, 0) +1 from board where no=?), ?"
			+ ")";
		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, bdto.getHead());
		ps.setString(3, bdto.getTitle());
		ps.setString(4, bdto.getWriter());
		ps.setString(5, bdto.getContent());
		if(bdto.getParent() == 0)
			ps.setNull(6, Types.INTEGER);//null�� �߰��ϴ� �ڵ�
		else
			ps.setInt(6, bdto.getParent());
		ps.setInt(7, bdto.getParent());
		ps.setInt(8, team);//2������ ����� team ��
		ps.execute();
		
		con.close();
		return no;
	}
	
//	��ȸ�� ���� �޼ҵ�
	public void read(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "update board set read = read + 1 where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}

//	�� ����
	public void delete(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "delete board where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}

//	�� ����
	public void edit(BoardDto bdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update board "
									+ "set head=?, title=?, content=? "
									+ "where no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bdto.getHead());
		ps.setString(2, bdto.getTitle());
		ps.setString(3, bdto.getContent());
		ps.setInt(4, bdto.getNo());
		ps.execute();
		
		con.close();
	}
	
//	�˻� �޼ҵ�
//	type=writer �̰ų� type=title+content �̰ų� �� �� �ϳ�
//	type=title+content��� +�� ||�� �ٲ㼭 ó��
//	select * from board where writer like ? order by when desc
//	select * from board where title like ? or content like ? order by..
//	select * from board where title || content like ? order by ...
	
	public List<BoardDto> search(
			String type, String keyword, int start, int end) throws Exception{
		type = type.replace("+", "||");
		Connection con = getConnection();
		
		String sql = 
		"select * from ("
			+ "select rownum rn, A.* from ("
				+ "select * from board where "+type+" like '%'||?||'%' "
				+ "order by when desc"
			+ ") A"
		+ ") where rn between ? and ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> list = new ArrayList<>();
		
		while(rs.next()) {
			BoardDto bdto = new BoardDto();
			bdto.setData(rs);
			list.add(bdto);
		}
		
		con.close();
		return list;
	}
	
//	�Խñ� ������ ���ϴ� �޼ҵ�(����¡��)
	public int getCount(String type, String keyword) throws Exception{
		boolean search = type != null && keyword != null;
		if(search) type = type.replace("+", "||");
		
		Connection con = getConnection();
		
		
		String sql = "select count(*) from board";
		if(search)		sql += " where "+type+" like '%'||?||'%'";
		PreparedStatement ps = con.prepareStatement(sql);
		if(search)		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		con.close();
		return count;
	}
}









