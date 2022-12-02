package banThuCung.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.MapperSupplier;
import banThuCung.Entities.Supplier;

@Repository
public class SupplierDao extends BaseDao {
	public List<Supplier> getAllSuppliers(){
		String sql = "Select * from Supplier";
		return _jdbcTemplate.query(sql, new MapperSupplier());
	}
	
	public int saveSupplier(Supplier supplier) {
		String sql = "Insert into Supplier(sup_id, name, address, phone) values('"+supplier.getSup_id()+"','"
						+ supplier.getName() + "','" + supplier.getAddress() +"','" + supplier.getPhone()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int updateSupplier(Supplier supplier) {
		String sql = "Update Supplier set name='"
						+ supplier.getName() + "',address='" + supplier.getAddress() +"',phone='" + supplier.getPhone()+"'"
						+ "where sup_id='" +supplier.getSup_id()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public Supplier getSupplierByID(String sup_id) {
		String sql = "select * from Supplier where sup_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperSupplier(), sup_id);
	}
	
	public int deleteSupplier(String sup_id) {
		String sql = "Delete from Supplier where sup_id=?";
		return _jdbcTemplate.update(sql, sup_id);
	}
}
