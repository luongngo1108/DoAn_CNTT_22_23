package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.OrderDetailDao;
import banThuCung.Dao.OrdersDao;
import banThuCung.Entities.Order_detail;
import banThuCung.Entities.Orders;

@Service
public class OrderServiceImp implements IOrdersService {
	@Autowired
	OrdersDao orderDao = new OrdersDao();
	
	@Autowired
	OrderDetailDao orderdetailDao = new OrderDetailDao();
	
	@Override
	public int totalOrder() {
		List<Orders> oList = orderDao.getOrders();
		return oList.size();
	}

	@Override
	public int totalRevenue() {
		List<Order_detail> order_details = orderdetailDao.getOrderDetails();
		int total = 0;
		for (Order_detail od : order_details) {
			total += od.getTotal();
		}
		return total;
	}
	
	//Orders
	@Override
	public List<Orders> getOrders() {
		return orderDao.getOrders();
	}

	@Override
	public int createOrders(Orders order) {
		return orderDao.saveOrder(order);
	}

	@Override
	public int updateOrders(Orders order) {
		return orderDao.updateOrders(order);
	}

	@Override
	public Orders getOrdersByID(String order_id) {
		return orderDao.getOrdersByID(order_id);
	}

	@Override
	public int deleteOrder(String order_id) {
		return orderDao.deleteOrders(order_id);
	}

	//Order_detail
	@Override
	public List<Order_detail> getOrderDetails() {
		return orderdetailDao.getOrderDetails();
	}

	@Override
	public int createOrderDetail(Order_detail order_detail) {
		return orderdetailDao.saveOrderDetail(order_detail);
	}

	@Override
	public int updateOrderDetail(Order_detail order_detail) {
		return orderdetailDao.updateOrderDetail(order_detail);
	}

	@Override
	public Order_detail getOrderDetailByID(String order_detail_id) {
		return orderdetailDao.getOrderDetailByID(order_detail_id);
	}

	@Override
	public int deleteOrderDetail(String order_detail_id) {
		return orderdetailDao.deleteOrderDetail(order_detail_id);
	}
	

}
