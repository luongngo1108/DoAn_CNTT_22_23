package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProperty implements RowMapper<Property> {

	@Override
	public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
		Property property = new Property();
		property.setProper_id(rs.getString("proper_id"));
		property.setPetwei_id(rs.getString("petwei_id"));
		property.setColor_id(rs.getString("color_id"));
		property.setFoodwei_id(rs.getString("foodwei_id"));
		property.setFoodfla_id(rs.getString("foodfla_id"));
		property.setMaterial_id(rs.getString("materials_id"));
		return property;
	}

}
