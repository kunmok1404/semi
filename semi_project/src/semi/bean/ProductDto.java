package semi.bean;

import java.sql.ResultSet;

public class ProductDto {

	private int id;  //상품번호
	private String product_category_name;	// 상품카테고리명
	private int recipe_id;	// 레시피번호
	private int manufacture_id;		// 공급사번호
	private String name;		// 상품명
	private String title; 			// 상품요약정보
	private String content;		// 상품내용
	private String p_size;		// 용량/규격
	private String unit;		// 단위
	private int apply_price;		// 공급가
	private int origin_price;		// 기준판매가
	private int dis_rate;			// 할인율
	private int stock;		// 재고
	private String apply_status;	// 승인상태
	private String apply_date;	// 승인일자
	private String display_yn;	// 노출여부
	private String sale_status;	// 판매상태
	private int delv_corp_no;		// 배송업체번호
	private int bsc_delv_price;	// 기본배송비
	private String free_delv_yn;	// 무료배송여부
	private int free_delv_price;		// 무료배송기준가
	private String regist_date;		// 상품등록일
	private int sale_total;		// 총판매량
	private String sale_yn;	// 특가여부
	private String new_yn;	// 신상품여부
	
	public int getId() {
		return id;
	}
	
	public ProductDto(ResultSet rs) throws Exception {
		setId(rs.getInt("id"));
		setProduct_category_name(rs.getString("product_category_name"));
		setRecipe_id(rs.getInt("recipe_id"));
		setManufacture_id(rs.getInt("manufacture_id"));
		setName(rs.getString("name"));
		setTitle(rs.getString("title"));
		setContent(rs.getString("content"));
		setP_size(rs.getString("p_size"));
		setUnit(rs.getString("unit"));
		setApply_price(rs.getInt("apply_price"));
		setOrigin_price(rs.getInt("origin_price"));
		setDis_rate(rs.getInt("dis_rate"));
		setStock(rs.getInt("stock"));
		setApply_status(rs.getString("apply_status"));
		setApply_date(rs.getString("apply_date"));
		setDisplay_yn(rs.getString("display_yn"));
		setSale_status(rs.getString("sale_status"));
		setDelv_corp_no(rs.getInt("delv_corp_no"));
		setBsc_delv_price(rs.getInt("bsc_delv_price"));
		setFree_delv_yn(rs.getString("free_delv_price"));
		setFree_delv_price(rs.getInt("free_delv_price"));
		setRegist_date(rs.getString("regist_date"));
		setSale_total(rs.getInt("sale_total"));
		setSale_yn(rs.getString("sale_yn"));
		setNew_yn(rs.getString("new_yn"));
	}
	
	public ProductDto() {
		
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

	public void setId(int id) {
		this.id = id;
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
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public int getManufacture_id() {
		return manufacture_id;
	}
	public void setManufacture_id(int manufacture_id) {
		this.manufacture_id = manufacture_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getApply_status() {
		return apply_status;
	}
	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	public String getDisplay_yn() {
		return display_yn;
	}
	public void setDisplay_yn(String display_yn) {
		this.display_yn = display_yn;
	}
	public String getSale_status() {
		return sale_status;
	}
	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}
	public int getDelv_corp_no() {
		return delv_corp_no;
	}
	public void setDelv_corp_no(int delv_corp_no) {
		this.delv_corp_no = delv_corp_no;
	}
	public int getBsc_delv_price() {
		return bsc_delv_price;
	}
	public void setBsc_delv_price(int bsc_delv_price) {
		this.bsc_delv_price = bsc_delv_price;
	}
	public String getFree_delv_yn() {
		return free_delv_yn;
	}
	public void setFree_delv_yn(String free_delv_yn) {
		this.free_delv_yn = free_delv_yn;
	}
	public int getFree_delv_price() {
		return free_delv_price;
	}
	public void setFree_delv_price(int free_delv_price) {
		this.free_delv_price = free_delv_price;
	}
	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public int getSale_total() {
		return sale_total;
	}
	public void setSale_total(int sale_total) {
		this.sale_total = sale_total;
	}
	
	
	
}
