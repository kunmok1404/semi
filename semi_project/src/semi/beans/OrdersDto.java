package semi.beans;

public class OrdersDto {
	private int od_no;							//�ֹ���ȣ
	private String login_Id;					//���̵�
	private int cart_no;						//��ٱ��Ϲ�ȣ
	private int prd_no;							//��ǰ��ȣ
	private String od_st_cd;					//�ֹ������ڵ�
	private String od_dt;						//�ֹ��Ͻ�
	private String pay_tp_cd;				//���������ڵ�
	private String pay_st_cd;				//���������ڵ�
	private String od_cnc_dt;				//�ֹ�����Ͻ�
	private String od_cnc_comp_dt;		//�ֹ���ҿϷ��Ͻ�
	private int od_price;						//�ֹ��ݾ�
	private int delv_price;					//��ۺ�
	private int dis_price;						//���αݾ�
	private int payback_rate;				//����������
	private int field;								//�ֹ���ȣ�׷�
	
	public int getOd_no() {
		return od_no;
	}
	public void setOd_no(int od_no) {
		this.od_no = od_no;
	}
	public String getLogin_Id() {
		return login_Id;
	}
	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public String getOd_st_cd() {
		return od_st_cd;
	}
	public void setOd_st_cd(String od_st_cd) {
		this.od_st_cd = od_st_cd;
	}
	public String getOd_dt() {
		return od_dt;
	}
	public void setOd_dt(String od_dt) {
		this.od_dt = od_dt;
	}
	public String getPay_tp_cd() {
		return pay_tp_cd;
	}
	public void setPay_tp_cd(String pay_tp_cd) {
		this.pay_tp_cd = pay_tp_cd;
	}
	public String getPay_st_cd() {
		return pay_st_cd;
	}
	public void setPay_st_cd(String pay_st_cd) {
		this.pay_st_cd = pay_st_cd;
	}
	public String getOd_cnc_dt() {
		return od_cnc_dt;
	}
	public void setOd_cnc_dt(String od_cnc_dt) {
		this.od_cnc_dt = od_cnc_dt;
	}
	public String getOd_cnc_comp_dt() {
		return od_cnc_comp_dt;
	}
	public void setOd_cnc_comp_dt(String od_cnc_comp_dt) {
		this.od_cnc_comp_dt = od_cnc_comp_dt;
	}
	public int getOd_price() {
		return od_price;
	}
	public void setOd_price(int od_price) {
		this.od_price = od_price;
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
		return "OrdersDto [od_no=" + od_no + ", login_Id=" + login_Id + ", cart_no=" + cart_no + ", prd_no=" + prd_no
				+ ", od_st_cd=" + od_st_cd + ", od_dt=" + od_dt + ", pay_tp_cd=" + pay_tp_cd + ", pay_st_cd="
				+ pay_st_cd + ", od_cnc_dt=" + od_cnc_dt + ", od_cnc_comp_dt=" + od_cnc_comp_dt + ", od_price="
				+ od_price + ", delv_price=" + delv_price + ", dis_price=" + dis_price + ", payback_rate="
				+ payback_rate + ", field=" + field + "]";
	}
	
}
