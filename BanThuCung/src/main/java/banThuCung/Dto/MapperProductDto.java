package banThuCung.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductDto implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductDto product = new ProductDto();
		
		product.setPro_id(rs.getString("pro_id"));
		product.setProper_id(rs.getString("proper_id"));
		product.setCat_id(rs.getString("cat_id"));
		product.setSup_id(rs.getString("sup_id"));
		product.setPro_name(rs.getString("pro_name"));
		product.setQuantity(rs.getInt("quantity"));
		product.setPrice(rs.getInt("price"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNew_product(rs.getBoolean("new_product"));
		product.setDetail(rs.getString("detail"));
		product.setCreated_at(rs.getDate("created_at"));
		product.setUpdated_at(rs.getDate("updated_at"));
		product.setImg(rs.getString("img"));
		product.setPetwei_id(rs.getString("petwei_id"));
		product.setColor_id(rs.getString("color_id"));
		product.setFoodwei_id(rs.getString("foodwei_id"));
		product.setFoodfla_id(rs.getString("foodfla_id"));
		product.setMaterials_id(rs.getString("materials_id"));
		product.setCate_name(rs.getString("cate_name"));
		product.setSup_name(rs.getString("sup_name"));
		product.setPw_type(rs.getString("pw_type"));
		product.setCl_type(rs.getString("cl_type"));
		product.setFw_type(rs.getString("fw_type"));
		product.setFf_type(rs.getString("ff_type"));
		product.setMa_type(rs.getString("ma_type"));
		
		return product;
	}
	
}
