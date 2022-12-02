package banThuCung.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.MapperOrders;
import banThuCung.Entities.Order_detail;
import banThuCung.Entities.Orders;

@Repository
public class OrdersDao extends BaseDao{
	//User
	public List<Orders> getListOrders() {
		List<Orders> listOrders = null;
		String sql = "SELECT * FROM orders WHERE order_id LIKE \'OR%\' ";
		listOrders = _jdbcTemplate.query(sql, new MapperOrders());
		return listOrders;
	}

	public int addOrders(Orders order) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO orders ");
		sql.append("( ");
		sql.append("	order_id, ");
		sql.append("	acc_id, ");
		sql.append("	pay_id, ");
		sql.append("	deli_ser_id, ");
		sql.append("	name_receiver, ");
		sql.append("	phone_receiver, ");
		sql.append("	address_receiver, ");
		sql.append("	note, ");
		sql.append("	total, ");
		sql.append("	quantity, ");
		sql.append("	date ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'" + order.getOrder_id() + "', ");
		sql.append("	'" + order.getAcc_id() + "', ");
		sql.append("	'" + order.getPay_id() + "', ");
		sql.append("	'" + order.getDeli_ser_id() + "', ");
		sql.append("	'" + order.getName_receiver() + "', ");
		sql.append("	'" + order.getPhone_receiver() + "', ");
		sql.append("	'" + order.getAddress_receiver() + "', ");
		sql.append("	'" + order.getNote() + "', ");
		sql.append("	" + order.getTotal() + ", ");
		sql.append("	" + order.getQuantity() + ", ");
		sql.append("	'" + order.getDate() + "' ");
		sql.append(");");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

	public String getLastOrders_ID() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1;");
		String order_id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, String.class);
		return order_id;
	}

	public int addOrderDetail(Order_detail order_detail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO order_detail ");
		sql.append("( ");
		sql.append("	order_id, ");
		sql.append("	pro_id, ");
		sql.append("	proper_id, ");
		sql.append("	quantity, ");
		sql.append("	total, ");
		sql.append("	paid ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'" + order_detail.getOrder_id() + "', ");
		sql.append("	'" + order_detail.getPro_id() + "', ");
		sql.append("	'" + order_detail.getProper_id() + "', ");
		sql.append("	" + order_detail.getQuantity() + ", ");
		sql.append("	" + order_detail.getTotal() + ", ");
		sql.append(" true ");
		sql.append(");");

		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	//ADmin
	public List<Orders> getOrders() {
		String sql = "SELECT * FROM orders";
		return _jdbcTemplate.query(sql,new MapperOrders());
	}

	public int saveOrder(Orders orders) {
		String sql = "Insert into orders(order_id, acc_id, pay_id, deli_ser_id, name_receiver, phone_receiver, address_receiver, note, "
				+ "total, quantity,date) values(?,?,?,?,?,?,?,?,?,?,?)";
		return _jdbcTemplate.update(sql,orders.getOrder_id(), orders.getAcc_id(),orders.getPay_id(), orders.getDeli_ser_id(), 
				orders.getName_receiver(), orders.getPhone_receiver(),
				orders.getAddress_receiver(), orders.getNote(),orders.getTotal(), orders.getQuantity(), orders.getDate());
	}

	public int updateOrders(Orders orders) {
		String sql = "Update Orders set acc_id=?,pay_id=?, deli_ser_id=?,  name_receiver=?, phone_receiver=?, address_receiver=?, note=?, "
				+ "total=?, quantity=?,date=? where order_id=?";
		return _jdbcTemplate.update(sql,orders.getAcc_id(),orders.getPay_id(),orders.getDeli_ser_id(), orders.getName_receiver(), 
				orders.getPhone_receiver(), orders.getAddress_receiver(), orders.getNote(),orders.getTotal(), orders.getQuantity(),
				orders.getDate(), orders.getOrder_id());
	}

	public Orders getOrdersByID(String order_id) {
		String sql = "select * from Orders where order_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperOrders(), order_id);
	}

	public int deleteOrders(String order_id) {
		String sql = "Delete from Orders where order_id=?";
		return _jdbcTemplate.update(sql, order_id);
	}
}
