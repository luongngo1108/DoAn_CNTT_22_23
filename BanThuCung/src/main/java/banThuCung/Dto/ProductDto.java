package banThuCung.Dto;

import java.sql.Date;

public class ProductDto {
	private String pro_id;
	private String proper_id;
	private String cat_id;
	private String sup_id;
	private String pro_name;
	private int quantity;
	private int price;
	private Boolean highlight;
	private Boolean new_product;
	private String detail;
	private Date created_at;
	private Date updated_at;
	private String img;
	private String petwei_id;
	private String color_id;
	private String foodwei_id;
	private String foodfla_id;
	private String materials_id;
	private String cate_name;
	private String sup_name;
	private String pw_type;
	private String cl_type;
	private String fw_type;
	private String ff_type;
	private String ma_type;
	
	public ProductDto() {
		super();
	}
	
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getProper_id() {
		return proper_id;
	}
	public void setProper_id(String proper_id) {
		this.proper_id = proper_id;
	}
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getSup_id() {
		return sup_id;
	}
	public void setSup_id(String sup_id) {
		this.sup_id = sup_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Boolean getHighlight() {
		return highlight;
	}
	public void setHighlight(Boolean highlight) {
		this.highlight = highlight;
	}
	public Boolean getNew_product() {
		return new_product;
	}
	public void setNew_product(Boolean new_product) {
		this.new_product = new_product;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public String getPetwei_id() {
		return petwei_id;
	}
	public void setPetwei_id(String petwei_id) {
		this.petwei_id = petwei_id;
	}
	public String getColor_id() {
		return color_id;
	}
	public void setColor_id(String color_id) {
		this.color_id = color_id;
	}
	public String getFoodwei_id() {
		return foodwei_id;
	}
	public void setFoodwei_id(String foodwei_id) {
		this.foodwei_id = foodwei_id;
	}
	public String getFoodfla_id() {
		return foodfla_id;
	}
	public void setFoodfla_id(String foodfla_id) {
		this.foodfla_id = foodfla_id;
	}
	public String getMaterials_id() {
		return materials_id;
	}
	public void setMaterials_id(String materials_id) {
		this.materials_id = materials_id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	public String getPw_type() {
		return pw_type;
	}
	public void setPw_type(String pw_type) {
		this.pw_type = pw_type;
	}
	public String getCl_type() {
		return cl_type;
	}
	public void setCl_type(String cl_type) {
		this.cl_type = cl_type;
	}
	public String getFw_type() {
		return fw_type;
	}
	public void setFw_type(String fw_type) {
		this.fw_type = fw_type;
	}
	public String getFf_type() {
		return ff_type;
	}
	public void setFf_type(String ff_type) {
		this.ff_type = ff_type;
	}
	public String getMa_type() {
		return ma_type;
	}
	public void setMa_type(String ma_type) {
		this.ma_type = ma_type;
	}
}
