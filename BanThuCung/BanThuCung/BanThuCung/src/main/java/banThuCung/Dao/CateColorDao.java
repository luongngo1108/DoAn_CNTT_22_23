package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.CateColor;
import banThuCung.Entities.MapperCateColor;

@Repository
public class CateColorDao extends BaseDao {
	
	public List<CateColor> GetAllColorCategories() {
		List<CateColor> list = new ArrayList<CateColor>();
		String sql = "Select * from color;";
		list = _jdbcTemplate.query(sql, new MapperCateColor());
		return list;
	}
	
	public int saveCateColor(CateColor cateColor) {
		String sql = "Insert into Color(color_id, type) values('"+cateColor.getColor_id()+"','" + cateColor.getType() + "')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateCateColor(CateColor cateColor) {
		String sql = "Update Color set type='" + cateColor.getType() + "'" + "where color_id='" +cateColor.getColor_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public CateColor getCateColorByID(String color_id) {
		String sql = "select * from Color where color_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperCateColor(), color_id);
	}
	
	public int deleteCateColor(String color_id) {
		String sql = "Delete from Color where color_id=?";
		return _jdbcTemplate.update(sql, color_id);
	}
}
