package semi.bean;

import java.sql.ResultSet;

// 공급사Dto
public class MnftDto {
	private int id; //업체번호
	private String name; // 업체명
	private String type; // 업종
	private String business_no;	// 사업자번호
	private String ceo_name;	// 대표자명
	private String ceo_phone;	//대표자 전화번호
	private String manager_name;	//담당자명
	private String manager_phone;	//담당자 전화번호
	private String contract_date;	// 계약일
	private String con_finish_date;	// 계약 종료일
	private String apply_status;	// 승인상태
	private String contract_status;	// 계약 상태
	
	public MnftDto() {
		
	}
	
	public MnftDto(ResultSet rs)throws Exception{
		setId(rs.getInt("id"));
		setName(rs.getString("name"));
		setType(rs.getString("type"));
		setBusiness_no(rs.getString("business_no"));
		setCeo_name(rs.getString("ceo_name"));
		setCeo_phone(rs.getString("ceo_phone"));
		setManager_name(rs.getString("manager_name"));
		setManager_phone(rs.getString("manager_phone"));
		setContract_date(rs.getString("contract_date"));
		setCon_finish_date(rs.getString("con_finish_date"));
		setApply_status(rs.getString("apply_status"));
		setContract_status(rs.getString("contract_status"));
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBusiness_no() {
		return business_no;
	}
	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}
	public String getCeo_name() {
		return ceo_name;
	}
	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}
	public String getCeo_phone() {
		return ceo_phone;
	}
	public void setCeo_phone(String ceo_phone) {
		this.ceo_phone = ceo_phone;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_phone() {
		return manager_phone;
	}
	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	public String getContract_date() {
		return contract_date;
	}
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	public String getCon_finish_date() {
		return con_finish_date;
	}
	public void setCon_finish_date(String con_finish_date) {
		this.con_finish_date = con_finish_date;
	}
	public String getApply_status() {
		return apply_status;
	}
	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}
	public String getContract_status() {
		return contract_status;
	}
	public void setContract_status(String contract_status) {
		this.contract_status = contract_status;
	}

	@Override
	public String toString() {
		return "MnftDto [id=" + id + ", name=" + name + ", type=" + type + ", business_no=" + business_no
				+ ", ceo_name=" + ceo_name + ", ceo_phone=" + ceo_phone + ", manager_name=" + manager_name
				+ ", manager_phone=" + manager_phone + ", contract_date=" + contract_date + ", con_finish_date="
				+ con_finish_date + ", apply_status=" + apply_status + ", contract_status=" + contract_status + "]";
	}
	
}
