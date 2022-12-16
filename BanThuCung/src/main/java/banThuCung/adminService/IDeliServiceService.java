package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.DeliService;

public interface IDeliServiceService {
	public List<DeliService> getDeliServices();
	public int createDeliService(DeliService deliService);
	public int updateDeliService(DeliService deliService);
	public DeliService getDeliServiceByID(String deli_ser_id);
	public int deleteDeliService(String deli_ser_id);
}
