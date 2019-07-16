package semi.bean;

import java.sql.ResultSet;

public class OdDelvAddrDto {
	private int orders_id;
	private String s_name;
	private String r_name;
	private String phone;
	private String zip_code;
	private String basic_addr;
	private String detail_addr;
	private String delv_msg;
	
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getBasic_addr() {
		return basic_addr;
	}
	public void setBasic_addr(String basic_addr) {
		this.basic_addr = basic_addr;
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	public String getDelv_msg() {
		return delv_msg;
	}
	public void setDelv_msg(String delv_msg) {
		this.delv_msg = delv_msg;
	}
	public OdDelvAddrDto() {
		super();
	}
	@Override
	public String toString() {
		return "OdDelvAddrDto [orders_id=" + orders_id + ", s_name=" + s_name + ", r_name=" + r_name + ", phone="
				+ phone + ", zip_code=" + zip_code + ", basic_addr=" + basic_addr + ", detail_addr=" + detail_addr
				+ ", delv_msg=" + delv_msg + "]";
	}
	
	public void setData(ResultSet rs) throws Exception{
		setOrders_id(rs.getInt("orders_id"));
		setS_name(rs.getString("s_name"));
		setR_name(rs.getString("r_name"));
		setPhone(rs.getString("phone"));
		setZip_code(rs.getString("zip_code"));
		setBasic_addr(rs.getString("basic_addr"));
		setDetail_addr(rs.getString("detail_addr"));
		setDelv_msg(rs.getString("delv_msg"));
	}
}
