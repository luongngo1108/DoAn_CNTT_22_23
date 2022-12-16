package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperDeliCompany implements RowMapper<DeliCompany> {

	@Override
	public DeliCompany mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeliCompany deliCompany = new DeliCompany();
		deliCompany.setDeli_com_id(rs.getString("deli_com_id"));
		deliCompany.setName(rs.getNString("name"));
		deliCompany.setAddress(rs.getNString("address"));
		deliCompany.setPhone(rs.getString("phone"));
		deliCompany.setEmail(rs.getString("email"));
		deliCompany.setName_contact(rs.getNString("name_contact"));
		deliCompany.setWeb_url(rs.getString("web_url"));
		return deliCompany;
	}

}
