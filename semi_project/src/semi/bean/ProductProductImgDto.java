package semi.bean;

import java.sql.ResultSet;

public class ProductProductImgDto {
	private int p_id;	// 상품번호
	private String p_name;	  // 상품명
	private String product_category_name; //상품카테고리명
	private String title;	// 상품요약정보
	private String content; // 상품내용
	private String p_size;	// 규격,용량
	private String unit;	// 단위
	private int apply_price;	// 공급가
	private int origin_price;	// 기준판매가
	private int dis_rate;		// 할인율
	private int bsc_delv_price;	// 기본배송비
	private int stock;	// 재고
	private String sale_yn;	// 특가여부
	private String new_yn;	// 신상품여부
	private int i_id;	// 이미지 번호
	private String main_yn;	// 메인이미지 여부
	private String list_yn;	// 목록 이미지 여부
	private int sort_seq;	// 정렬순서
	private String upload_name;	// 업로드이름
	private String save_name;	// 저장이름
	private String type;	// 타입
	private int file_size;	// 파일크기
	
	public ProductProductImgDto() {}
	
	public ProductProductImgDto(ResultSet rs) throws Exception{
		setP_id(rs.getInt("p_id"));
		setP_name(rs.getString("p_name"));
		setI_id(rs.getInt("i_id"));
		setMain_yn(rs.getString("main_yn"));
		setList_yn(rs.getString("list_yn"));
		setSort_seq(rs.getInt("sort_seq"));
		setUpload_name(rs.getString("upload_name"));
		setSave_name(rs.getString("save_name"));
		setType(rs.getString("type"));
		setFile_size(rs.getInt("file_size"));
		setProduct_category_name(rs.getString("product_category_name"));
		setTitle(rs.getString("title"));
		setContent(rs.getString("content"));
		setP_size(rs.getString("p_size"));
		setUnit(rs.getString("unit"));
		setApply_price(rs.getInt("apply_price"));
		setOrigin_price(rs.getInt("origin_price"));
		setDis_rate(rs.getInt("dis_rate"));
		setBsc_delv_price(rs.getInt("bsc_delv_price"));
		setStock(rs.getInt("stock"));
		setSale_yn(rs.getString("sale_yn"));
		setNew_yn(rs.getString("new_yn"));
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
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
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public String getProduct_category_name() {
		return product_category_name;
	}

	public void setProduct_category_name(String product_category_name) {
		this.product_category_name = product_category_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getApply_price() {
		return apply_price;
	}

	public void setApply_price(int apply_price) {
		this.apply_price = apply_price;
	}

	public int getOrigin_price() {
		return origin_price;
	}

	public void setOrigin_price(int origin_price) {
		this.origin_price = origin_price;
	}

	public int getDis_rate() {
		return dis_rate;
	}

	public void setDis_rate(int dis_rate) {
		this.dis_rate = dis_rate;
	}

	public int getBsc_delv_price() {
		return bsc_delv_price;
	}

	public void setBsc_delv_price(int bsc_delv_price) {
		this.bsc_delv_price = bsc_delv_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSale_yn() {
		return sale_yn;
	}

	public void setSale_yn(String sale_yn) {
		this.sale_yn = sale_yn;
	}

	public String getNew_yn() {
		return new_yn;
	}

	public void setNew_yn(String new_yn) {
		this.new_yn = new_yn;
	}

	@Override
	public String toString() {
		return "ProductProductImgDto [p_id=" + p_id + ", p_name=" + p_name + ", product_category_name="
				+ product_category_name + ", title=" + title + ", p_size=" + p_size + ", unit=" + unit
				+ ", apply_price=" + apply_price + ", origin_price=" + origin_price + ", dis_rate=" + dis_rate
				+ ", bsc_delv_price=" + bsc_delv_price + ", stock=" + stock + ", sale_yn=" + sale_yn + ", new_yn="
				+ new_yn + ", i_id=" + i_id + ", main_yn=" + main_yn + ", list_yn=" + list_yn + ", sort_seq=" + sort_seq
				+ ", upload_name=" + upload_name + ", save_name=" + save_name + ", type=" + type + ", file_size="
				+ file_size + "]";
	}
	
}
