package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.CateFoodFla;
import banThuCung.Entities.MapperCateFoodFla;

@Repository
public class CateFoodFlaDao extends BaseDao {
	
	public List<CateFoodFla> GetAllFoodFlaCategories() {
		List<CateFoodFla> list = new ArrayList<CateFoodFla>();
		String sql = "Select * from foodflavorings;";
		list = _jdbcTemplate.query(sql, new MapperCateFoodFla());
		return list;
	}
	
	public int saveCateFoodFla(CateFoodFla cateFoodFla) {
		String sql = "Insert into foodflavorings(foodfla_id, type) values('"+cateFoodFla.getFoodfla_id()+"','" + cateFoodFla.getType() + "')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateCateFoodFla(CateFoodFla cateFoodFla) {
		String sql = "Update foodflavorings set type='" + cateFoodFla.getType() + "'" + "where foodfla_id='" +cateFoodFla.getFoodfla_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public CateFoodFla getCateFoodFlaByID(String foodfla_id) {
		String sql = "select * from foodflavorings where foodfla_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperCateFoodFla(), foodfla_id);
	}
	
	public int deleteCateFoodFla(String foodfla_id) {
		String sql = "Delete from foodflavorings where foodfla_id=?";
		return _jdbcTemplate.update(sql, foodfla_id);
	}
}
