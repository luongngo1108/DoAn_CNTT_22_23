package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCateColor implements RowMapper<CateColor>{

	@Override
	public CateColor mapRow(ResultSet rs, int rowNum) throws SQLException {
		CateColor cateColor = new CateColor();
		cateColor.setColor_id(rs.getString("color_id"));
		cateColor.setType(rs.getString("type"));
		return cateColor;
	}

}
