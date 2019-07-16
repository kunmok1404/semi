package semi.bean;

import java.sql.ResultSet;

public class OrdersDto {
	private int id;
	private String member_id;
	private int cart_id;
	private int product_id;
	private String status_cd;
	private String order_date;
	private String pay_type_cd;
	private String pay_status_cd;
	private String od_cancel_cd;
	private String od_cancel_com_cd;
	private int price;
	private int delv_price;
	private int dis_price;
	private int payback_rate;
	private int field;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getStatus_cd() {
		return status_cd;
	}
	public void setStatus_cd(String status_cd) {
		this.status_cd = status_cd;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getPay_type_cd() {
		return pay_type_cd;
	}
	public void setPay_type_cd(String pay_type_cd) {
		this.pay_type_cd = pay_type_cd;
	}
	public String getPay_status_cd() {
		return pay_status_cd;
	}
	public void setPay_status_cd(String pay_status_cd) {
		this.pay_status_cd = pay_status_cd;
	}
	public String getOd_cancel_cd() {
		return od_cancel_cd;
	}
	public void setOd_cancel_cd(String od_cancel_cd) {
		this.od_cancel_cd = od_cancel_cd;
	}
	public String getOd_cancel_com_cd() {
		return od_cancel_com_cd;
	}
	public void setOd_cancel_com_cd(String od_cancel_com_cd) {
		this.od_cancel_com_cd = od_cancel_com_cd;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDelv_price() {
		return delv_price;
	}
	public void setDelv_price(int delv_price) {
		this.delv_price = delv_price;
	}
	public int getDis_price() {
		return dis_price;
	}
	public void setDis_price(int dis_price) {
		this.dis_price = dis_price;
	}
	public int getPayback_rate() {
		return payback_rate;
	}
	public void setPayback_rate(int payback_rate) {
		this.payback_rate = payback_rate;
	}
	public int getField() {
		return field;
	}
	public void setField(int field) {
		this.field = field;
	}
	public OrdersDto() {
		super();
	}
	@Override
	public String toString() {
		return "OrdersDto [id=" + id + ", member_id=" + member_id + ", cart_id=" + cart_id + ", product_id="
				+ product_id + ", status_cd=" + status_cd + ", order_date=" + order_date + ", pay_type_cd="
				+ pay_type_cd + ", pay_status_cd=" + pay_status_cd + ", od_cancel_cd=" + od_cancel_cd
				+ ", od_cancel_com_cd=" + od_cancel_com_cd + ", price=" + price + ", delv_price=" + delv_price
				+ ", dis_price=" + dis_price + ", payback_rate=" + payback_rate + ", field=" + field + "]";
	}
	public void setData(ResultSet rs)throws Exception{
		setId(rs.getInt("id"));
		setMember_id(rs.getString("member_id"));
		setCart_id(rs.getInt("cart_id"));
		setProduct_id(rs.getInt("product_id"));
		setStatus_cd(rs.getString("status_cd"));
		setOrder_date(rs.getString("order_date"));
		setPay_type_cd(rs.getString("pay_type_cd"));
		setPay_status_cd(rs.getString("pay_status_cd"));
		setOd_cancel_cd(rs.getString("od_cancel_cd"));
		setOd_cancel_com_cd(rs.getString("od_cancel_com_cd"));
		setPrice(rs.getInt("price"));
		setDelv_price(rs.getInt("delv_price"));
		setDis_price(rs.getInt("dis_price"));		
		setPayback_rate(rs.getInt("payback_rate"));
		setField(rs.getInt("field"));
	}
	
}
