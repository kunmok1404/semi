package semi.bean;

import java.sql.ResultSet;

public class ProductCatDto {
	private int id;
	private String name;
	private String yn;
	private int sort_seq;
	
	public ProductCatDto() {
		
	}
	
	public ProductCatDto(ResultSet rs)throws Exception{
		setId(rs.getInt("id"));
		setName(rs.getString("name"));
		setYn(rs.getString("yn"));
		setSort_seq(rs.getInt("sort_seq"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYn() {
		return yn;
	}

	public void setYn(String yn) {
		this.yn = yn;
	}

	public int getSort_seq() {
		return sort_seq;
	}

	public void setSort_seq(int sort_seq) {
		this.sort_seq = sort_seq;
	}

	@Override
	public String toString() {
		return "ProductCatDto [id=" + id + ", name=" + name + ", yn=" + yn + ", sort_seq=" + sort_seq + "]";
	}
	
}
