package semi.beans;

import java.sql.ResultSet;

public class MemberDto {
	private String id;
	private String name;
	private String pwd;
	private String pwdDt;
	private String status;
	private String grade;
	private String birth;
	private String phone;
	private String email;
	private String zipCode;
	private String basicAddr;
	private String detailAddr;
	private String joinDate;
	private String orderDate;
	private String loginDate;
	private String question;
	private String answer;
	private String reason;

	public MemberDto() {
		super();
	}

	public MemberDto(ResultSet rs) throws Exception {
		setId(rs.getString("id"));
		setName(rs.getString("name"));
		setPwd(rs.getString("pwd"));
		setPwdDt(rs.getString("pwd_dt"));
		setStatus(rs.getString("status"));
		setGrade(rs.getString("grade"));
		setBirth(rs.getString("birth"));
		setPhone(rs.getString("phone"));
		setEmail(rs.getString("email"));
		setZipCode(rs.getString("zip_code"));
		setBasicAddr(rs.getString("basic_addr"));
		setDetailAddr(rs.getString("detail_addr"));
		setJoinDate(rs.getString("join_date"));
		setOrderDate(rs.getString("order_date"));
		setLoginDate(rs.getString("login_date"));
		setQuestion(rs.getString("question"));
		setAnswer(rs.getString("answer"));
		setReason(rs.getString("reason"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPwdDt() {
		return pwdDt;
	}

	public void setPwdDt(String pwdDt) {
		this.pwdDt = pwdDt;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBasicAddr() {
		return basicAddr;
	}

	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", pwd=" + pwd + ", pwdDt=" + pwdDt + ", status=" + status
				+ ", grade=" + grade + ", birth=" + birth + ", phone=" + phone + ", email=" + email + ", zipCode="
				+ zipCode + ", basicAddr=" + basicAddr + ", detailAddr=" + detailAddr + ", joinDate=" + joinDate
				+ ", orderDate=" + orderDate + ", loginDate=" + loginDate + ", question=" + question + ", answer="
				+ answer + ", reason=" + reason + "]";
	}
}
