package banThuCung.userService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CartDao;
import banThuCung.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDao cartDao = new CartDao();

	public HashMap<String, CartDto> addCart(String id, HashMap<String, CartDto> cart) {
		
		return cartDao.addCart(id, cart);
	}

	public HashMap<String, CartDto> editCart(String id, int quantity, HashMap<String, CartDto> cart) {

		return cartDao.editCart(id, quantity, cart);
	}

	public HashMap<String, CartDto> deleteCart(String id, HashMap<String, CartDto> cart) {

		return cartDao.deleteCart(id, cart);
	}

	public int totalQuantity(HashMap<String, CartDto> cart) {

		return cartDao.totalQuantity(cart);
	}

	public double totalPrice(HashMap<String, CartDto> cart) {

		return cartDao.totalPrice(cart);
	}
	
}
