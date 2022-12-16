package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.Supplier;

public interface ISupplierService {
	public List<Supplier> getAllSuppliers();
	public int createSupplier(Supplier supplier);
	public int updateSupplier(Supplier supplier);
	public Supplier getSupplierByID(String sup_id);
	public int deleteSupplier(String sup_id);
}
