package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.AccountsDao;
import banThuCung.Entities.Accounts;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	AccountsDao accountsDao = new AccountsDao();
	
	public int addAccount(Accounts account) {
		
		List<Accounts> accList = accountsDao.getAccountCustomer();
		Accounts lastAcc = accList.get(accList.size() - 1);
		int nextString_num = Integer.parseInt(lastAcc.getAcc_id().substring(2)) + 1;
		String nextAcc_id = "CU" + nextString_num;
		
		account.setAcc_id(nextAcc_id);
		
		return accountsDao.addAccount(account);
	}

	public Accounts checkAccount(Accounts account) {
		Accounts accountget = accountsDao.getUserByAccount(account);
		
		if(accountget.getAcc_id() != null) {
			return accountget;
		}
		
		return null;
	}

}
