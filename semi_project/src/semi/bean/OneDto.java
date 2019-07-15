package semi.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OneDto {
	private int no;
	private String head;
	private String writer;
	private String title;
	private String content;
	private String when;
	
	private int parent;
	private int depth;
	private int team;
	
	private String user;
	
	private int serviceNo;
	private String serviceWriter;
	private String serviceType;
	private String serviceTitle;
	private String serviceContent;
	private String answerStatus;
	private String answerContent;
	private String answerMen;
	private String answerRgDt;
	private String answerLtUpDt;
	private String registDate;
	private String updateDate;
	private int rn;
	
	
	
	public String getAnswerRgDt() {
		Date d = new Date();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
//		getDate() : 게시글 날짜, f.format(d) : 오늘 날짜
		if(answerRgDt == null) {
			return "";
		}else {
			if(getSubDate(answerRgDt).equals(f.format(d))) 
				return this.getSubDate(answerRgDt);
			else 
				return this.getSubDate(answerRgDt);
		}
	}
	public void setAnswerRgDt(String answerRgDt) {
		this.answerRgDt = answerRgDt;
	}
	
	public String getSubDate(String subDate) {
		return subDate.toString().substring(0, 10);
	}
	public String getSubTime(String subTime) {
		return subTime.toString().substring(11, 16);
	}
	public String getAnswerLtUpDt() {
		return answerLtUpDt;
	}
	public void setAnswerLtUpDt(String answerLtUpDt) {
		this.answerLtUpDt = answerLtUpDt;
	}
	
	
	public String getRegistDate() {
		Date d = new Date();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
//		getDate() : 게시글 날짜, f.format(d) : 오늘 날짜
		if(getSubDate(registDate).equals(f.format(d))) 
			return this.getSubTime(registDate);
		else 
			return this.getSubDate(registDate);
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	
	
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public String getServiceContent() {
		return serviceContent;
	}
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}
	public String getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerMen() {
		return answerMen;
	}
	public void setAnswerMen(String answerMen) {
		this.answerMen = answerMen;
	}
	


	public String getServiceWriter() {
		return serviceWriter;
	}
	public void setServiceWriter(String serviceWriter) {
		this.serviceWriter = serviceWriter;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}

	private int read;
	@Override
	public String toString() {
		return "OneDto [no=" + no + ", head=" + head + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", when=" + when + ", read=" + read + "]";
	}
	public OneDto() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWhen() {
		return when;
	}
	
//	날짜만 반환하는 메소드	getDate()
//	시간만 반환하는 메소드	getTime()
	

//	오늘인지 아닌지 판정하여 자동 시간 반환
	/*
	 * public String getAuto() { Date d = new Date(); Format f = new
	 * SimpleDateFormat("yyyy-MM-dd"); // getDate() : 게시글 날짜, f.format(d) : 오늘 날짜
	 * if(getDate().equals(f.format(d))) return this.getTime(); else return
	 * this.getDate(); }
	 */

	public void setWhen(String when) {
		this.when = when;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	
	public void setData(ResultSet rs) throws SQLException{
		
		this.setServiceNo(rs.getInt("Service_No"));
		this.setServiceWriter(rs.getString("Service_Writer"));
		this.setServiceType(rs.getString("Service_Type"));
		this.setServiceTitle(rs.getString("Service_Title"));
		this.setServiceContent(rs.getString("Service_Content"));
		this.setAnswerStatus(rs.getString("Answer_Status"));
		this.setAnswerContent(rs.getString("Answer_Content"));
		this.setAnswerMen(rs.getString("Answer_Men"));
		 this.setAnswerRgDt(rs.getString("Answer_Rg_Dt")); 
		 this.setAnswerLtUpDt(rs.getString("Answer_Lt_Up_Dt")); 
		 this.setRegistDate(rs.getString("Regist_Date"));
		 this.setUpdateDate(rs.getString("Update_Date"));
		 this.setRn(rs.getInt("rn"));
		
	}
}










