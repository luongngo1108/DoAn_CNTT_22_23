package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperOrders implements RowMapper<Orders>{

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		Orders orders = new Orders();
		orders.setOrder_id(rs.getString("order_id"));
		orders.setAcc_id(rs.getString("acc_id"));
		orders.setPay_id(rs.getString("pay_id"));
		orders.setDeli_ser_id(rs.getString("deli_ser_id"));
		orders.setName_receiver(rs.getString("name_receiver"));
		orders.setPhone_receiver(rs.getString("phone_receiver"));
		orders.setAddress_receiver(rs.getString("address_receiver"));
		orders.setTotal(rs.getDouble("total"));
		orders.setQuantity(rs.getDouble("quantity"));
		orders.setNote(rs.getString("note"));
		orders.setDate(rs.getDate("date"));
		return orders;
	}

}
