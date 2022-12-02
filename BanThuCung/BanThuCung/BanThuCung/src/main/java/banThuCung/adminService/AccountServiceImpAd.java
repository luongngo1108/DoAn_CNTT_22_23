package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Entities.Accounts;
import banThuCung.Dao.*;

@Service
public class AccountServiceImpAd implements IAccountService {
	@Autowired
	AccountsDao accountDao = new AccountsDao();
	
	@Override
	public boolean checkAccount(Accounts account) {
		account = accountDao.getAccountAdmin(account);
		if(account != null) return true;
		return false;
	}

	@Override
	public int countAccount() {
		List<Accounts> lacc = accountDao.getAccountCustomer();
		return lacc.size();
	}

	@Override
	public Accounts getAdminAcc(Accounts account) {
		return accountDao.getAccountAdmin(account);
	}

	@Override
	public List<Accounts> getCusAccounts() {
		return accountDao.getAccountCustomer();
	}

	@Override
	public int updateAccount(Accounts accounts) {
		return accountDao.updateAccount(accounts);
	}

	@Override
	public Accounts getAccountsByID(String acc_id) {
		return accountDao.getAccountsByID(acc_id);
	}

	@Override
	public int deleteAccount(String acc_id) {
		return accountDao.deleteAccount(acc_id);
	}
}
