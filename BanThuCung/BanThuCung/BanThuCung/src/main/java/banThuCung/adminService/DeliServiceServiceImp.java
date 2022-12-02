package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.DeliServiceDao;
import banThuCung.Entities.DeliService;

@Service
public class DeliServiceServiceImp implements IDeliServiceService {

	@Autowired
	DeliServiceDao deliServiceDao = new DeliServiceDao();

	@Override
	public List<DeliService> getDeliServices() {
		return deliServiceDao.getDeliServices();
	}

	@Override
	public int createDeliService(DeliService deliCompany) {
		return deliServiceDao.saveDeliService(deliCompany);
	}

	@Override
	public int updateDeliService(DeliService deliCompany) {
		return deliServiceDao.updateDeliService(deliCompany);
	}

	@Override
	public DeliService getDeliServiceByID(String deli_com_id) {
		return deliServiceDao.getDeliServiceByID(deli_com_id);
	}

	@Override
	public int deleteDeliService(String deli_com_id) {
		return deliServiceDao.deleteDeliService(deli_com_id);
	}

}
