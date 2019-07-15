package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MnftDao {

	static DataSource src;
	static {
	
		try {
			Context ctx = new InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		}
		catch(Exception e) {
			System.err.println("DBCP 오류");
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception{
		return src.getConnection();
	}
	
	public void registManufacture(MnftDto mdto) throws Exception{
		Connection conn = getConnection();
		String sql = "insert into manufacture values(manufacture_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, '승인대기','미계약')";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mdto.getName());
		ps.setString(2, mdto.getType());
		ps.setString(3, mdto.getBusiness_no());
		ps.setString(4, mdto.getCeo_name());
		ps.setString(5, mdto.getCeo_phone());
		ps.setString(6, mdto.getManager_name());
		ps.setString(7, mdto.getManager_phone());
		ps.execute();
		
		conn.close();
	}

	public List<MnftDto> manufactureList() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from manufacture order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<MnftDto> list = new ArrayList<MnftDto>();
		while(rs.next()) {
			MnftDto mdto = new MnftDto(rs);
			list.add(mdto);
		}
		conn.close();
		return list;
	}

	public void deleteManufacture(int id) throws Exception{
		Connection conn = getConnection();
		String sql = "delete manufacture where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		conn.close();
	}

	public void applyManufacture(int id)throws Exception{
		Connection conn = getConnection();
		String sql = "update manufacture set apply_status='승인완료', contract_status='계약중' where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		
		conn.close();
	}

	public MnftDto manufactureContent(int no) throws Exception{
		Connection conn = getConnection();
		String sql = "select * from manufacture where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		MnftDto mdto = null;
		if(rs.next()) {
			mdto = new MnftDto(rs);
		}
		conn.close();
		return mdto;
	}

	public void updateManufacture(MnftDto mdto, int id) throws Exception{
		Connection conn = getConnection();
		String sql = "update manufacture set name=?, type=?, business_no=?, ceo_name=?, ceo_phone=?, "
				+ "manager_name=?, manager_phone=?, contract_status=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mdto.getName());
		ps.setString(2, mdto.getType());
		ps.setString(3, mdto.getBusiness_no());
		ps.setString(4, mdto.getCeo_name());
		ps.setString(5, mdto.getCeo_phone());
		ps.setString(6, mdto.getManager_name());
		ps.setString(7, mdto.getManager_phone());
		ps.setString(8, mdto.getContract_status());
		ps.setInt(9, id);
		ps.execute();
		
		conn.close();
	}

	public List<MnftDto> manufactureNameList() throws Exception{
		Connection conn = getConnection();
		String sql = "select * from manufacture where apply_status='승인완료' and contract_status='계약중'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<MnftDto> mlist = new ArrayList<MnftDto>();
		while(rs.next()) {
			MnftDto mdto = new MnftDto(rs);
			mlist.add(mdto);
		}
		conn.close();
		return mlist;
	}

	public int getManufactureId(String name) throws Exception{
		Connection conn = getConnection();
		String sql = "select * from manufacture where name= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int id = rs.getInt("id");
		conn.close();
		return id;
	}

}
