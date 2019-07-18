package semi.bean;

import java.sql.ResultSet;

public class MemberPointDto {
	private String id;	// ȸ�� ���̵�
	private int no; 	// ȸ�� ��ȣ
	private String name; // ȸ���̸�
	private String pwd; // ��й�ȣ
	private String pwd_dt; // ��й�ȣ ���泯¥
	private String status;	// ȸ�� ����
	private String grade; 	// ȸ�� ���
	private String birth;	// ����
	private String phone; // ��ȭ��ȣ
	private String email; // �̸���
	private String zip_code; // ���ڵ�
	private String basic_addr; // �⺻�ּ�
	private String detail_addr; //���ּ�
	private String join_date; // ������
	private String order_date; // �ֹ���
	private String login_date; // ����������
	private String question; // ����
	private String answer; // �亯
	// ����Ʈ
	private String member_id; // ȸ����ȣ
	private int orders_id; // �ֹ���ȣ
	private String use_type; // ����Ʈ��뱸��
	private int point; // ����Ʈ
	private String use_date; // ��볯¥
	private int current_point; // ���� ����Ʈ
	private String reason; // ����
	
	public MemberPointDto() {}
	
	public MemberPointDto(ResultSet rs) throws Exception{
		setId(rs.getString("id"));
		setNo(rs.getInt("no"));
		setName(rs.getString("name"));
		setPwd(rs.getString("pwd"));
		setPwd_dt(rs.getString("pwd_dt"));
		setStatus(rs.getString("status"));
		setGrade(rs.getString("grade"));
		setBirth(rs.getString("birth"));
		setPhone(rs.getString("phone"));
		setEmail(rs.getString("email"));
		setZip_code(rs.getString("zip_code"));
		setBasic_addr(rs.getString("basic_addr"));
		setDetail_addr(rs.getString("detail_addr"));
		setJoin_date(rs.getString("join_date"));
		setOrder_date(rs.getString("order_date"));
		setLogin_date(rs.getString("login_date"));
		setAnswer(rs.getString("answer"));
		setQuestion(rs.getString("question"));
		setMember_id(rs.getString("member_id"));
		setUse_type(rs.getString("use_type"));
		setPoint(rs.getInt("point"));
		setUse_date(rs.getString("use_date"));
		setCurrent_point(rs.getInt("current_point"));
		setReason(rs.getString("reason"));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd_dt() {
		return pwd_dt;
	}
	public void setPwd_dt(String pwd_dt) {
		this.pwd_dt = pwd_dt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public String getUse_type() {
		return use_type;
	}
	public void setUse_type(String use_type) {
		this.use_type = use_type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getUse_date() {
		return use_date;
	}
	public void setUse_date(String use_date) {
		this.use_date = use_date;
	}
	public int getCurrent_point() {
		return current_point;
	}
	public void setCurrent_point(int current_point) {
		this.current_point = current_point;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "MemberPointDto [id=" + id + ", no=" + no + ", name=" + name + ", pwd=" + pwd + ", pwd_dt=" + pwd_dt
				+ ", status=" + status + ", grade=" + grade + ", birth=" + birth + ", phone=" + phone + ", email="
				+ email + ", zip_code=" + zip_code + ", basic_addr=" + basic_addr + ", detail_addr=" + detail_addr
				+ ", join_date=" + join_date + ", order_date=" + order_date + ", login_date=" + login_date
				+ ", question=" + question + ", answer=" + answer + ", member_id=" + member_id + ", orders_id="
				+ orders_id + ", use_type=" + use_type + ", point=" + point + ", use_date=" + use_date
				+ ", current_point=" + current_point + ", reason=" + reason + "]";
	}
	
}
