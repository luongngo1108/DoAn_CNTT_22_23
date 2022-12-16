package banThuCung.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperOrderDetail implements RowMapper<Order_detail> {

	@Override
	public Order_detail mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order_detail order_detail = new Order_detail();
		order_detail.setOrder_id(rs.getString("order_id"));
		order_detail.setPro_id(rs.getString("pro_id"));
		order_detail.setProper_id(rs.getString("proper_id"));
		order_detail.setQuantity(rs.getInt("quantity"));
		order_detail.setTotal(rs.getInt("total"));
		order_detail.setPaid(rs.getBoolean("paid"));
		return order_detail;
	}
}