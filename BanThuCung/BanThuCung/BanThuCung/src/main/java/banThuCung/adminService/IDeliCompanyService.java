package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.DeliCompany;

public interface IDeliCompanyService {
	public List<DeliCompany> getDeliCompanies();
	public int createDeliCompany(DeliCompany deliCompany);
	public int updateDeliCompany(DeliCompany deliCompany);
	public DeliCompany getDeliCompanyByID(String deli_com_id);
	public int deleteDeliCompany(String deli_com_id);
}
