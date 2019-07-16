package semi.bean;

import java.sql.ResultSet;

public class CartDto {
	private int cart_no;			//��ٱ��Ϲ�ȣ
	private String login_id;		//���̵�
	private int prd_no;				//��ǰ��ȣ
	private int prd_qty;			//����
	
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public int getPrd_qty() {
		return prd_qty;
	}
	public void setPrd_qty(int prd_qty) {
		this.prd_qty = prd_qty;
	}
	public CartDto() {
		super();
	}
	@Override
	public String toString() {
		return "CartDto [cart_no=" + cart_no + ", login_id=" + login_id + ", prd_no=" + prd_no + ", prd_qty=" + prd_qty
				+ "]";
	}
	public void setData(ResultSet rs) throws Exception{
		setCart_no(rs.getInt("cart_no"));			//��ٱ��Ϲ�ȣ
		setLogin_id(rs.getString("login_id"));		//���̵�
		setPrd_no(rs.getInt("prd_no"));				//��ǰ��ȣ
		setPrd_qty(rs.getInt("prd_qty"));	
	}
	
//	public void setData(ResultSet rs) {
//		
//	}
	
}
