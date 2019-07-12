package semi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			System.err.println("DBCP 에러");
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}
	//회원가입
	public void regist(MemberDto dto) throws Exception {
		Connection con = getConnection();
		String sql = "insert into member values(?,member_seq.nextval,?,?,sysdate,'일반','일반',?,?,?,?,?,?,sysdate,'','',?,?,'')";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,dto.getId());
		ps.setString(2,dto.getName());
		ps.setString(3,dto.getPwd());
		ps.setString(4,dto.getBirth());
		ps.setString(5,dto.getPhone());
		ps.setString(6,dto.getEmail());
		ps.setString(7,dto.getZip_code());
		ps.setString(8,dto.getBasic_addr());
		ps.setString(9,dto.getDetail_addr());
		ps.setString(10, dto.getQuestion());
		ps.setString(11, dto.getAnswer());
		
		
		con.close();
	}
	
	public boolean login(MemberDto dto) throws Exception{
		String sql = "select * from member where id=? and pwd=?";
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPwd());
		
		ResultSet rs = ps.executeQuery();
		boolean login = rs.next();
		con.close();
		return login;
	}
	
	public String findid(MemberDto dto) throws Exception {
		Connection con = getConnection();
		String sql = "select * from member where name=? and email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getEmail());
		
		ResultSet rs = ps.executeQuery();
		
		String id = null;
		if(rs.next()) {
			id=rs.getString("id");
		}
		
		con.close();
		return id;
	}
	
	public boolean findpwd(MemberDto dto) throws Exception {
		Connection con = getConnection();
		String sql = "select * from member where name=? and id=? and email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getId());
		ps.setString(3, dto.getEmail());
		
		ResultSet rs = ps.executeQuery();
		boolean pwd = rs.next();
		
		return pwd;
	}
	
	public void delete(String id) throws Exception {
		Connection con = getConnection();
		String sql = "delete member where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,id);
		ps.execute();
		
		con.close();
		
		
	}

}
