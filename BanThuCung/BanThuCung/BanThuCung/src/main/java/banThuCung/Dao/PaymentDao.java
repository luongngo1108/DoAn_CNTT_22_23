package banThuCung.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.MapperPayment;
import banThuCung.Entities.Payment;

@Repository
public class PaymentDao extends BaseDao{
	public List<Payment> getPayments(){
		String sql = "Select * from payment";
		return _jdbcTemplate.query(sql, new MapperPayment());
	}
}
