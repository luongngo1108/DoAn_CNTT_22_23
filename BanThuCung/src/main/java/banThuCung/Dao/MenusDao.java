package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.MapperMenus;
import banThuCung.Entities.Menus;

@Repository
public class MenusDao extends BaseDao{
	
	public List<Menus> GetDataMenus() {
		List<Menus> list = new ArrayList<Menus>();
		String sql = "Select * from menus;";
		list = _jdbcTemplate.query(sql, new MapperMenus());
		return list;
	}
}
