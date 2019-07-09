package semi.beans;

public class OdDelvAddrDto {
	private int od_no;							//주문번호
	private String sender_nm;				//발송자명
	private String recieve_nm;				//수취인명
	private String phone;						//전화번호
	private String zip_code;					//우편번호
	private String road_bsc_addr;		//도로명기본주소
	private String road_detail_addr;		//도로명상세주소
	private String delv_msg;					//배송메시지
	
	public int getOd_no() {
		return od_no;
	}
	public void setOd_no(int od_no) {
		this.od_no = od_no;
	}
	public String getSender_nm() {
		return sender_nm;
	}
	public void setSender_nm(String sender_nm) {
		this.sender_nm = sender_nm;
	}
	public String getRecieve_nm() {
		return recieve_nm;
	}
	public void setRecieve_nm(String recieve_nm) {
		this.recieve_nm = recieve_nm;
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
	public String getRoad_bsc_addr() {
		return road_bsc_addr;
	}
	public void setRoad_bsc_addr(String road_bsc_addr) {
		this.road_bsc_addr = road_bsc_addr;
	}
	public String getRoad_detail_addr() {
		return road_detail_addr;
	}
	public void setRoad_detail_addr(String road_detail_addr) {
		this.road_detail_addr = road_detail_addr;
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
		return "OdDelvAddrDto [od_no=" + od_no + ", sender_nm=" + sender_nm + ", recieve_nm=" + recieve_nm + ", phone="
				+ phone + ", zip_code=" + zip_code + ", road_bsc_addr=" + road_bsc_addr + ", road_detail_addr="
				+ road_detail_addr + ", delv_msg=" + delv_msg + "]";
	}
	
}
