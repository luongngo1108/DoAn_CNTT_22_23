package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.MapperSlides;
import banThuCung.Entities.Slides;

@Repository
public class SlidesDao extends BaseDao{
	
	public List<Slides> GetDataSlides() {
		List<Slides> list = new ArrayList<Slides>();
		String sql = "Select * from slides;";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
}
