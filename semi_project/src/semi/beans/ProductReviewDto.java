package semi.beans;

import java.sql.ResultSet;

public class ProductReviewDto {
	private int productId;
	private int memberId;
	private String title;
	private String content;
	private int grade;
	private String dateCreated;
	private String dateUpdate;

	@Override
	public String toString() {
		return "ProductViewDto [productId=" + productId + ", memberId=" + memberId + ", title=" + title + ", content="
				+ content + ", grade=" + grade + ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate + "]";
	}

	public ProductReviewDto() {
		
	}
	
	public ProductReviewDto(ResultSet rs) throws Exception{
		setProductId(rs.getInt("product_id"));
		setMemberId(rs.getInt("member_id"));
		setTitle(rs.getString("title"));
		setContent(rs.getString("content"));
		setGrade(rs.getInt("grade"));
		setDateCreated(rs.getString("date_created"));
		setDateUpdate(rs.getString("date_update"));
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
}
