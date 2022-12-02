package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.PaymentDao;
import banThuCung.Entities.Payment;

@Service
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private PaymentDao paymentDao;

	public List<Payment> getDataPayment() {
		return paymentDao.getPayments();
	}
}
