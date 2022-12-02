package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCateFoodFla implements RowMapper<CateFoodFla>{

	@Override
	public CateFoodFla mapRow(ResultSet rs, int rowNum) throws SQLException {
		CateFoodFla cateFoodFla = new CateFoodFla();
		cateFoodFla.setFoodfla_id(rs.getString("foodfla_id"));
		cateFoodFla.setType(rs.getString("type"));
		return cateFoodFla;
	}

}
