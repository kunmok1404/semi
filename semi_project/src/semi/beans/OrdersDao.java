package semi.beans;

import java.sql.Connection;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class OrdersDao {
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
	
	
}
