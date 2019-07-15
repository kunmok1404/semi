package home.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
//	연결만 처리해서 반환하는 메소드
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "home3", "home3");
		return con;
	}
	
	public void regist(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "insert into member values("
				+ "member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, '일반', null)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getId());
		ps.setString(2, mdto.getPw());
		ps.setString(3, mdto.getName());
		ps.setString(4, mdto.getBirth());
		ps.setString(5, mdto.getPhone());
		ps.setString(6, mdto.getQuestion());
		ps.setString(7, mdto.getAnswer());
		ps.execute();
		
		con.close();
	}

	public boolean login(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getId());
		ps.setString(2, mdto.getPw());
		ResultSet rs = ps.executeQuery();
		
		boolean result = rs.next();
		
		con.close();
		return result;
	}

	public String findId(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "select id from member "
								+ "where name=? and birth=? and phone=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getName());
		ps.setString(2, mdto.getBirth());
		ps.setString(3, mdto.getPhone());
		ResultSet rs = ps.executeQuery();
		
//		String id = null or rs.getString("id");
		String id;
		if(rs.next())
			id = rs.getString("id");
		else
			id = null;
		
		con.close();
		return id;
	}
	
//	비밀번호 탐색 메소드
	public boolean findPw(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		String sql = "select * from member "
							+ "where id=? and question=? and answer=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getId());
		ps.setString(2, mdto.getQuestion());
		ps.setString(3, mdto.getAnswer());
		ResultSet rs = ps.executeQuery();
		boolean exist = rs.next();
		con.close();
		
		return exist;
	}

	public void changePw(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update member set pw=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getPw());
		ps.setString(2, mdto.getId());
		ps.execute();
		
		con.close();
	}
	
//	회원정보 확인 메소드
	public MemberDto get(String id) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		MemberDto mdto;
		if(rs.next()) {//있으면 MemberDto객체를 만들고 11개를 복사
			mdto = new MemberDto();
			mdto.setNo(rs.getInt("no"));
			mdto.setId(rs.getString("id"));
			mdto.setPw(rs.getString("pw"));
			mdto.setName(rs.getString("name"));
			mdto.setBirth(rs.getString("birth"));
			mdto.setPhone(rs.getString("phone"));
			mdto.setQuestion(rs.getString("question"));
			mdto.setAnswer(rs.getString("answer"));
			mdto.setRegist(rs.getString("regist"));
			mdto.setGrade(rs.getString("grade"));
			mdto.setRecent(rs.getString("recent"));
		}
		else {//없으면 null인 상태로 반환
			mdto = null;
		}
		
		con.close();
		return mdto;
	}

	public void delete(String id) throws Exception{
		Connection con = getConnection();
		
		String sql = "delete member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.execute();
		
		con.close();
	}

	public void updateInfo(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update member "
							+ "set phone=?, question=?, answer=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getPhone());
		ps.setString(2, mdto.getQuestion());
		ps.setString(3, mdto.getAnswer());
		ps.setString(4, mdto.getId());
		ps.execute();
		
		con.close();
	}
	
	public void recent(String id) throws Exception{
		Connection con = getConnection();
		
		String sql = "update member set recent=sysdate where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.execute();
		
		con.close();
	}
	
//	목록 메소드
	public List<MemberDto> search(String type, String keyword) throws Exception{
		Connection con = getConnection();
		
		String sql = "select * from member "
				+ "where "+type+" like '%'||?||'%' order by "+type;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto mdto = new MemberDto();
			mdto.setNo(rs.getInt("no"));
			mdto.setId(rs.getString("id"));
			mdto.setPw(rs.getString("pw"));
			mdto.setName(rs.getString("name"));
			mdto.setBirth(rs.getString("birth"));
			mdto.setPhone(rs.getString("phone"));
			mdto.setQuestion(rs.getString("question"));
			mdto.setAnswer(rs.getString("answer"));
			mdto.setRegist(rs.getString("regist"));
			mdto.setGrade(rs.getString("grade"));
			mdto.setRecent(rs.getString("recent"));
			list.add(mdto);
		}
		
		con.close();
		return list;
	}

//	관리자 수정 메소드
	public void edit(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update member "
				+ "set name=?,birth=?,phone=?,question=?,answer=?,grade=? "
				+ "where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getName());
		ps.setString(2, mdto.getBirth());
		ps.setString(3, mdto.getPhone());
		ps.setString(4, mdto.getQuestion());
		ps.setString(5, mdto.getAnswer());
		ps.setString(6, mdto.getGrade());
		ps.setString(7, mdto.getId());
		ps.execute();
		
		con.close();
	}
}












