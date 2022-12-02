package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.CatePetWei;
import banThuCung.Entities.MapperCatePetWei;


@Repository
public class CatePetWeiDao extends BaseDao {
	
	public List<CatePetWei> GetAllFoodFlaCategories() {
		List<CatePetWei> list = new ArrayList<CatePetWei>();
		String sql = "Select * from petweight;";
		list = _jdbcTemplate.query(sql, new MapperCatePetWei());
		return list;
	}
	
	public int saveCatePetWei(CatePetWei catePetWei) {
		String sql = "Insert into petweight(petwei_id, type) values('"+catePetWei.getPetwei_id()+"','" + catePetWei.getType() + "')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateCatePetWei(CatePetWei catePetWei) {
		String sql = "Update petweight set type='" + catePetWei.getType() + "'" + "where petwei_id='" +catePetWei.getPetwei_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public CatePetWei getCatePetWeiByID(String petwei_id) {
		String sql = "select * from petweight where petwei_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperCatePetWei(), petwei_id);
	}
	
	public int deleteCatePetWei(String petwei_id) {
		String sql = "Delete from petweight where petwei_id=?";
		return _jdbcTemplate.update(sql, petwei_id);
	}
}
