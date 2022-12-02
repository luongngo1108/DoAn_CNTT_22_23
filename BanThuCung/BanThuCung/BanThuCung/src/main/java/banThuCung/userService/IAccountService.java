package banThuCung.userService;

import org.springframework.stereotype.Service;

import banThuCung.Entities.Accounts;

@Service
public interface IAccountService {
	public int addAccount(Accounts account);
	public Accounts checkAccount(Accounts account);
}
