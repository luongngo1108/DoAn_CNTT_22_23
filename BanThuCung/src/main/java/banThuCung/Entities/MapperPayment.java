package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperPayment implements RowMapper<Payment> {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payment payment = new Payment();
		payment.setPay_id(rs.getString("pay_id"));
		payment.setName(rs.getNString("name"));
		return payment;
	}
	
}
