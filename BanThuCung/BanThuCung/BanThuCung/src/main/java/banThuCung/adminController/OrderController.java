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

import banThuCung.Entities.Orders;
import banThuCung.adminService.AccountServiceImpAd;
import banThuCung.adminService.DeliServiceServiceImp;
import banThuCung.adminService.OrderServiceImp;
import banThuCung.adminService.PaymentServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/don-hang/cac-don-hang")
public class OrderController {
	@Autowired
	OrderServiceImp orderService = new OrderServiceImp();
	
	@Autowired
	AccountServiceImpAd accountService = new AccountServiceImpAd();
	
	@Autowired
	PaymentServiceImp paymentService = new PaymentServiceImp();
	
	@Autowired
	DeliServiceServiceImp deliServiceService = new DeliServiceServiceImp();
	
	@RequestMapping("/orderForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("order", new Orders());
		mv.addObject("cusAccList", accountService.getCusAccounts());
		mv.addObject("payList", paymentService.getPayments());
		mv.addObject("deliServiceList", deliServiceService.getDeliServices());
		session.setAttribute("errorDelOrderMessage", null);
        mv.setViewName("admin/OrderForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("order") Orders order){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	orderService.updateOrders(order);
        	mv.setViewName("redirect:/quan-tri/don-hang/cac-don-hang/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.addObject("cusAccList", accountService.getCusAccounts());
			mv.addObject("payList", paymentService.getPayments());
			mv.addObject("deliServiceList", deliServiceService.getDeliServices());
			mv.setViewName("admin/OrderForm");
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
			orderService.deleteOrder(id);	
			session.setAttribute("errorDelOrderMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelOrderMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/don-hang/cac-don-hang/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<Orders> orders =  orderService.getOrders(); 
		mv.addObject("orderList", orders);
		mv.setViewName("admin/OrderList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("order") Orders order,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	orderService.createOrders(order);
        	mv.setViewName("redirect:/quan-tri/don-hang/cac-don-hang/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			order.setOrder_id(null);
			mv.addObject("order", order);
			mv.addObject("cusAccList", accountService.getCusAccounts());
			mv.addObject("payList", paymentService.getPayments());
			mv.addObject("deliServiceList", deliServiceService.getDeliServices());
			mv.setViewName("admin/OrderForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        Orders order=orderService.getOrdersByID(id); 
        session.setAttribute("errorDelOrderMessage", null);
        mv.addObject("order", order);
        mv.addObject("cusAccList", accountService.getCusAccounts());
        mv.addObject("payList", paymentService.getPayments());
		mv.addObject("deliServiceList", deliServiceService.getDeliServices());
        mv.setViewName("admin/OrderForm");
        return mv;    
    }  
}
