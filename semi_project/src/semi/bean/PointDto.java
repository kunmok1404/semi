package semi.bean;

import java.sql.ResultSet;

public class PointDto {
	private String memberId;
	private int ordersId;
	private String useType;
	private int point;
	private String useDate;
	private int currentPoint;
	private String reason;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int curretPoint) {
		this.currentPoint = curretPoint;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "PointDto [memberId=" + memberId + ", ordersId=" + ordersId + ", useType=" + useType + ", point=" + point
				+ ", useDate=" + useDate + ", curretPoint=" + currentPoint + ", reason=" + reason + "]";
	}

	public PointDto() {
	}
	
	public PointDto(ResultSet rs) throws Exception{
		setMemberId(rs.getString("member_id"));
		setOrdersId(rs.getInt("orders_id"));
		setUseType(rs.getString("use_type"));
		setPoint(rs.getInt("point"));
		setUseDate(rs.getString("use_date"));
		setCurrentPoint(rs.getInt("current_point"));
		setReason(rs.getString("reason"));
	}
}