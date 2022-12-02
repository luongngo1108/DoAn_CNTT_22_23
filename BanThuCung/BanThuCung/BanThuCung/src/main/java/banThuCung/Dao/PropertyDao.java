package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.Property;
import banThuCung.Entities.MapperProperty;

@Repository
public class PropertyDao extends BaseDao{
	
	public List<Property> GetDataProperty() {
		List<Property> list = new ArrayList<Property>();
		String sql = "Select * from properties;";
		list = _jdbcTemplate.query(sql, new MapperProperty());
		return list;
	}
	
	public int saveProperty(Property property) {
		String sql = "Insert into properties(proper_id, petwei_id, color_id, foodwei_id, foodfla_id, materials_id) values(?,?,?,?,?,?)";
		return _jdbcTemplate.update(sql, property.getProper_id(), property.getPetwei_id(), property.getColor_id(),
				property.getFoodwei_id(),property.getFoodfla_id(),property.getMaterial_id());
	}
	
	public int updateProperty(Property property) {
		String sql = "Update properties set petwei_id=?,color_id=?,foodwei_id=?,foodfla_id=?,materials_id=? where proper_id=?";
		return _jdbcTemplate.update(sql,property.getPetwei_id(),property.getColor_id(),property.getFoodwei_id(),property.getFoodfla_id(),
				property.getMaterial_id(),property.getProper_id());
	}
	
	public Property getPropertyByID(String proper_id) {
		String sql = "select * from properties where proper_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperProperty(), proper_id);
	}
	
	public int deleteProperty(String proper_id) {
		String sql = "Delete from properties where proper_id=?";
		return _jdbcTemplate.update(sql, proper_id);
	}
}
