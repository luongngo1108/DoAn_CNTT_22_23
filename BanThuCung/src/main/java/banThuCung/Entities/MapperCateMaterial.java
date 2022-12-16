package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCateMaterial implements RowMapper<CateMaterial> {

	@Override
	public CateMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
		CateMaterial cateMaterial = new CateMaterial();
		cateMaterial.setMaterial_id(rs.getString("materials_id"));
		cateMaterial.setType(rs.getString("type"));
		return cateMaterial;
	}

}
