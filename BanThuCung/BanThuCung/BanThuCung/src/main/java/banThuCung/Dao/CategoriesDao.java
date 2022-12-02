package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.Categories;
import banThuCung.Entities.MapperCategories;

@Repository
public class CategoriesDao extends BaseDao{
	
	public List<Categories> GetDataCategories() {
		List<Categories> list = new ArrayList<Categories>();
		String sql = "Select * from category;";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	}
	
	public int saveCategory(Categories category) {
		String sql = "Insert into Category(cat_id, name) values('"+category.getCat_id()+"','" + category.getName() + "')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateCategory(Categories category) {
		String sql = "Update Category set name='" + category.getName() + "'" + "where cat_id='" +category.getCat_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public Categories getCategoryByID(String cat_id) {
		String sql = "select * from Category where cat_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperCategories(), cat_id);
	}
	
	public int deleteCategory(String cat_id) {
		String sql = "Delete from Category where cat_id=?";
		return _jdbcTemplate.update(sql, cat_id);
	}
}
