package semi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
static DataSource src;
	
	static {
		
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("DBCP 에러");
		}
	}
	
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}
	
	public MemberDto get(String id) throws Exception{
		Connection con = getConnection();
		String sql = "select * from member where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberDto mdto = null;
		if(rs.next()) {
			mdto = new MemberDto(rs);
		}
		con.close();
		
		return mdto;
	}
	
	public List<MemberDto> list() throws Exception{
		Connection con = getConnection();
		String sql = "select * from member order by id";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new MemberDto(rs));
		}
		
		con.close();
		
		return list;
	}
	
	public void edit(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		String sql = "update member set pwd=?, phone=?, email=?, zip_code=?, basic_addr=?, detail_addr=?, question=?, answer=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, mdto.getPwd());
		ps.setString(2, mdto.getPhone());
		ps.setString(3, mdto.getEmail());
		ps.setString(4, mdto.getZip_code());
		ps.setString(5, mdto.getBasic_addr());
		ps.setString(6, mdto.getDetail_addr());
		ps.setString(7, mdto.getQuestion());
		ps.setString(8, mdto.getAnswer());
		ps.setString(9, mdto.getId());
		
		ps.execute();
		
		con.close();
	}
	
	public boolean check(MemberDto mdto) throws Exception{
		Connection con = getConnection();
		String sql = "select * from member where id=? and pwd=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mdto.getId());
		ps.setString(2, mdto.getPwd());
		
		ResultSet rs = ps.executeQuery();
		
		boolean check = rs.next();
		
		con.close();
		
		return check;
	}
	
	public void delete(String id) throws Exception{
		Connection con = getConnection();
		String sql = "delete member where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ps.execute();
		
		con.close();
	}
	
	public String findId(MemberDto dto) throws Exception{
		Connection con = getConnection();
		String sql = "select * from member where name=? and email=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getEmail());
		
		ResultSet rs = ps.executeQuery();
		
		String id = null;
		if(rs.next()) {
			id = rs.getString("id");
		}
		
		con.close();
		
		return id;
	}
	
	public boolean findPwd(MemberDto dto) throws Exception{
		Connection con = getConnection();
		String sql = "select * from member where name=? and email=? and id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getEmail());
		ps.setString(3, dto.getId());
		
		ResultSet rs = ps.executeQuery();
		
		boolean isPwd = rs.next();
		
		con.close();
		
		return isPwd;
	}
	
	public boolean login(MemberDto dto) throws Exception{
		Connection con = getConnection();
		String sql = "select * from member where id=? and pwd=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPwd());
		
		ResultSet rs = ps.executeQuery();
		
		boolean isLogin = rs.next();
		
		con.close();
		
		return isLogin;
	}
	
	public void regist(MemberDto dto) throws Exception{
		Connection con = getConnection();
		String sql = "insert into member values(?, member_seq.nextval, ?, ?, sysdate, '일반', '일반', ?, ?, "
				+ "?, ?, ?, ?, sysdate, null, null, ?, ?, '')";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getPwd());
		ps.setString(4, dto.getBirth());
		ps.setString(5, dto.getPhone());
		ps.setString(6, dto.getEmail());
		ps.setString(7, dto.getZip_code());
		ps.setString(8, dto.getBasic_addr());
		ps.setString(9, dto.getDetail_addr());
		ps.setString(10, dto.getQuestion());
		ps.setString(11, dto.getAnswer());
		
		ps.execute();
		
		con.close();
	}
	
}
