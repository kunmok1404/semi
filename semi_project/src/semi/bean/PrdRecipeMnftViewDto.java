package semi.bean;

import java.sql.ResultSet;

// 상품(product) + 레시피(recipe) + 공급사(manufacture)뷰어 Dto
public class PrdRecipeMnftViewDto {

	private String p_name; // 상품명
	private int p_id; 			// 상품번호
	private String product_category_name; // 카테고리명
	private String p_title;	// 상품요약
	private String p_content;	// 상품내용
	private String p_size;		// 용량/규격
	private String unit; 		// 단위
	private int apply_price;		// 공급가
	private int origin_price;		// 기준판매가
	private int dis_rate;				// 할인율
	private int stock;			// 재고
	private String apply_status; // 승인상태
	private String apply_date;	// 승인일자
	private String display_yn; 	// 노출여부
	private String sale_status;	// 판매상태
	private int delv_corp_no; 	// 배송업체번호
	private int bsc_delv_price;	// 기본배송비
	private String free_delv_yn; // 무료배송여부
	private int free_delv_price; // 무료배송기준가
	private String regist_date; // 상품등록일
	private int sale_total; 			// 총판매량
	private String sale_yn; // 특가여부
	private String new_yn;	// 신상품여부
	private String m_name; 	// 공급사명
	private int m_id;				// 공급사번호
	private String type;	// 업종
	private String business_no;	// 사업자번호
	private String ceo_name;		// 대표자명
	private String ceo_phone;	// 대표자번호
	private String manager_name;	// 담당자명
	private String manager_phone; // 담당자번호
	private String contract_date; 	// 계약일
	private String con_finish_date; // 계약종료일
	private String contract_status; 	// 계약상태
	private String r_name;		// 레시피명
	private int r_id;	//레시피번호
	private int recipe_category_id;	//레시피카테고리번호
	private String r_title;		// 레시피제목
	private String r_content;		// 레시피내용
	
	public PrdRecipeMnftViewDto(ResultSet rs) throws Exception{
		setP_name(rs.getString("p_name"));
		setP_id(rs.getInt("p_id"));
		setP_title(rs.getString("p_title"));
		setP_content(rs.getString("p_content"));
		setProduct_category_name(rs.getString("product_category_name"));
		setP_content(rs.getString("p_content"));
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
		setFree_delv_yn(rs.getString("free_delv_yn"));
		setFree_delv_price(rs.getInt("free_delv_price"));
		setRegist_date(rs.getString("regist_date"));
		setSale_total(rs.getInt("sale_total"));
		setM_name(rs.getString("m_name"));
		setM_id(rs.getInt("m_id"));
		setType(rs.getString("type"));
		setBusiness_no(rs.getString("business_no"));
		setCeo_name(rs.getString("ceo_name"));
		setCeo_phone(rs.getString("ceo_phone"));
		setManager_name(rs.getString("manager_name"));
		setManager_phone(rs.getString("manager_phone"));
		setContract_date(rs.getString("contract_date"));
		setCon_finish_date(rs.getString("con_finish_date"));
		setContract_status(rs.getString("contract_status"));
		setR_name(rs.getString("r_name"));
		setR_id(rs.getInt("r_id"));
		setRecipe_category_id(rs.getInt("recipe_category_id"));
		setR_title(rs.getString("r_title"));
		setR_content(rs.getString("r_content"));
		setSale_yn(rs.getString("sale_yn"));
		setNew_yn(rs.getString("new_yn"));
	}

	public PrdRecipeMnftViewDto() {
		
	}

	// 최종판매가
	public int getLast_price() {
		return origin_price - (int)(origin_price *((dis_rate)/100.0));
	}
	
	// 할인가
	public int getDis_price() {
		return (int)(origin_price *((dis_rate)/100.0));
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

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	
	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getProduct_category_name() {
		return product_category_name;
	}

	public void setProduct_category_name(String product_category_name) {
		this.product_category_name = product_category_name;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
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

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBusiness_no() {
		return business_no;
	}

	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}

	public String getCeo_name() {
		return ceo_name;
	}

	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}

	public String getCeo_phone() {
		return ceo_phone;
	}

	public void setCeo_phone(String ceo_phone) {
		this.ceo_phone = ceo_phone;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_phone() {
		return manager_phone;
	}

	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}

	public String getContract_date() {
		return contract_date;
	}

	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}

	public String getCon_finish_date() {
		return con_finish_date;
	}

	public void setCon_finish_date(String con_finish_date) {
		this.con_finish_date = con_finish_date;
	}

	public String getContract_status() {
		return contract_status;
	}

	public void setContract_status(String contract_status) {
		this.contract_status = contract_status;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getRecipe_category_id() {
		return recipe_category_id;
	}

	public void setRecipe_category_id(int recipe_category_id) {
		this.recipe_category_id = recipe_category_id;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
  
	
	
}
