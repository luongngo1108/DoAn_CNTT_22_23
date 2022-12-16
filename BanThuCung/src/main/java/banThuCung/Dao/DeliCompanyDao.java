package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Entities.DeliCompany;
import banThuCung.Entities.MapperDeliCompany;


@Repository
public class DeliCompanyDao extends BaseDao {
	public String generateId() {
		String prefix = "DC";
		String count = _jdbcTemplate.queryForObject("select count(deli_com_id) from delivery_company", Integer.class).toString();
		int newId = Integer.parseInt(count) + 101;
		return prefix + newId;
	}
	
	public List<DeliCompany> getDeliCompanies() {
		List<DeliCompany> list = new ArrayList<DeliCompany>();
		String sql = "Select * from delivery_company;";
		list = _jdbcTemplate.query(sql, new MapperDeliCompany());
		return list;
	}
	
	public int saveDeliCompany(DeliCompany deliCompany) {
		String sql = "Insert into delivery_company(deli_com_id, name, address, phone, email, name_contact, web_url) "
				+ "values(?,?,?,?,?,?,?)";
		return _jdbcTemplate.update(sql, generateId(), deliCompany.getName(), deliCompany.getAddress(),
				deliCompany.getPhone(), deliCompany.getEmail(), deliCompany.getName_contact(), deliCompany.getWeb_url());
	}
	
	public int updateDeliCompany(DeliCompany deliCompany) {
		String sql = "Update delivery_company set name=?, address=?, phone=?, email=?, name_contact=?, web_url=? "
				+ "where deli_com_id=?";
		return _jdbcTemplate.update(sql,deliCompany.getName(), deliCompany.getAddress(), deliCompany.getPhone(), 
				deliCompany.getEmail(), deliCompany.getName_contact(), deliCompany.getWeb_url(), deliCompany.getDeli_com_id());
	}
	
	public DeliCompany getDeliCompanyByID(String deli_com_id) {
		String sql = "select * from delivery_company where deli_com_id=?";
		return _jdbcTemplate.queryForObject(sql, new MapperDeliCompany(), deli_com_id);
	}
	
	public int deleteDeliCompany(String deli_com_id) {
		String sql = "Delete from delivery_company where deli_com_id=?";
		return _jdbcTemplate.update(sql, deli_com_id);
	}
}
