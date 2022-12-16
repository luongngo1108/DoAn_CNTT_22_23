package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.SupplierDao;
import banThuCung.Entities.Supplier;

@Service
public class SupplierServcieImp implements ISupplierService {
	@Autowired
	SupplierDao supplierDao = new SupplierDao();

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierDao.getAllSuppliers();
	}

	@Override
	public int createSupplier(Supplier supplier) {
		return supplierDao.saveSupplier(supplier);
	}

	@Override
	public int updateSupplier(Supplier supplier) {
		return supplierDao.updateSupplier(supplier);
	}

	@Override
	public Supplier getSupplierByID(String sup_id) {
		return supplierDao.getSupplierByID(sup_id);
	}

	@Override
	public int deleteSupplier(String sup_id) {
		return supplierDao.deleteSupplier(sup_id);
	}
	
	
}
