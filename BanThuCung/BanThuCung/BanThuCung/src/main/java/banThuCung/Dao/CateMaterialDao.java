package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.CateMaterial;
import banThuCung.Entities.MapperCateMaterial;


@Repository
public class CateMaterialDao extends BaseDao {
	
	public List<CateMaterial> GetAllFoodFlaCategories() {
		List<CateMaterial> list = new ArrayList<CateMaterial>();
		String sql = "Select * from materials";
		list = _jdbcTemplate.query(sql, new MapperCateMaterial());
		return list;
	}
	
	public int saveCateMaterial(CateMaterial cateMaterial) {
		String sql = "Insert into materials(materials_id, type) values('"+cateMaterial.getMaterial_id()+"','" + cateMaterial.getType() + "')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateCateMaterial(CateMaterial cateMaterial) {
		String sql = "Update materials set type='" + cateMaterial.getType() + "'" + "where materials_id='" +cateMaterial.getMaterial_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public CateMaterial getCateMaterialByID(String material_id) {
		String sql = "select * from materials where materials_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperCateMaterial(), material_id);
	}
	
	public int deleteCateMaterial(String material_id) {
		String sql = "Delete from materials where materials_id=?";
		return _jdbcTemplate.update(sql, material_id);
	}
}
