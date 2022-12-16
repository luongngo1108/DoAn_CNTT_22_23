package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.Order_detail;
import banThuCung.Entities.Orders;


public interface IOrdersService {
	public int totalOrder();
	public int totalRevenue();
	//Orders
	public List<Orders> getOrders();
	public int createOrders(Orders order);
	public int updateOrders(Orders order);
	public Orders getOrdersByID(String order_id);
	public int deleteOrder(String order_id);
	//Order_detail
	public List<Order_detail> getOrderDetails();
	public int createOrderDetail(Order_detail order_detail);
	public int updateOrderDetail(Order_detail order_detail);
	public Order_detail getOrderDetailByID(String order_detail_id);
	public int deleteOrderDetail(String order_detail_id);
}
