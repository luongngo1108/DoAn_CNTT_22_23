package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.PaymentDao;
import banThuCung.Entities.Payment;

@Service
public class PaymentServiceImp implements IPaymentService {
	@Autowired
	PaymentDao paymentDao = new PaymentDao();

	@Override
	public List<Payment> getPayments() {
		return paymentDao.getPayments();
	}
}
