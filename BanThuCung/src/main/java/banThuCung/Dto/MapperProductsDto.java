package banThuCung.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductsDto implements RowMapper<ProductsDto> {

	@Override
	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto products = new ProductsDto();
		
		products.setPro_id(rs.getString("pro_id"));
		products.setProper_id(rs.getString("proper_id"));
		products.setCat_id(rs.getString("cat_id"));
		products.setSup_id(rs.getString("sup_id"));
		products.setPro_name(rs.getString("pro_name"));
		products.setQuantity(rs.getInt("quantity"));
		products.setPrice(rs.getInt("price"));
		products.setHighlight(rs.getBoolean("highlight"));
		products.setNew_product(rs.getBoolean("new_product"));
		products.setDetail(rs.getString("detail"));
		products.setCreated_at(rs.getDate("created_at"));
		products.setUpdated_at(rs.getDate("updated_at"));
		products.setImg(rs.getString("img"));
		products.setPetwei_id(rs.getString("petwei_id"));
		products.setColor_id(rs.getString("color_id"));
		products.setFoodwei_id(rs.getString("foodwei_id"));
		products.setFoodfla_id(rs.getString("foodfla_id"));
		products.setMaterials_id(rs.getString("materials_id"));
		products.setCate_name(rs.getString("cate_name"));
		products.setSup_name(rs.getString("sup_name"));
		
		return products;
	}
	
}
