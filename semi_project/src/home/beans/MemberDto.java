package home.beans;

public class MemberDto {
	private int no;						//회원번호
	private String id;			//이메일
	private String pw;				//비밀번호
	private String name;			//이름
	private String birth;			//생년월일
	private String phone;			//전화번호
	private String question;		//확인질문
	private String answer;		//확인답변
	private String regist;			//가입일시
	private String grade;				//권한
	private String recent;			//최종 접속일시
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRegist() {
		return regist;
	}
	public void setRegist(String regist) {
		this.regist = regist;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRecent() {
		return recent;
	}
	public void setRecent(String recent) {
		this.recent = recent;
	}
	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth
				+ ", phone=" + phone + ", question=" + question + ", answer=" + answer + ", regist=" + regist
				+ ", grade=" + grade + ", recent=" + recent + "]";
	}
	public MemberDto() {
		super();
	}
}
