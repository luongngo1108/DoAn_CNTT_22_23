package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperAccount implements RowMapper<Accounts>{

	@Override
	public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
		Accounts account = new Accounts();
		account.setAcc_id(rs.getString("acc_id"));
		account.setName(rs.getString("name"));
		account.setEmail(rs.getString("email"));
		account.setPassword(rs.getString("password"));
		account.setPhone(rs.getString("phone"));
		account.setAddress(rs.getString("address"));
		return account;
	}

}