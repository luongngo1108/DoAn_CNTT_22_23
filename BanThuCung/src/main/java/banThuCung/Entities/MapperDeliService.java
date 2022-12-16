package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperDeliService implements RowMapper<DeliService> {

	@Override
	public DeliService mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeliService deliService = new DeliService();
		deliService.setDeli_ser_id(rs.getString("deli_ser_id"));
		deliService.setDeli_com_id(rs.getString("deli_com_id"));
		deliService.setType(rs.getNString("type"));
		deliService.setPrice(rs.getInt("price"));
		deliService.setTime(rs.getString("time"));
		return deliService;
	}

}
