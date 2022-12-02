package banThuCung.Dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import banThuCung.Entities.Accounts;
import banThuCung.Entities.MapperAccount;

@Repository
public class AccountsDao extends BaseDao {

	public int addAccount(Accounts account) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO account ");
		sql.append("( ");
		sql.append("	acc_id, ");
		sql.append("	name, ");
		sql.append("	email, ");
		sql.append("	password, ");
		sql.append("	phone, ");
		sql.append("	address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("	'" + account.getAcc_id() + "', ");
		sql.append("	'" + account.getName() + "', ");
		sql.append("	'" + account.getEmail() + "', ");
		sql.append("	'" + account.getPassword() + "', ");
		sql.append("	'" + account.getPhone() + "', ");
		sql.append("	'" + account.getAddress() + "' ");
		sql.append(");");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Accounts getUserByAccount(Accounts account) {
		String sql = "SELECT * FROM account WHERE acc_id LIKE \'CU%\' and email = ? and password= ?";
		Accounts result = new Accounts();
		try {
			result = _jdbcTemplate.queryForObject(sql, new MapperAccount(), account.getEmail(), account.getPassword());
		} catch (EmptyResultDataAccessException e) {	
			return result;
		}
		return result;
	}
	
	public Accounts getAccountAdmin(Accounts account) {
		Accounts result = null;
		String sql = "SELECT * FROM account WHERE acc_id LIKE \'AD%\' "
				+ "and email='" + account.getEmail() + "' and password='"+account.getPassword()+"';";
		try {
			result = _jdbcTemplate.queryForObject(sql, new MapperAccount());
		} catch (EmptyResultDataAccessException e) { }
		return result;
	}
	
	public List<Accounts> getAccountCustomer() {
		List<Accounts> lisAccCus = null;
		String sql = "SELECT * FROM account WHERE acc_id LIKE \'CU%\' ";
		lisAccCus = _jdbcTemplate.query(sql, new MapperAccount());
		return lisAccCus;
	}
	
	public int updateAccount(Accounts accounts) {
		String sql = "Update account set name=?, email=?, phone=?, address=?, password=? where acc_id=?";
		return _jdbcTemplate.update(sql, accounts.getName(), accounts.getEmail(), accounts.getPhone(),accounts.getAddress(),
				accounts.getPassword(), accounts.getAcc_id());
	}
	
	public Accounts getAccountsByID(String acc_id) {
		String sql = "Select * from account where acc_id = ?";
		return _jdbcTemplate.queryForObject(sql, new MapperAccount(),acc_id);
	}
	
	public int deleteAccount(String acc_id) {
		String sql = "Delete from account where acc_id=?";
		return _jdbcTemplate.update(sql, acc_id);
	}
}
