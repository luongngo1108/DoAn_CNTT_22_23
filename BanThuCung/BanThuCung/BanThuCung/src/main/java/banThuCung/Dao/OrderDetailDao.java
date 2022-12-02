package banThuCung.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.MapperOrderDetail;
import banThuCung.Entities.Order_detail;

@Repository
public class OrderDetailDao extends BaseDao {
	public List<Order_detail> getOrderDetails() {
		List<Order_detail> result = null;
		String sql = "SELECT * FROM order_detail";
			result = _jdbcTemplate.query(sql, new MapperOrderDetail());
		return result;
	}
	
	public int saveOrderDetail(Order_detail order_detail) {
		String sql = "Insert into order_detail(order_id, pro_id, proper_id, quantity, total, paid) "
				+ "values(?,?,?,?,?,?)";
		return _jdbcTemplate.update(sql,order_detail.getOrder_id(), order_detail.getPro_id(), order_detail.getProper_id(),
				order_detail.getQuantity(),order_detail.getTotal(), order_detail.isPaid());
	}
	
	public int updateOrderDetail(Order_detail order_detail) {
		String sql = "Update order_detail set pro_id=?, proper_id=?, quantity=?, total=?, paid=?"
				+ " where order_id=?";
		return _jdbcTemplate.update(sql, order_detail.getPro_id(), order_detail.getProper_id(), order_detail.getQuantity(),
				order_detail.getTotal(),order_detail.isPaid(), order_detail.getOrder_id());
	}
	
	public Order_detail getOrderDetailByID(String order_detail_id) {
		String sql = "select * from Order_detail where order_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperOrderDetail(), order_detail_id);
	}
	
	public int deleteOrderDetail(String order_detail_id) {
		String sql = "Delete from Order_detail where order_id=?";
		return _jdbcTemplate.update(sql, order_detail_id);	
	}
}
