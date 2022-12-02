package banThuCung.userController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Dto.CartDto;
import banThuCung.Entities.Accounts;
import banThuCung.Entities.Orders;
import banThuCung.userService.CartServiceImpl;
import banThuCung.userService.DeliveryServiceImpl;
import banThuCung.userService.OrdersServiceImpl;
import banThuCung.userService.PaymentServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@Autowired
	private OrdersServiceImpl ordersService = new OrdersServiceImpl();
	
	@Autowired
	private PaymentServiceImpl paymentService = new PaymentServiceImpl();
	
	@Autowired
	private DeliveryServiceImpl deliService = new DeliveryServiceImpl();
	
	@RequestMapping(value = "listcart")
	public ModelAndView Index() {
		mvShare.setViewName("user/cart/list_cart");
		mvShare.addObject("slides", _HomeService.GetDataSlides());
		mvShare.addObject("categories", _HomeService.GetDataCategories());
		mvShare.addObject("new_products", _HomeService.GetNewProducts());
		mvShare.addObject("highlight_products", _HomeService.GetHighLightProducts());
		return mvShare;
	}
	
	@RequestMapping(value = "addCart/{id}")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>)session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.addCart(id, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "listcart/editCart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable String id, @PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>)session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.editCart(id, quantity, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "deleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>)session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.deleteCart(id, cart);
		session.setAttribute("ShoppingCart", cart);
		session.setAttribute("TotalQuantityCart", cartService.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkOut(HttpServletRequest request, HttpSession session) {
		try {
			mvShare.setViewName("user/bills/checkout");
			Orders orders = new Orders();
			Accounts loginInfo = (Accounts)session.getAttribute("loginInfo");
			if(loginInfo != null) {
				orders.setName_receiver(loginInfo.getName());
				orders.setEmail(loginInfo.getEmail());
				orders.setAddress_receiver(loginInfo.getAddress());
				orders.setPhone_receiver(loginInfo.getPhone());
			}
			mvShare.addObject("orders", orders);
			
			mvShare.addObject("payment", paymentService.getDataPayment());
			mvShare.addObject("errorLogin",null);
			
			mvShare.addObject("deli_ser", deliService.getDataDeliService());
		} catch (Exception e) {
			mvShare.addObject("errorLogin","Vui lòng đăng nhập trước khi đặt hàng hoặc kiểm tra lại giỏ hàng!");
			mvShare.setViewName("user/bills/checkout");
		}
		
		
		return mvShare;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ModelAndView checkOutBills(HttpServletRequest request, HttpSession session, @ModelAttribute("orders") Orders order) {
		try {
			order.setQuantity(Double.parseDouble(session.getAttribute("TotalPriceCart").toString()));
			order.setTotal(Double.parseDouble(session.getAttribute("TotalQuantityCart").toString()));
			Accounts loginInfo = (Accounts)session.getAttribute("loginInfo");
			order.setAcc_id(loginInfo.getAcc_id());
			if(ordersService.addOrders(order) > 0) {
				HashMap<String, CartDto> carts = (HashMap<String, CartDto>)session.getAttribute("ShoppingCart");
				ordersService.addOrdersDetail(carts);
			}
			session.removeAttribute("ShoppingCart");
			session.setAttribute("TotalQuantityCart", 0);
			session.setAttribute("TotalPriceCart", 0);
			mvShare.addObject(loginInfo);
			mvShare.addObject("errorLogin","Đã đặt hàng thành công!!!!");
		} catch (Exception e) {
			mvShare.addObject("errorLogin","Vui lòng đăng nhập trước khi đặt hàng hoặc kiểm tra lại giỏ hàng!");
			mvShare.setViewName("user/bills/checkout");
		}
		return mvShare;
	}
}
