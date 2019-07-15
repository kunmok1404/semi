package semi.bean;

import java.sql.ResultSet;

public class ProductImgDto {
	private int id; // 이미지 번호
	private int product_id;	// 상품번호
	private String main_yn;	// 메인 이미지여부
	private String list_yn; // 목록이미지 여부
	private int sort_seq;	// 정렬순서
	private String upload_name;	// 업로드이름
	private String save_name;	// 저장이름
	private String type;	// 파일 타입
	private long file_size;	// 파일 크기
	
	public ProductImgDto() {}
	
	public ProductImgDto(ResultSet rs) throws Exception{
		setId(rs.getInt("id"));
		setProduct_id(rs.getInt("product_id"));
		setMain_yn(rs.getString("main_yn"));
		setList_yn(rs.getString("list_yn"));
		setSort_seq(rs.getInt("sort_seq"));
		setUpload_name(rs.getString("upload_name"));
		setSave_name(rs.getString("save_name"));
		setType(rs.getString("type"));
		setFile_size(rs.getLong("file_size"));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getMain_yn() {
		return main_yn;
	}
	public void setMain_yn(String main_yn) {
		this.main_yn = main_yn;
	}
	public String getList_yn() {
		return list_yn;
	}
	public void setList_yn(String list_yn) {
		this.list_yn = list_yn;
	}
	public int getSort_seq() {
		return sort_seq;
	}
	public void setSort_seq(int sort_seq) {
		this.sort_seq = sort_seq;
	}
	public String getUpload_name() {
		return upload_name;
	}
	public void setUpload_name(String upload_name) {
		this.upload_name = upload_name;
	}
	public String getSave_name() {
		return save_name;
	}
	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "ProductImgDto [id=" + id + ", product_id=" + product_id + ", main_yn=" + main_yn + ", list_yn="
				+ list_yn + ", sort_seq=" + sort_seq + ", upload_name=" + upload_name + ", save_name=" + save_name
				+ ", type=" + type + ", file_size=" + file_size + "]";
	}
	
}
