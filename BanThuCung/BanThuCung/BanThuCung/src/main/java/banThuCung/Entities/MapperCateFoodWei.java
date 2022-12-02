package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCateFoodWei implements RowMapper<CateFoodWei>{

	@Override
	public CateFoodWei mapRow(ResultSet rs, int rowNum) throws SQLException {
		CateFoodWei cateFoodWei = new CateFoodWei();
		cateFoodWei.setFoodwei_id(rs.getString("foodwei_id"));
		cateFoodWei.setType(rs.getString("type"));
		return cateFoodWei;
	}

}
