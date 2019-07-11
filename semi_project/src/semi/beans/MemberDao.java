package semi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MemberDao {
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
	
	public Connection getConnection() throws Exception{
		return getConnection();
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
		ps.setString(4, mdto.getZipCode());
		ps.setString(5, mdto.getBasicAddr());
		ps.setString(6, mdto.getDetailAddr());
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
}
