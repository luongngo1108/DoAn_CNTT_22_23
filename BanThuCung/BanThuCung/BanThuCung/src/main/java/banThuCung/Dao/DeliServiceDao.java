package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.DeliService;
import banThuCung.Entities.MapperDeliService;


@Repository
public class DeliServiceDao extends BaseDao {
	public List<DeliService> getDeliServices() {
		List<DeliService> list = new ArrayList<DeliService>();
		String sql = "Select * from delivery_service;";
		list = _jdbcTemplate.query(sql, new MapperDeliService());
		return list;
	}
	
	public int saveDeliService(DeliService deliService) {
		String sql = "Insert into delivery_service(deli_ser_id, deli_com_id, type, price, time)"
				+ "values(?,?,?,?,?,?,?)";
		return _jdbcTemplate.update(sql, deliService.getDeli_ser_id(), deliService.getDeli_com_id(), deliService.getType(),
				deliService.getPrice(), deliService.getTime());
	}
	
	public int updateDeliService(DeliService deliService) {
		String sql = "Update delivery_service set deli_com_id=?, type=?, price=?, time=? "
				+ "where deli_ser_id=?";
		return _jdbcTemplate.update(sql,deliService.getDeli_com_id(), deliService.getType(), deliService.getPrice(),
				deliService.getTime(), deliService.getDeli_ser_id());
	}
	
	public DeliService getDeliServiceByID(String deli_ser_id) {
		String sql = "select * from delivery_service where deli_ser_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperDeliService(), deli_ser_id);
	}
	
	public int deleteDeliService(String deli_ser_id) {
		String sql = "Delete from delivery_service where deli_ser_id=?";
		return _jdbcTemplate.update(sql, deli_ser_id);
	}
}
