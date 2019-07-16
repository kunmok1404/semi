package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.sql.DataSource;

public class OdDelvAddrDao {
	static DataSource src;

	static {
		try {
			Context ctx = new javax.naming.InitialContext();
			src = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			System.err.println("DBCP ¿¡·¯");
			e.printStackTrace();
		}
	}

	public OdDelvAddrDao() {
	}

	public java.sql.Connection getConnection() throws Exception {
		return src.getConnection();
	}

	public void regist(OdDelvAddrDto oddto) throws Exception{
		Connection con = getConnection();
		String sql = "insert into od_delv_addr values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,oddto.getOrders_id());
		ps.setString(2, oddto.getS_name());
		ps.setString(3, oddto.getR_name());
		ps.setString(4, oddto.getPhone());
		ps.setString(5, oddto.getZip_code());
		ps.setString(6, oddto.getBasic_addr());
		ps.setString(7, oddto.getDetail_addr());
		ps.setString(8, oddto.getDelv_msg());
		ps.execute();
		con.close();
	}
}
