package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.DeliCompanyDao;
import banThuCung.Entities.DeliCompany;

@Service
public class DeliCompanyServiceImp implements IDeliCompanyService {

	@Autowired
	DeliCompanyDao deliCompanyDao = new DeliCompanyDao();

	@Override
	public List<DeliCompany> getDeliCompanies() {
		return deliCompanyDao.getDeliCompanies();
	}

	@Override
	public int createDeliCompany(DeliCompany deliCompany) {
		return deliCompanyDao.saveDeliCompany(deliCompany);
	}

	@Override
	public int updateDeliCompany(DeliCompany deliCompany) {
		return deliCompanyDao.updateDeliCompany(deliCompany);
	}

	@Override
	public DeliCompany getDeliCompanyByID(String deli_com_id) {
		return deliCompanyDao.getDeliCompanyByID(deli_com_id);
	}

	@Override
	public int deleteDeliCompany(String deli_com_id) {
		return deliCompanyDao.deleteDeliCompany(deli_com_id);
	}

}
