package banThuCung.userService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.OrdersDao;
import banThuCung.Dto.CartDto;
import banThuCung.Entities.Order_detail;
import banThuCung.Entities.Orders;

@Service
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
	private OrdersDao ordersDao;
	
	public int addOrders(Orders order) {
		List<Orders> orderList = ordersDao.getListOrders();
		Orders lastOrder = orderList.get(orderList.size() - 1);
		int nextString_num = Integer.parseInt(lastOrder.getOrder_id().substring(2)) + 1;
		String nextOrder_id = "OR" + nextString_num;
		
		order.setOrder_id(nextOrder_id);
		
		long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);  
		order.setDate(date);
		
		return ordersDao.addOrders(order);
	}

	public void addOrdersDetail(HashMap<String, CartDto> carts) {
		String order_id = ordersDao.getLastOrders_ID();
		for(Map.Entry<String, CartDto> itemCart : carts.entrySet()) {
			Order_detail order_detail = new Order_detail();
			order_detail.setOrder_id(order_id);
			order_detail.setPro_id(itemCart.getValue().getProduct().getPro_id());
			order_detail.setProper_id(itemCart.getValue().getProduct().getProper_id());
			order_detail.setQuantity(itemCart.getValue().getQuantity());
			order_detail.setTotal(itemCart.getValue().getTotalPrice());
			ordersDao.addOrderDetail(order_detail);
		}
	}
	
}
