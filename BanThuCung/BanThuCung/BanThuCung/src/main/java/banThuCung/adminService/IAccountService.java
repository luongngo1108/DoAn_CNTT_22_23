package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.Accounts;
public interface IAccountService {
	public boolean checkAccount(Accounts account);
	public int countAccount();
	public Accounts getAdminAcc(Accounts account);
	public List<Accounts> getCusAccounts();
	public int updateAccount(Accounts accounts);
	public Accounts getAccountsByID(String acc_id);
	public int deleteAccount(String acc_id);
}
