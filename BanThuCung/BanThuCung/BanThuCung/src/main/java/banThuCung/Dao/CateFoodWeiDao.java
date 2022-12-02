package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.CateFoodWei;
import banThuCung.Entities.MapperCateFoodWei;

@Repository
public class CateFoodWeiDao extends BaseDao {
	
	public List<CateFoodWei> GetAllFoodWeiCategories() {
		List<CateFoodWei> list = new ArrayList<CateFoodWei>();
		String sql = "Select * from foodweight;";
		list = _jdbcTemplate.query(sql, new MapperCateFoodWei());
		return list;
	}
	
	public int saveCateFoodWei(CateFoodWei cateFoodWei) {
		String sql = "Insert into foodweight(foodwei_id, type) values('"+cateFoodWei.getFoodwei_id()+"','" + cateFoodWei.getType() + "')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateCateFoodWei(CateFoodWei cateFoodWei) {
		String sql = "Update foodweight set type='" + cateFoodWei.getType() + "'" + "where foodwei_id='" +cateFoodWei.getFoodwei_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public CateFoodWei getCateFoodWeiByID(String foodwei_id) {
		String sql = "select * from foodweight where foodwei_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperCateFoodWei(), foodwei_id);
	}
	
	public int deleteCateFoodWei(String foodwei_id) {
		String sql = "Delete from foodweight where foodwei_id=?";
		return _jdbcTemplate.update(sql, foodwei_id);
	}
}
