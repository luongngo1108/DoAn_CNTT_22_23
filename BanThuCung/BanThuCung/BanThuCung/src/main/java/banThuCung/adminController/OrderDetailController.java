package banThuCung.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Entities.Order_detail;
import banThuCung.adminService.OrderServiceImp;
import banThuCung.adminService.ProductServiceImpAd;
import banThuCung.adminService.PropertyServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/don-hang/chi-tiet-don-hang")
public class OrderDetailController {
	@Autowired
	OrderServiceImp orderService = new OrderServiceImp();

	@Autowired
	ProductServiceImpAd productService = new ProductServiceImpAd();

	@Autowired
	PropertyServiceImp propertyService = new PropertyServiceImp();

	@RequestMapping("/orderDetailForm")    
	public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		mv.addObject("orderDetail", new Order_detail());
		mv.addObject("orderList", orderService.getOrders());
		mv.addObject("productList", productService.getAllProducts());
		mv.addObject("propertyList", propertyService.getAllProperties());
		session.setAttribute("errorDelOrderDetailMessage", null);
		mv.setViewName("admin/OrderDetailForm");

		return mv;   
	} 

	@RequestMapping( value="/update",method = RequestMethod.POST)    
	public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("orderDetail") Order_detail order_detail){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}	

		try {
			orderService.updateOrderDetail(order_detail);
			mv.setViewName("redirect:/quan-tri/don-hang/chi-tiet-don-hang/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.addObject("orderList", orderService.getOrders());
			mv.addObject("productList", productService.getAllProducts());
			mv.addObject("propertyList", propertyService.getAllProperties());
			mv.setViewName("admin/OrderDetailForm"); 
		}

		return mv;    
	} 

	@RequestMapping(value = "/delete/{id}") 
	public ModelAndView delete(HttpSession session, @PathVariable String id, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		try {
			orderService.deleteOrderDetail(id);	
			System.out.println(id);
			session.setAttribute("errorDelOrderDetailMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelOrderDetailMessage", errorString);
		}

		mv.setViewName("redirect:/quan-tri/don-hang/chi-tiet-don-hang/list");
		return mv;
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		List<Order_detail> order_details =  orderService.getOrderDetails(); 
		mv.addObject("orderDetailList", order_details);
		mv.setViewName("admin/OrderDetailList");
		return mv;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("orderDetail") Order_detail order_detail,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		try {
			orderService.createOrderDetail(order_detail);
			mv.setViewName("redirect:/quan-tri/don-hang/chi-tiet-don-hang/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			order_detail.setOrder_id(null);
			mv.addObject("orderDetail", order_detail);
			mv.addObject("orderList", orderService.getOrders());
			mv.addObject("productList", productService.getAllProducts());
			mv.addObject("propertyList", propertyService.getAllProperties());
			mv.setViewName("admin/OrderDetailForm");
		}  
		return mv;
	}

	@RequestMapping(value="/edit/{id}")    
	public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		Order_detail order_detail = orderService.getOrderDetailByID(id); 
		session.setAttribute("errorDelOrderDetailMessage", null);
		mv.addObject("orderDetail", order_detail);
		mv.addObject("orderList", orderService.getOrders());
		mv.addObject("productList", productService.getAllProducts());
		mv.addObject("propertyList", propertyService.getAllProperties());
		mv.setViewName("admin/OrderDetailForm");
		return mv;    
	}  
}
