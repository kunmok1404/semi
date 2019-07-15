package semi.bean;

import java.sql.ResultSet;

public class CommentsDto {
	private int id;
	private String memberId;
	private String content;
	private String when;
	private int reviewId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public CommentsDto() {
		super();
	}

	public CommentsDto(ResultSet rs) throws Exception{
		setId(rs.getInt("id"));
		setMemberId(rs.getString("member_id"));
		setContent(rs.getString("content"));
		setWhen(rs.getString("when"));
		setReviewId(rs.getInt("review_id"));
	}

	@Override
	public String toString() {
		return "CommetsDto [id=" + id + ", memberId=" + memberId + ", content=" + content + ", when=" + when
				+ ", reviewId=" + reviewId + "]";
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public void setWhen(String when) {
		this.when = when;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

}
