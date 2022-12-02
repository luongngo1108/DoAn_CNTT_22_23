package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCatePetWei implements RowMapper<CatePetWei> {

	@Override
	public CatePetWei mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatePetWei catePetWei = new CatePetWei();
		catePetWei.setPetwei_id(rs.getString("petwei_id"));
		catePetWei.setType(rs.getString("type"));
		return catePetWei;
	}

}
