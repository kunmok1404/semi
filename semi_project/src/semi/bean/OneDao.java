package semi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class OneDao {

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
	public List<OneDto> list(String user, String grade, int start, int end) throws Exception{
		Connection con = getConnection();

		String sql = "";
		
		if("������".equals(grade)) {
			sql = "select * from ("
					+ "select rownum rn, A.* from ("
						//������ SQL ���
						+ "select * from Service1"
						+ "  "
					+ ") A"
				+ ") where rn between ? and ? order by rn desc";
		}else {
			sql = "select * from ("
					+ "select rownum rn, A.* from ("
						//������ SQL ���
						+ "select * from Service1"
						+ " where "
						+ " 1=1 "
						+ " and Service_Writer = ?"
						+ "  "
					+ ") A"
				+ ") where rn between ? and ? order by rn desc";
		}
		
		PreparedStatement ps = con.prepareStatement(sql);
		if("������".equals(grade)) {
			ps.setInt(1, start);
			ps.setInt(2, end);
		}else {
			ps.setString(1, user);
			ps.setInt(2, start);
			ps.setInt(3, end);
		}
		ResultSet rs = ps.executeQuery();
		
		List<OneDto> list = new ArrayList<>();
		
		while(rs.next()) {
			OneDto bdto = new OneDto();
			//���� ���� �����͸� bdto�� ����
			bdto.setData(rs);
			list.add(bdto);
		}
		
		con.close();
		return list;
	}
	
//	�׸� ����
	public OneDto get(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "select rownum rn, a.* from Service1 a where Service_No=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		
		OneDto bdto;
		if(rs.next()) {
			bdto = new OneDto();
			bdto.setData(rs);
		}
		else {
			bdto = null;
		}
		
		con.close();
		return bdto;
	}

//	��� : ���� ����ְ� ��ȣ ��ȯ
	public int write(OneDto odto) throws Exception{
		Connection con = getConnection();
		
//		[1] ���� �� �Խñ��� ��ȣ�� ���� ���Ѵ�
		String sql = "select Service_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();//���� �����ͷ� �̵�(������ 1��)
		int no = rs.getInt("nextval");
		ps.close();
		

		
//		[3] 1������ ���� ��ȣ�� �̿��Ͽ� �Խñ��� �߰��Ѵ�
		sql = "insert into Service1(Service_No, Service_Type, Service_Title,Service_Writer,Service_Content,Answer_Status,Regist_Date) values("
				+ "?, ?, ?, ?, ?,'NO',sysdate "
			+ ")";
		ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setString(2, odto.getHead());
		ps.setString(3, odto.getTitle());
		ps.setString(4, odto.getWriter());
		ps.setString(5, odto.getContent());
		ps.execute();
		
		con.close();
		return no;
	}
	
//	��ȸ�� ���� �޼ҵ�
	public void read(int no) throws Exception{
		/*
		 * Connection con = getConnection();
		 * 
		 * String sql = "update Service1 set read = read + 1 where no = ?";
		 * PreparedStatement ps = con.prepareStatement(sql); ps.setInt(1, no);
		 * ps.execute();
		 * 
		 * con.close();
		 */
	}

//	�� ����
	public void delete(int no) throws Exception{
		Connection con = getConnection();
		
		String sql = "delete Service1 where SERVICE_NO=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
	}

//	�ڸ�Ʈ ����
	public void editComment(OneDto bdto) throws Exception{
		Connection con = getConnection();
		
		String sql = "update Service1 "
									+ "set Answer_Status='Yes', Answer_Content=?, Answer_Men=? ,Answer_Rg_Dt=sysdate,Answer_Lt_Up_Dt=sysdate "
									+ "where SERVICE_NO=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bdto.getServiceContent());
		ps.setString(2, bdto.getServiceWriter());
		ps.setInt(3, bdto.getServiceNo());
		ps.execute();
		
		con.close();
	}
	
//	�˻� �޼ҵ�
//	type=writer �̰ų� type=title+content �̰ų� �� �� �ϳ�
//	type=title+content��� +�� ||�� �ٲ㼭 ó��
//	select * from board where writer like ? order by when desc
//	select * from board where title like ? or content like ? order by..
//	select * from board where title || content like ? order by ...
	
	public List<OneDto> search(
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
		
		List<OneDto> list = new ArrayList<>();
		
		while(rs.next()) {
			OneDto bdto = new OneDto();
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
		
		
		String sql = "select count(*) from Service1";
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









