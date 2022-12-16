package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSupplier implements RowMapper<Supplier>{

	@Override
	public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
		Supplier supplier = new Supplier();
		supplier.setSup_id(rs.getString("sup_id"));
		supplier.setName(rs.getNString("name"));
		supplier.setAddress(rs.getNString("address"));
		supplier.setPhone(rs.getString("phone"));
		return supplier;
	}

}
