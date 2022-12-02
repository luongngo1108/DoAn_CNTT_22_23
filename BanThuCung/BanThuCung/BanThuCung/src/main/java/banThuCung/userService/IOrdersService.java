package banThuCung.userService;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import banThuCung.Dto.CartDto;
import banThuCung.Entities.Orders;

@Service
public interface IOrdersService {
	public int addOrders(Orders order);
	public void addOrdersDetail(HashMap<String, CartDto> carts);
}
