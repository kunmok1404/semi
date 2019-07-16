package semi.bean;

import java.sql.ResultSet;

public class ReviewListDto {
	private String p_name;
	private String c_name;
	private String o_date;
	private String pr_title;
	private String pr_date;
	private String o_m_id;
	private String pr_m_id;
	private int o_id;
	private int pr_id;

	public String getP_name() {
		return p_name;
	}

	

	public int getO_id() {
		return o_id;
	}



	public void setO_id(int o_id) {
		this.o_id = o_id;
	}



	public int getPr_id() {
		return pr_id;
	}



	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}



	@Override
	public String toString() {
		return "ReviewListDto [p_name=" + p_name + ", c_name=" + c_name + ", o_date=" + o_date + ", pr_title="
				+ pr_title + ", pr_date=" + pr_date + ", o_m_id=" + o_m_id + ", pr_m_id=" + pr_m_id + ", o_id=" + o_id
				+ ", pr_id=" + pr_id + "]";
	}

	public ReviewListDto() {
		super();
	}
	
	public ReviewListDto(ResultSet rs) throws Exception{
		setPr_id(rs.getInt("�ı��ȣ"));
		setO_id(rs.getInt("�ֹ���ȣ"));
		setC_name(rs.getString("ī�װ���"));
		setO_date(rs.getString("�ֹ���¥"));
		setO_m_id(rs.getString("�ֹ���"));
		setP_name(rs.getString("��ǰ��"));
		setPr_date(rs.getString("�ı��ۼ���"));
		setPr_m_id(rs.getString("�ı��ۼ���"));
		setPr_title(rs.getString("�ı�����"));
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getPr_title() {
		return pr_title;
	}

	public void setPr_title(String pr_title) {
		this.pr_title = pr_title;
	}

	public String getPr_date() {
		return pr_date;
	}

	public void setPr_date(String pr_date) {
		this.pr_date = pr_date;
	}

	public String getO_m_id() {
		return o_m_id;
	}

	public void setO_m_id(String o_m_id) {
		this.o_m_id = o_m_id;
	}

	public String getPr_m_id() {
		return pr_m_id;
	}

	public void setPr_m_id(String pr_m_id) {
		this.pr_m_id = pr_m_id;
	}
}
