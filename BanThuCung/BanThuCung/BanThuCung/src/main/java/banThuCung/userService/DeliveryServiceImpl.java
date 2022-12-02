package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.DeliServiceDao;
import banThuCung.Entities.DeliService;

@Service
public class DeliveryServiceImpl implements IDeliveryService {
	@Autowired
	private DeliServiceDao deliServiceDao;

	@Override
	public List<DeliService> getDataDeliService() {
		
		return deliServiceDao.getDeliServices();
	}
}
